function solve(number1, number2, number3) {
  let biggestNum;
  if (number1 > number2 && number1 > number3) {
    biggestNum = number1;
  } else if (number2 > number1 && number2 > number3) {
    biggestNum = number2;
  } else if (number3 > number1 && number3 > number2) {
    biggestNum = number3;
  }
  console.log(`The largest number is ${biggestNum}.`);
}
