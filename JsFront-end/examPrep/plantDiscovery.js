function solve(input) {
  let n = Number(input.shift());
  let plantMap = {};
  for (let index = 0; index < n; index++) {
    let [plant, rarity, rating] = input.shift().split("<->");
    rating = 0.0;
    plantMap[plant] = { rarity, rating };
  }
  ratingCount = 0;

  input.forEach((line) => {
    if (line === "Exhibition") {
      return;
    }
    let command = line.split(": ");
    let tokens = command[1].split(" - ");
    if (command === "Rate") {
        let plant = tokens.shift();
        let newRating = tokens.shift();
        plantMap[plant].rating += newRating;
    } else if (command === "Update") {
        let plant = tokens.shift();
        let rarity = tokens.shift();
        plantMap[plant].rarity = rarity;
    } else if (command === "Reset") {
        let plant = tokens.shift();
        plantMap[plant].rating = 0;
    }
  });
  console.log('Plants for the exhibition:');
  let entries = Object.entries(plantMap)
  for (const [plant, info] of entries) {
    let averageRating = info.rarity.reduce((total, num) => total + num);
    console.log(`${plant}; Rarity: ${info.rarity}; Rating: ${averageRating}`)
  }
}
solve([
  "3",
  "Arnoldii<->4",
  "Woodii<->7",
  "Welwitschia<->2",
  "Rate: Woodii - 10",
  "Rate: Welwitschia - 7",
  "Rate: Arnoldii - 3",
  "Rate: Woodii - 5",
  "Update: Woodii - 5",
  "Reset: Arnoldii",
  "Exhibition",
]);
