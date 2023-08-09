const mongoose = require('mongoose');

const Book = mongoose.model('Book')

const find = async (req, res) => {
  const books = await Book.find();
  return res.status(200).json(books);
}

const addOne = async (req, res) => {
  const { title, ISBN, publishedDate, author } = req.body;
  await Book.create({
    title,
    ISBN,
    publishedDate,
    author
  })
  return res.status(204).send();
}

const getById = async (req, res) => {
  const { id } = req.params;
  if (!mongoose.isValidObjectId(id)) return res.status(400).send("Invalid ID")
  const book = await Book.findById(id);
  if (!book) return res.status(404).send();
  res.status(200).json(book);
}

const deleteById = async (req, res) => {
  const { id } = req.params;
  if (!mongoose.isValidObjectId(id)) return res.status(400).send("Invalid ID")
  const book = await Book.findById(id);
  if (!book) return res.status(404).send();
  await Book.deleteOne({_id: id})
  res.status(204).send();
}

const updateById = async (req, res) => {
  const { id } = req.params;
  const { title, ISBN, publishedDate, author } = req.body;
  if (!mongoose.isValidObjectId(id)) return res.status(400).send("Invalid ID")
  const book = await Book.findById(id);
  if (!book) return res.status(404).send();
  if (title) book.title = title;
  if (ISBN) book.ISBN = ISBN;
  if (publishedDate) book.publishedDate = publishedDate;
  if (author) book.author = author;
  await book.save();
  return res.status(204).send();
}

module.exports = {
  find,
  addOne,
  getById,
  deleteById,
  updateById
}