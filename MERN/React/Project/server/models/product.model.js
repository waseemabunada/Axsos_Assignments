const mongoose = require("mongoose");

const productSchema = new mongoose.Schema({
  title: {
    type: String,
    required: [true, "Title is required."],
    unique: [true, "Title must be unique."],
    index: true,
    minlength: [3, "Title must be more than 3 chars."],
    maxlength: [50, "Title cannot be more than 50 chars."],
  },
  price: {
    type: Number,
    required: [true, "Price is required."],
    min: [0, "Price must be a positive number"],
  },
  description: {
    type: String,
    required: [true, "Description is required."],
    minlength: [3, "Description must be more than 3 chars."],
    maxlength: [200, "Description cannot be more than 200 chars."],
  },
  createdAt: {
    type: Date,
    default: Date.now,
  },
  updatedAt: {
    type: Date,
    default: Date.now,
  },
});

productSchema.pre("save", function (next) {
  this.updatedAt = Date.now();
  next();
});

const Product = mongoose.model("Product", productSchema);

module.exports = Product;
