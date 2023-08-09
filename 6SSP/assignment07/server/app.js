const express = require('express');
const cors = require('cors');
require('./database');
const bookRouter = require('./routes/book');

const app = express();

app.use(cors())
app.use(express.json());

app.use('/books', bookRouter);

app.listen(3000, () => console.log('listening to 3000...'));
