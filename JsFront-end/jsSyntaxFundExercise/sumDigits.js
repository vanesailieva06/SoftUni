function sum(strNumber) {
  let strNum = strNumber.toString();
  let numArr = strNum.split("");
  let result = 0;
  for (let i = 0; i < numArr.length; i++) {
    let number = Number(numArr[i]);
    result += number;
  }
  console.log(result);
}

