const jwt = require('jsonwebtoken');
const User = require('../models/user');

const accessTokenSecret = 'MSD CS477';

const login = async (req, res, next) => {
  const user = await User.findOne({ username: req.body.username, password: req.body.password });
  if (!user) return res.status(401).json({ 'error': 'username or password is invalid' });
  const accessToken = jwt.sign({ username: user.username, role: user.role }, accessTokenSecret);
  return res.status(200).json({ accessToken });
}

const authorize = async (req, res, next) => {
  const authHeader = req.headers.authorization;
  if (!authHeader) return res.status(401).json({ 'error': 'Please login' });
  const [, token] = authHeader.split(' ');
  jwt.verify(token, accessTokenSecret, (err, user) => {
    if (err) return res.status(403).json({ 'error': 'Unauthorized' });
    req.user = user;
    next();
  })
}

module.exports = {
  login,
  authorize
}