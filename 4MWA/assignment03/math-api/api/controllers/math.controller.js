const multiply = (req, res) => {
  let firstNumber = 0;
  let secondNumber = 0;

  if(req.params && req.params.firstNumber){
    firstNumber = parseFloat(req.params.firstNumber);
  }

  if(req.query && req.query.secondNumber){
    secondNumber = parseFloat(req.query.secondNumber);
  }

  res.status(200).json({result: firstNumber * secondNumber})
}

module.exports = {
  multiply
}