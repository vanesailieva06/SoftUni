function totalPrice(peopleCount, typeGroup, week) {
  let totalPrice;
  switch (typeGroup) {
    case "Students":
      if (week === "Friday") {
        totalPrice = 8.45 * peopleCount;
      } else if (week === "Saturday") {
        totalPrice = 9.8 * peopleCount;
      } else if (week === "Sunday") {
        totalPrice = 10.46 * peopleCount;
      }
      if (peopleCount >= 30) {
        totalPrice -= totalPrice * 0.15;
      }
      break;
    case "Business":
      if (peopleCount >= 100) {
        peopleCount -= 10;
      }
      if (week === "Friday") {
        totalPrice = 10.9 * peopleCount;
      } else if (week === "Saturday") {
        totalPrice = 15.6 * peopleCount;
      } else if (week === "Sunday") {
        totalPrice = 16 * peopleCount;
      }
      break;
    case "Regular":
      if (week === "Friday") {
        totalPrice = 15 * peopleCount;
      } else if (week === "Saturday") {
        totalPrice = 20 * peopleCount;
      } else if (week === "Sunday") {
        totalPrice = 22.5 * peopleCount;
      }
      if (peopleCount >= 10 && peopleCount <= 20) {
        totalPrice -= peopleCount * 0.05;
      }
      break;
  }
  console.log(`Total price: ${totalPrice.toFixed(2)}`);
}
totalPrice(170, "Business", "Friday");
