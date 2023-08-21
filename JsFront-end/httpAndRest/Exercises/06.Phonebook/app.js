function attachEvents() {
  let loadBtn = document.getElementById("btnLoad");
  let person = document.getElementById("person");
  let phone = document.getElementById("phone");
  let createBtn = document.getElementById("btnCreate");
  let ulPhonebook = document.getElementById("phonebook");
  let BASE_URL = "http://localhost:3030/jsonstore/phonebook/";
  loadBtn.addEventListener("click", loadHandler);
  createBtn.addEventListener("click", createHandler);

  function loadHandler(e) {
    ulPhonebook.innerHTML = "";
    fetch(BASE_URL)
      .then((res) => res.json())
      .then((phoneInfo) => {
        let values = Object.values(phoneInfo);
        values.forEach(({ person, phone, _id }) => {
          let li = createElement("li", ulPhonebook, `${person}: ${phone}`);
          let deleteBtn = createElement("button", li, "Delete");
          deleteBtn.id = _id;
          deleteBtn.addEventListener("click", deleteHandler);
        });
      });
  }
  function deleteHandler(e) {
    let id = e.target.id;
    let httpHeaders = {
      method: "Delete",
    };
    fetch(`${BASE_URL}${id}`, httpHeaders).then(() => loadHandler());
  }
  function createHandler() {
    let httpHeaders = {
      method: "POST",
      body: JSON.stringify({ person: person.value, phone: phone.value }),
    };
    fetch(BASE_URL, httpHeaders).then(() => loadHandler());
    phone.value = "";
    person.value = "";
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

attachEvents();
