const successResponse = function(res, message){
  return res.status(200).json(message);
}

const errorResponse = function(res, error){
  res.status(error.status || 500).json({message: error.message});
}

const createError = function(status, message){
  const error = new Error(message);
  error.status = status;
  throw error;
}

module.exports = {
  successResponse,
  errorResponse,
  createError
}