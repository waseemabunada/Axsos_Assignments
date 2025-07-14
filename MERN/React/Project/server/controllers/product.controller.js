
const Product = require("../models/product.model");

module.exports.createProduct = (req, res) => {
  const { title, price, description } = req.body;

  Product.create({ title, price, description })
    .then(product => res.json(product))
    .catch(err => {
      console.error("❌ Error creating product:", err);
      res.status(400).json(err);
    });
};

module.exports.getAllProduct = (req, res) => {
  Product.find({})
    .then(products => res.json(products))
    .catch(err => res.status(500).json(err));
};

module.exports.getProduct = (req, res) => {
  Product.findOne({ _id: req.params.id })
    .then(product => {
      if (!product) return res.status(404).json({ message: "Product not found" });
      res.json(product);
    })
    .catch(err => res.status(500).json(err));
};

module.exports.updateProduct = (req, res) => {
  Product.findOneAndUpdate({ _id: req.params.id }, req.body, { new: true, runValidators: true })
    .then(updatedProduct => res.json(updatedProduct))
    .catch(err => res.status(400).json(err));
};

module.exports.deleteProduct = (req, res) => {
  Product.deleteOne({ _id: req.params.id })
    .then(result => res.json(result))
    .catch(err => res.status(500).json(err));
};
