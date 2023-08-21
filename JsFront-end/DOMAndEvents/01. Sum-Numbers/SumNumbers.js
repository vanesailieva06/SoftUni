function calc() {
  let num1Str = document.getElementById("num1");
  let num2Str = document.getElementById("num2");
  let num1 = Number(num1Str.value);
  let num2 = Number(num2Str.value);
  let sumStr = document.getElementById("sum");
  let sum = Number(sumStr);
  sum = num1 + num2;
  sumStr.value = sum;
}
