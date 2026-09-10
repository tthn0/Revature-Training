-- 1. Get all invoice ids with the customers first name, last name, and the invoice total

SELECT i.invoice_id,
       c.first_name,
       c.last_name,
       i.total
FROM invoice i
INNER JOIN customer c ON c.customer_id = i.customer_id;

-- 2. Print the invoice id, customer's first name, and invoice total. But only if the invoice is over $30.

SELECT i.invoice_id,
       c.first_name,
       i.total
FROM invoice i
INNER JOIN customer c ON c.customer_id = i.customer_id
WHERE i.total > 30;

-- 3. Get all the invoices for USA customers in the last 6 months. Use a CTE.

WITH usa_customers AS (
    SELECT customer_id
    FROM customer
    WHERE country = 'USA'
),
recent_invoices AS (
    SELECT *
    FROM invoice
    WHERE invoice_date >= NOW() - INTERVAL '6 months'
)
SELECT i.*
FROM recent_invoices i
INNER JOIN usa_customers c ON c.customer_id = i.customer_id;

-- Create a new table called record_logs
-- Fields: log_id, record_id, field_changed, last_update, old_value, new_value

DROP TABLE IF EXISTS record_logs;
CREATE TABLE record_logs (
    log_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    record_id INT NOT NULL REFERENCES customer(customer_id),
    field_changed TEXT NOT NULL,
    last_update TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP NOT NULL,
    old_value TEXT,
    new_value TEXT
);

-- Create a trigger that tracks changes to customer records and logs the changes in our new table
-- (I used AI to help with this)

CREATE OR REPLACE FUNCTION log_table_changes()
RETURNS TRIGGER
LANGUAGE plpgsql
AS $$
DECLARE
    pk_col TEXT := COALESCE(TG_ARGV[0], 'id'); -- Default PK column name if not provided
    rec_id INT;
    key TEXT;
    old_val TEXT;
    new_val TEXT;
BEGIN
    -- Dynamically retrieve the record ID based on the passed PK column name
    rec_id := (to_jsonb(NEW) ->> pk_col)::INT;

    FOR key, new_val IN SELECT * FROM jsonb_each_text(to_jsonb(NEW))
    LOOP
        old_val := to_jsonb(OLD) ->> key;

        IF old_val IS DISTINCT FROM new_val THEN
            INSERT INTO record_logs (record_id, field_changed, last_update, old_value, new_value)
            VALUES (rec_id, key, NOW(), old_val, new_val);
        END IF;
    END LOOP;

    RETURN NEW;
END;
$$;

CREATE TRIGGER customer_audit_trigger
AFTER UPDATE ON customer
FOR EACH ROW
EXECUTE FUNCTION log_table_changes('customer_id');