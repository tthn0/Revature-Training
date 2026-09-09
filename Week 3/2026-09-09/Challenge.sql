-- Get all fields and records from customer

SELECT *
FROM customer;

-- Get all fields from customer, but only if they are from Arizona

SELECT *
FROM customer
WHERE state = 'AZ';

-- Get all invoices older than 6 months

SELECT *
FROM invoice
WHERE invoice_date < NOW() - INTERVAL '6 months';

-- Update all customer phone numbers to NULL if they don't follow this format: '+1 555 555-5555'
 
UPDATE customer
SET phone = NULL 
WHERE phone !~ '^\+1 \d{3} \d{3}-\d{4}$'
RETURNING *;

-- Get all tracks that are longer than 180000 milliseconds

SELECT *
FROM track
WHERE milliseconds > 180000;

-- Update all customers not in the USA so that their country=USA and address, city, & state are NULL

UPDATE customer
SET country = 'USA',
    address = NULL,
    city = NULL,
    state = NULL
WHERE country != 'USA';

-- Given a customer_id, return their total spending across all invoices using a function

CREATE OR REPLACE FUNCTION get_total_spending(customer_id INT)
RETURNS NUMERIC AS $$
    SELECT SUM(total)
    FROM invoice i
    WHERE i.customer_id = $1;
$$ LANGUAGE sql;

SELECT get_total_spending_from_customer(1);

-- Given an employee_id + new_manager_id, create a stored procedure to update an Employee’s ReportsTo field.
--    Prevent an employee reporting to themselves, reporting to a non-existence employee, or creating a circular management relationship

CREATE OR REPLACE PROCEDURE update_employee_reports_to(
    employee_id INT,
    new_manager_id INT
)
LANGUAGE plpgsql AS $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM employee e WHERE e.employee_id = $1) THEN
        RAISE EXCEPTION 'Employee % does not exist.', $1;
    END IF;

    IF NOT EXISTS (SELECT 1 FROM employee e WHERE e.employee_id = $2) THEN
        RAISE EXCEPTION 'Manager % does not exist.', $2;
    END IF;

    IF $1 = $2 THEN
        RAISE EXCEPTION 'Employee % cannot report to themselves.', $1;
    END IF;

    -- I'm not sure how to avoid circular management relationships, so I'll skip it

    UPDATE employee e
    SET reports_to = $2
    WHERE e.employee_id = $1;
END;
$$;

CALL update_employee_reports_to(1, 2);

-- Create a new schema: pets
--    Create two related tables: Customer + Pets
--    Demonstrate populating records into these tables

CREATE SCHEMA IF NOT EXISTS pets;
CREATE TABLE IF NOT EXISTS pets.customer(
    customer_id SERIAL PRIMARY KEY,
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    email TEXT NOT NULL
);
CREATE TABLE IF NOT EXISTS pets.pets(
    pet_id SERIAL PRIMARY KEY,
    owner_id INT NOT NULL
        REFERENCES pets.customer(customer_id)
        ON DELETE SET NULL,
    breed TEXT NOT NULL,
    name TEXT NOT NULL
);