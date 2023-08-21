window.addEventListener("load", solve);

function solve() {
  let elementContainer = {
    firstName: document.getElementById("first-name"),
    lastName: document.getElementById("last-name"),
    dateIn: document.getElementById("date-in"),
    dateOut: document.getElementById("date-out"),
    peopleCount: document.getElementById("people-count"),
    nextBtn: document.getElementById("next-btn"),
    infoContainer: document.querySelector(".info-list"),
    confirmContainer: document.querySelector(".confirm-list"),
    verification: document.getElementById("verification"),
  };
  elementContainer.nextBtn.addEventListener("click", nextHandler);
  let reservationInfo = {
    firstNameInfo: "",
    lastNameInfo: "",
    dateInInfo: "",
    dateOutInfo: "",
    peopleCountInfo: "",
  };

  function nextHandler(e) {
    e.preventDefault();
    if (
      elementContainer.firstName.value == "" ||
      elementContainer.lastName.value == "" ||
      elementContainer.dateIn.value == "" ||
      elementContainer.dateOut.value == "" ||
      elementContainer.peopleCount.value == "" ||
      new Date(elementContainer.dateIn.value) >= new Date(elementContainer.dateOut.value)
    ) {
      return;
    }
    elementContainer.nextBtn.disabled = true;
    reservationInfo.firstNameInfo = elementContainer.firstName.value;
    reservationInfo.lastNameInfo = elementContainer.lastName.value;
    reservationInfo.dateInInfo = elementContainer.dateIn.value;
    reservationInfo.dateOutInfo = elementContainer.dateOut.value;
    reservationInfo.peopleCountInfo = elementContainer.peopleCount.value;
    listContainer(elementContainer.infoContainer);
    let listInfo = document.querySelector(".info-list > .reservation-content");
    let editBtn = createElement("button", listInfo, "Edit", ["edit-btn"]);
    let continueBtn = createElement("button", listInfo, "Continue", [
      "continue-btn",
    ]);
    editBtn.addEventListener("click", editHandler);
    continueBtn.addEventListener("click", continueHandler);

    cleanInput();
  }
  function editHandler() {
    fillInput();
    removeInfo();
    elementContainer.nextBtn.removeAttribute('disabled');
  }

  function continueHandler() {
    removeInfo();
    listContainer(elementContainer.confirmContainer);
    let listInfo = document.querySelector('.confirm-list > .reservation-content');
    let confirmBtn = createElement('button', listInfo, 'Confirm', ['confirm-btn']);
    let cancelBtn = createElement('button', listInfo, 'Cancel', ['cancel-btn']);
    confirmBtn.addEventListener('click', confirmHandler);
    cancelBtn.addEventListener('click', cancelHandler);
  }

  function confirmHandler(){
    removeConfirmInfo();
    elementContainer.verification.classList.add('reservation-confirmed');
    elementContainer.verification.textContent = 'Confirmed.';
    elementContainer.nextBtn.removeAttribute('disabled');
    elementContainer.verification.classList.remove('reservation-cancelled');
  }

  function cancelHandler(){
    removeConfirmInfo();
    elementContainer.verification.classList.add('reservation-cancelled');
    elementContainer.verification.textContent = 'Cancelled.';
    elementContainer.nextBtn.removeAttribute('disabled');
    elementContainer.verification.classList.remove('reservation-confirmed')
  }

  function listContainer(parent) {
    fillInput();
    let liContent = createElement("li", parent, "", ["reservation-content"]);
    let article = createElement("article", liContent);
    createElement(
      "h3",
      article,
      `Name: ${elementContainer.firstName.value} ${elementContainer.lastName.value}`
    );
    createElement("p", article, `From date: ${elementContainer.dateIn.value}`);
    createElement("p", article, `To date: ${elementContainer.dateOut.value}`);
    createElement(
      "p",
      article,
      `For ${elementContainer.peopleCount.value} people`
    );
    cleanInput();
  }

  function cleanInput() {
    elementContainer.firstName.value = "";
    elementContainer.lastName.value = "";
    elementContainer.dateIn.value = "";
    elementContainer.dateOut.value = "";
    elementContainer.peopleCount.value = "";
  }

  function fillInput() {
    elementContainer.firstName.value = reservationInfo.firstNameInfo;
    elementContainer.lastName.value = reservationInfo.lastNameInfo;
    elementContainer.dateIn.value = reservationInfo.dateInInfo;
    elementContainer.dateOut.value = reservationInfo.dateOutInfo;
    elementContainer.peopleCount.value = reservationInfo.peopleCountInfo;
  }

  function removeInfo() {
    let info = document.querySelector(".info-list > .reservation-content");
    info.remove();
  }

  function removeConfirmInfo(){
    let confirmInfo = document.querySelector('.confirm-list > .reservation-content');
    confirmInfo.remove();
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
