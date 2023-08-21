function solve(input) {
  let horses = input.shift().split("|");
  while (input[0] !== "Finish") {
    let tokens = input.shift().split(" ");
    let command = tokens.shift();
    if (command === "Retake") {
      let [overtakingHorse, overtakenHorse] = tokens;
      let indexOvertakingHorse = horses.indexOf(overtakingHorse);
      let indexOvertakenHorse = horses.indexOf(overtakenHorse);
      if (indexOvertakingHorse < indexOvertakenHorse) {
        [horses[indexOvertakingHorse], horses[indexOvertakenHorse]] = [
          horses[indexOvertakenHorse],
          horses[indexOvertakingHorse],
        ];
        console.log(`${overtakingHorse} retakes ${overtakenHorse}.`);
      }
    } else if (command === "Rage") {
      let horse = tokens.shift();
      let indexHorse = horses.indexOf(horse);
      if (indexHorse === horses.length - 2) {
        horses.splice(indexHorse, 1);
        horses.splice(horses.length, 0, horse);
      } else if (indexHorse !== horses.length - 1) {
        horses.splice(indexHorse, 1);
        horses.splice(indexHorse + 2, 0, horse);
      }
      console.log(`${horse} rages 2 positions ahead.`);
    } else if (command === "Trouble") {
      let horse = tokens.shift();
      let indexHorse = horses.indexOf(horse);
      if (indexHorse !== 0) {
        horses.splice(indexHorse, 1);
        horses.splice(indexHorse - 1, 0, horse);
        console.log(`Trouble for ${horse} - drops one position.`);
      }
    } else if (command === "Miracle") {
      let horse = horses[0];
      horses.splice(0, 1);
      horses.splice(horses.length, 0, horse);
      console.log(`What a miracle - ${horse} becomes first.`);
    }
  }
  console.log(horses.join("->"));
  console.log(`The winner is: ${horses[horses.length - 1]}`);
}
solve([
  "Fancy|Lilly",
  "Retake Lilly Fancy",
  "Trouble Lilly",
  "Trouble Lilly",
  "Finish",
  "Rage Lilly",
]);
