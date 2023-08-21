function sum(startNum, endNum) {
  let sum = 0;
  let result = [];
  for (let i = startNum; i <= endNum; i++) {
    sum += i;
    result.push(i);
  }

  console.log(result.join(" "));
  console.log(`Sum: ${sum}`);
}
