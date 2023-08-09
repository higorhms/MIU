const express = require('express');
const router = express.Router();

const bookController = require('../controllers/bookController')

router.route('/')
  .get(bookController.find)
  .post(bookController.addOne);

router.route('/:id')
  .get(bookController.getById)
  .delete(bookController.deleteById)
  .put(bookController.updateById)
  
module.exports = router;