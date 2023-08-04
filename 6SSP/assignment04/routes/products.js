const express = require('express');
const path = require('path');
const fs = require('fs');

const router = express.Router();

const productsPage = fs.readFileSync(path.join(__dirname, '..', 'public', 'views', 'products.html'))

router.get('/', (req, res, next) => {
  res.write(productsPage);
  res.end()
});

router.post('/', (req, res, next) => {
  res.send('POST request to /products');
});

module.exports = router;