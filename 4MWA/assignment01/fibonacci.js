const fibonacci = function(value) {
  if(value < 0) value = -value;

  if (value <= 1) return value;

  return fibonacci(value - 1) + fibonacci(value - 2);
}

module.exports = fibonacci;