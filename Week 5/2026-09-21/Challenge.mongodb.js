const gadgetDb = db.getSiblingDB("gadgetStore");
gadgetDb.products.drop();
gadgetDb.createCollection("products", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["name", "price", "inStock", "specs"],
      additionalProperties: true,
      properties: {
        name: {
          bsonType: "string",
          description: "must be a string and is required",
        },
        price: {
          bsonType: ["int", "double"],
          description: "must be an integer or double and is required",
        },
        inStock: {
          bsonType: "bool",
          description: "must be a boolean and is required",
        },
        specs: {
          bsonType: "object",
          description: "must be an object",
          required: ["brand"],
          properties: {
            brand: {
              bsonType: "string",
              description: "brand must be a string and is required",
            },
          },
        },
      },
    },
  },
  validationAction: "error",
});

gadgetDb.products.insertMany([
  {
    name: "Wireless Mouse",
    price: 49.99,
    inStock: true,
    specs: {
      brand: "Logitech",
    },
  },
  {
    name: "Mechanical Keyboard",
    price: 149.99,
    inStock: true,
    specs: {
      brand: "Dell",
    },
  },
  {
    name: "Gaming Monitor",
    price: 499.99,
    inStock: true,
    specs: {
      brand: "LG",
    },
  },
]);

// gadgetDb.products.insertOne({
//   invalidField:
//     "This document should get rejected because it doesn't have required fields",
// });

const wirelessMouse = gadgetDb.products.findOne({
  name: "Wireless Mouse",
});
gadgetDb.products.updateOne(
  { _id: wirelessMouse._id },
  {
    $set: { category: "Accessories" },
    $inc: { price: 15 },
    $push: { tags: { $each: ["wireless", "bestseller"] } },
  },
);
gadgetDb.products.updateOne(
  { _id: wirelessMouse._id },
  {
    $pull: { tags: "wireless" },
  },
);

const expensiveProducts = gadgetDb.products.find({
  price: { $gte: 100 },
});
console.log(expensiveProducts);

const lgProducts = gadgetDb.products.find({
  "specs.brand": "LG",
});
console.log(lgProducts);

const accessoryProducts = gadgetDb.products.find({
  category: {
    $in: ["Accessories"],
  },
});
console.log(accessoryProducts);
