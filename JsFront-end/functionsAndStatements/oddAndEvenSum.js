function oddAndEven(number) {
  let numStr = number.toString().split("");
  let oddSum = 0;
  let evenSum = 0;
  for (let i = 0; i < numStr.length; i++) {
    let num = Number(numStr[i]);
    if (num % 2 === 0) {
      evenSum += num;
    } else {
      oddSum += num;
    }
  }
  console.log(`Odd sum = ${oddSum}, Even sum = ${evenSum}`);
}

