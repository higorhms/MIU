const express = require('express');
const cors = require('cors');
require('./database');
const bookRouter = require('./routes/book');
const userRouter = require('./routes/user');
const authController = require('./controllers/authController')

const app = express();

app.use(cors())
app.use(express.json());

app.post('/login', authController.login);
app.use(userRouter)
app.use(authController.authorize);
app.use('/books', bookRouter);

app.listen(3000, () => console.log('listening to 3000...'));
