const successResponse = function(res, msg){
  res.status(200).json(msg);
}

const errorResponse = function(res, error){
  res.status(error.status || 500).json({message: error.message});
}

const createError = function(status, msg){
  const error = new Error(msg);
  error.status = status;
  throw error;
}

module.exports = {
  successResponse,
  createError,
  errorResponse
}