// '+', '-', '*', '/', '%', '**'.
function solve(fisrtNum, secondNum, operator) {
  let result;
  switch (operator) {
    case "+":
      result = fisrtNum + secondNum;
      break;
    case "-":
      result = fisrtNum - secondNum;
      break;
    case "*":
      result = fisrtNum * secondNum;
      break;
    case "/":
      result = fisrtNum / secondNum;
      break;
    case "%":
      result = fisrtNum % secondNum;
      break;
    case "**":
      result = fisrtNum ** secondNum;
      break;
  }
  console.log(result);
}

