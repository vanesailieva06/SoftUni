function solve(input) {
  let n = input.shift();
  let carMap = {};
  for (let i = 0; i < n; i++) {
    let [car, mileage, fuel] = input.shift().split("|");
    let mileageNum = Number(mileage);
    let fuelNum = Number(fuel);
    carMap[car] = { mileageNum, fuelNum };
  }

  input.forEach((line) => {
    if (line === "Stop") {
      return;
    }
    let tokens = line.split(" : ");
    let command = tokens.shift();
    if (command === "Drive") {
      let [car, distance, fuel] = tokens;
      if (Number(carMap[car].fuelNum) < Number(fuel)) {
        console.log(`Not enough fuel to make that ride`);
      } else {
        carMap[car].mileageNum += Number(distance);
        carMap[car].fuelNum -= Number(fuel);
        console.log(
          `${car} driven for ${distance} kilometers. ${fuel} liters of fuel consumed.`
        );
      }

      if (Number(carMap[car].mileageNum) >= 100000) {
        delete carMap[car];
        console.log(`Time to sell the ${car}!`);
      }
    } else if (command === "Refuel") {
      let [car, fuel] = tokens;
      let totalFuel = carMap[car].fuelNum + Number(fuel);
      if (totalFuel > 75) {
        fuel = Number(fuel) - (totalFuel - 75);
      }
      carMap[car].fuelNum += Number(fuel);
      console.log(`${car} refueled with ${fuel} liters`);
    } else if (command === "Revert") {
      let [car, km] = tokens;
      carMap[car].mileageNum -= Number(km);
      if (carMap[car].mileageNum <= 10000) {
        carMap[car].mileageNum = 10000;
      } else {
        console.log(`${car} mileage decreased by ${km} kilometers`);
      }
    }
  });
  let entries = Object.entries(carMap);
  for (const [car, value] of entries) {
    console.log(
      `${car} -> Mileage: ${value.mileageNum} kms, Fuel in the tank: ${value.fuelNum} lt.`
    );
  }
}
solve([
  "3",
  "Audi A6|38000|62",
  "Mercedes CLS|11000|35",
  "Volkswagen Passat CC|45678|5",
  "Drive : Audi A6 : 543 : 47",
  "Drive : Mercedes CLS : 94 : 11",
  "Drive : Volkswagen Passat CC : 69 : 8",
  "Refuel : Audi A6 : 50",
  "Revert : Mercedes CLS : 500",
  "Revert : Audi A6 : 30000",
  "Stop",
]);
