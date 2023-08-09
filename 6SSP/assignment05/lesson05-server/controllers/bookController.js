const Book = require('../models/book')

const find = (req, res) => {
  const books = Book.find();
  res.status(201).json(books);
}

const addOne = (req, res) => {
  const { title, ISBN, publishedDate, author } = req.body;
  const book = new Book(
    title,
    ISBN,
    publishedDate,
    author
  );
  book.save();
  res.status(204).send();
}

const getById = (req, res) => {
  const { id } = req.params;  
  const book = Book.getById(+id);
  if(!book) return res.status(404).send();
  res.status(200).json(book);
}

const deleteById = (req, res) => {
  const { id } = req.params;  
  const book = Book.getById(+id);
  if(!book) return res.status(404).send();
  Book.deleteById(+id);
  res.status(204).send();
}

module.exports = {
  find,
  addOne,
  getById,
  deleteById
}