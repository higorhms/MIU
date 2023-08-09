const database = [];
let bookIds = 1;

class Book{
  id; 
  title; 
  ISBN; 
  publishedDate; 
  author

  constructor(title, ISBN, publishedDate, author){
    this.title = title;
    this.ISBN = ISBN;
    this.publishedDate = publishedDate;
    this.author = author;
  }

  save(){
    this.id = bookIds;
    database.push(this);
    bookIds++;
  }

  static getById(id){
    return database.find(book => id === book.id);
  }

  static deleteById(id){
    const bookIndex = database.findIndex(book => book.id === this.id);
    database.splice(bookIndex, 1)
  }

  static update(){
    const bookIndex = database.findIndex(book => book.id === this.id);
    database[bookIndex] = this;
  }

  static find(){
    return database;
  }
}

module.exports = Book;