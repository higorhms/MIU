const mongoose = require("mongoose");
const constants = require("../constants");
const {
  successResponse,
  errorResponse,
  validatePaginationParams
} = require("./utils/controller.utils");

const Tweet = mongoose.model(process.env.TWEET_MODEL);
const User = mongoose.model(process.env.USER_MODEL);

const findAll = function (req, res) {
  const userId = req.userId;

  validatePaginationParams(req.query.offset, req.query.count)
    .then(({ page, count }) => Tweet.find().sort('-date').skip(page).limit(count).populate('author', '_id username').exec())
    .then((tweets) => _filterByOwnOrUsersYouFollowTweets(tweets, userId))
    .then((tweets) => successResponse(res, tweets))
    .catch((error) => errorResponse(res, error))
}

const insertOne = function (req, res) {
  const userId = req.userId;

  _fillTweet(req.body, userId)
    .then((tweet) => Tweet.create(tweet))
    .then((tweet) => successResponse(res, tweet, constants.CREATE_STATUS))
    .catch((error) => errorResponse(res, error))
}

const _fillTweet = function (data, userId) {
  return new Promise((resolve) => {
    const newTweet = {};
    if (data.description) newTweet.description = data.description;
    newTweet.date = new Date();
    newTweet.author = userId;
    resolve(newTweet);
  })
}

const _filterByOwnOrUsersYouFollowTweets = function (tweets, userId) {
  return new Promise((resolve) => {
    User.findById(userId).then(user => {
      const filteredTweets = tweets.filter(tweet =>
        tweet.author._id.toString() === userId || user.following.includes(tweet.author._id)
      );
      resolve(filteredTweets);
    })
  })
}

module.exports = {
  findAll,
  insertOne,
}