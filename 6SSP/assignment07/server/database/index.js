const mongoose = require('mongoose')
require('../models/book')

mongoose.connect('mongodb://localhost:27017/books');

mongoose.connection.on('connected', () => {
  console.log('Connected to database...')
})
