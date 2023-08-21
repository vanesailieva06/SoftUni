function smallestNum(firstNum, secondNum, thirdNum) {
  let smallestNum = firstNum;
  if (secondNum < firstNum && secondNum < thirdNum) {
    smallestNum = secondNum;
  }
  if (thirdNum < firstNum && thirdNum < secondNum) {
    smallestNum = thirdNum;
  }
  console.log(smallestNum);
}
