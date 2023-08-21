window.addEventListener("load", solve);

function solve() {
  let elementContainer = {
    make: document.getElementById("make"),
    model: document.getElementById("model"),
    year: document.getElementById("year"),
    fuel: document.getElementById("fuel"),
    originalCost: document.getElementById("original-cost"),
    sellingPrice: document.getElementById("selling-price"),
    publishBtn: document.getElementById("publish"),
    carsContainer: document.getElementById("table-body"),
    carList: document.getElementById("cars-list"),
    profitPrice: document.getElementById("profit"),
  };
  let otherContainer = elementContainer;
  elementContainer.publishBtn.addEventListener("click", publishHandler);
  let profitSum = 0;
  function publishHandler(e) {
    e.preventDefault();
    let rowClass = createElement("tr", elementContainer.carsContainer, "", [
      "row",
    ]);
    let tdMake = createElement("td", rowClass, elementContainer.make.value);
    let tdModel = createElement("td", rowClass, elementContainer.model.value);
    let tdYear = createElement("td", rowClass, elementContainer.year.value);
    let tdFuel = createElement("td", rowClass, elementContainer.fuel.value);
    let tdOrgPrice = createElement(
      "td",
      rowClass,
      elementContainer.originalCost.value
    );
    let tdSellingPrice = createElement(
      "td",
      rowClass,
      elementContainer.sellingPrice.value
    );
    let tdBtn = createElement("td", rowClass);
    let editBtn = createElement("button", tdBtn, "Edit", [
      "action-btn",
      "edit",
    ]);
    let sellBtn = createElement("button", tdBtn, "Sell", [
      "action-btn",
      "sell",
    ]);
    let makeInfo = elementContainer.make.value;
    let modelInfo = elementContainer.model.value;
    let yearInfo = elementContainer.year.value;
    let fuelInfo = elementContainer.fuel.value;
    let orgPriceInfo = elementContainer.originalCost.value;
    let sellingPriceInfo = elementContainer.sellingPrice.value;

    elementContainer.make.value = "";
    elementContainer.model.value = "";
    elementContainer.year.value = "";
    elementContainer.fuel.value = "";
    elementContainer.originalCost.value = "";
    elementContainer.sellingPrice.value = "";
    editBtn.addEventListener("click", () => {
      rowClass.remove();
      elementContainer.make.value = makeInfo;
      elementContainer.model.value = modelInfo;
      elementContainer.year.value = yearInfo;
      elementContainer.fuel.value = fuelInfo;
      elementContainer.originalCost.value = orgPriceInfo;
      elementContainer.sellingPrice.value = sellingPriceInfo;
    });
    sellBtn.addEventListener("click", () => {
      let eachCarList = createElement("li", elementContainer.carList, '', ['each-list']);
      let spanMake = createElement(
        "span",
        eachCarList,
        `${tdMake.textContent} ${tdModel.textContent}`
      );
      let spanYear = createElement("span", eachCarList, tdYear.textContent);
      let profit = Number(tdSellingPrice.textContent - tdOrgPrice.textContent);
      if (profit === 0){
        let spanProfit = createElement("span", eachCarList, '0');
      }
      profitSum += profit;
      elementContainer.profitPrice.textContent = profitSum.toFixed(2);
      let spanProfit = createElement("span", eachCarList, profit);
      rowClass.remove();
    });
  }

  function createElement(type, parent, content, classes, id, attributes) {
    let element = document.createElement(type);
    if (content && type !== "input") {
      element.textContent = content;
    }
    if (content && type === "input") {
      element.value = content;
    }
    if (parent) {
      parent.appendChild(element);
    }
    if (id) {
      element.id = id;
    }
    if (classes) {
      element.classList.add(...classes);
    }
    if (attributes) {
      for (const key in attributes) {
        element.setAttribute(key, attributes[key]);
      }
    }
    return element;
  }
}
