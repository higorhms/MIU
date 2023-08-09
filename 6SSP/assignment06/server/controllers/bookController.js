const { ObjectId } = require('mongodb');
const dbConnection = require('../database');
const Book = require('../models/book')

const _getBooksCollection = () => {
  return dbConnection.get().collection('books');
}

const find = async (req, res) => {
  const books = await _getBooksCollection().find().toArray();
  return res.status(200).json(books);
}

const addOne = async (req, res) => {
  const { title, ISBN, publishedDate, author } = req.body;
  const book = new Book(
    title,
    ISBN,
    publishedDate,
    author
  );
  await _getBooksCollection().insertOne(book);
  return res.status(204).send();
}

const getById = async (req, res) => {
  const { id } = req.params;
  if (!ObjectId.isValid(id)) return res.status(400).send("Invalid ID")
  const book = await _getBooksCollection().findOne({ _id: new ObjectId(id) });
  if (!book) return res.status(404).send();
  res.status(200).json(book);
}

const deleteById = async (req, res) => {
  const { id } = req.params;
  if (!ObjectId.isValid(id)) return res.status(400).send("Invalid ID")
  const book = await _getBooksCollection().findOne({ _id: new ObjectId(id) });
  if (!book) return res.status(404).send();
  await _getBooksCollection().deleteOne({ _id: new ObjectId(id) });
  res.status(204).send();
}

const updateById = async (req, res) => {
  const { id } = req.params;
  const { title, ISBN, publishedDate, author } = req.body;
  if (!ObjectId.isValid(id)) return res.status(400).send("Invalid ID")
  const book = await _getBooksCollection().findOne({ _id: new ObjectId(id) });
  if (!book) return res.status(404).send();
  const updates = {};
  if (title) updates.title = title;
  if (ISBN) updates.ISBN = ISBN;
  if (publishedDate) updates.publishedDate = publishedDate;
  if (author) updates.author = author;
  await _getBooksCollection().updateOne({ _id: new ObjectId(id) }, { $set: updates });
  return res.status(204).send();
}

module.exports = {
  find,
  addOne,
  getById,
  deleteById,
  updateById
}