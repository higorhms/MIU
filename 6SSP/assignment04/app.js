const express = require('express');
const fs = require('fs');
const path = require('path');

const app = express();
const usersRouter = require('./routes/users');
const productsRouter = require('./routes/products');

const errorPage = fs.readFileSync(path.join(__dirname, 'public', 'views', '404.html'))

app.use(express.urlencoded({ extended: true }))

app.use(express.static('public'));

app.use('/users', usersRouter);
app.use('/products', productsRouter);

app.use((req, res, next) => {
  res.write(errorPage)
  res.status(404).end();
});

app.use((err, req, res, next) => {
  console.log(err)
  res.status(500).send('Internal Server Error');
});

app.listen(3000, () => {
  console.log('App is listening on port 3000!')
});

module.exports = app;