function solve(input) {
  let citiesMap = {};
  while (input[0] !== "Sail") {
    let [city, population, gold] = input.shift().split("||");
    let populationInt = Number(population);
    let goldInt = Number(gold);
    if (!citiesMap.hasOwnProperty(city)) {
      citiesMap[city] = { populationInt, goldInt };
    } else {
      citiesMap[city].populationInt += Number(population);
      citiesMap[city].goldInt += Number(gold);
    }
  }
  input.shift(); //to remove 'Sail'
  while (input[0] !== "End") {
    let tokens = input.shift().split("=>");
    let command = tokens.shift();
    if (command === "Plunder") {
      let [city, population, gold] = tokens;
      citiesMap[city].populationInt -= Number(population);
      citiesMap[city].goldInt -= Number(gold);
      console.log(
        `${city} plundered! ${gold} gold stolen, ${population} citizens killed.`
      );
      if (
        citiesMap[city].populationInt === 0 ||
        citiesMap[city].goldInt === 0
      ) {
        delete citiesMap[city];
        console.log(`${city} has been wiped off the map!`);
        continue;
      }
    } else if (command === "Prosper") {
      let [city, gold] = tokens;
      if (gold < 0) {
        console.log(`Gold added cannot be a negative number!`);
        continue;
      }
      citiesMap[city].goldInt += Number(gold);
      console.log(
        `${gold} gold added to the city treasury. ${city} now has ${citiesMap[city].goldInt} gold.`
      );
    }
  }
  console.log(
    `Ahoy, Captain! There are ${
      Object.keys(citiesMap).length
    } wealthy settlements to go to:`
  );
  let entries = Object.entries(citiesMap);
  for (const [city, info] of entries) {
    console.log(
      `${city} -> Population: ${info.populationInt} citizens, Gold: ${info.goldInt} kg`
    );
  }
}
solve([
  "Nassau||95000||1000",
  "San Juan||930000||1250",
  "Campeche||270000||690",
  "Port Royal||320000||1000",
  "Port Royal||100000||2000",
  "Sail",
  "Prosper=>Port Royal=>-200",
  "Plunder=>Nassau=>94000=>750",
  "Plunder=>Nassau=>1000=>150",
  "Plunder=>Campeche=>150000=>690",
  "End",
]);
