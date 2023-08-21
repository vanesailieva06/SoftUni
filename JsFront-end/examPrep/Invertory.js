function solve(input) {
  let items = input.shift().split(", ");
  input.forEach((line) => {
    if (line === "Craft!") {
      return;
    }
    let tokens = line.split(" - ");
    let command = tokens.shift();
    if (command === "Collect") {
      let item = tokens.shift();
      if (!items.includes(item)) {
        items.push(item);
      }
    } else if (command === "Drop") {
      let item = tokens.shift();
      if (items.includes(item)) {
        let indexItem = items.indexOf(item);
        items.splice(indexItem, 1);
      }
    } else if (command === "Combine Items") {
      let combineItems = tokens.shift().split(":");
      let oldItem = combineItems.shift();
      let newItem = combineItems.shift();
      if (items.includes(oldItem)) {
        let oldItemIndex = items.indexOf(oldItem);
        items.splice(oldItemIndex + 1, 0, newItem);
      }
    } else if (command === "Renew") {
      let item = tokens.shift();
      if (items.includes(item)) {
        let itemIndex = items.indexOf(item);
        items.splice(itemIndex, 1);
        items.push(item);
      }
    }
  });
  console.log(items.join(", "));
}

