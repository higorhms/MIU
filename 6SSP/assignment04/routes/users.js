const express = require('express');
const path = require('path');
const fs = require('fs');

const router = express.Router();

const userPage = fs.readFileSync(path.join(__dirname, '..', 'public', 'views', 'users.html'))

router.get('/', (req, res, next) => {
  res.write(userPage);
  res.end();
});

router.post('/', (req, res, next) => {
  res.send('POST request to /users');
});

module.exports = router;