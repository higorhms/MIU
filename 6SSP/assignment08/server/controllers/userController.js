const User = require('../models/user')

const addOne = async (req, res) => {
  const { username, password } = req.body;
  const user = User.findOne({username})
  if(user) return res.status(400).send("User already exist");
  await User.create({username, password})
  return res.status(204).send();
}

module.exports = {
  addOne,
}