function solve(input) {
  let gloceries = input.shift().split("!");
  input.forEach((line) => {
    let tokens = line.split(" ");
    let command = tokens.shift();
    if (command === "Urgent") {
      let glocery = tokens.shift();
      if (!gloceries.includes(glocery)) {
        gloceries.unshift(glocery);
      }
    } else if (command === "Unnecessary") {
      let glocery = tokens.shift();
      if (gloceries.includes(glocery)) {
        let indexGlocery = gloceries.indexOf(glocery);
        gloceries.splice(indexGlocery, 1);
      }
    } else if (command === "Correct") {
      let oldItem = tokens.shift();
      let newItem = tokens.shift();
      if (gloceries.includes(oldItem)) {
        let indexOldItem = gloceries.indexOf(oldItem);
        gloceries.splice(indexOldItem, 1, newItem);
      }
    } else if (command === "Rearrange") {
      let glocery = tokens.shift();
      if (gloceries.includes(glocery)) {
        let indexGlocery = gloceries.indexOf(glocery);
        gloceries.splice(indexGlocery, 1);
        gloceries.push(glocery);
      }
    }
  });
  console.log(gloceries.join(", "));
}

