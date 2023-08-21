function charsInRange(fristChar, lastChar) {
  let asciiFirstChar = fristChar.charCodeAt();
  let asciiLastChar = lastChar.charCodeAt();
  if (asciiFirstChar > asciiLastChar) {
    let temp = asciiFirstChar;
    asciiFirstChar = asciiLastChar;
    asciiLastChar = temp;
  }
  let result = [];
  for (let i = asciiFirstChar + 1; i < asciiLastChar; i++) {
    result.push(String.fromCharCode(i));
  }
  console.log(result.join(" "));
}

