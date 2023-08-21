// TODO
function attachEvents() {
  let title = document.getElementById("title");
  let addBtn = document.getElementById("add-button");
  let loadBtn = document.getElementById("load-button");
  let todolist = document.getElementById("todo-list");
  let BASE_URL = "http://localhost:3030/jsonstore/tasks/";
  loadBtn.addEventListener("click", loadHandler);
  addBtn.addEventListener("click", addHandler);
  function loadHandler(e) {
    e.preventDefault();
    todolist.innerHTML = "";
    fetch(BASE_URL)
      .then((res) => res.json())
      .then((tasksInfo) => {
        let tasks = Object.values(tasksInfo);
        tasks.forEach(({ name, _id }) => {
          let li = createElement("li", todolist, "");
          createElement("span", li, name);
          let removeBtn = createElement("button", li, "Remove");
          let editBtn = createElement("button", li, "Edit");
          removeBtn.id = _id;
          editBtn.id = _id;
          removeBtn.addEventListener("click", removeHandler);
          editBtn.addEventListener('click', editHandler);
        });
      });
  }

  function editHandler(e){
    let li = e.target.parentElement;
    e.target.parentElement.innerHTML = `
  <input value='${
    e.target.parentElement.querySelector("span").textContent
  }'/>
    <button id=${e.target.id} class="remove-button">Remove</button>
    <button id=${e.target.id} class="submit-button">Submit</button>`;
    li.querySelector('.remove-button').addEventListener('click', removeTaskHandler);
    li.querySelector('.submit-button').addEventListener('click', submitHandler);
  }

  function removeTaskHandler(e){
    let id = e.target.id
    let httpHeader = {
      method: "Delete"
    };
    fetch(`${BASE_URL}${id}`, httpHeader).then(() => loadHandler(e));
  }

  function submitHandler(e){
    let input = e.target.parentElement.querySelector('input').value;
    let httpHeader = {
        method: "PATCH", 
        body: JSON.stringify({name: input})
    }

    fetch(`${BASE_URL}${e.target.id}`, httpHeader)
    .then(() => loadHandler(e));

  }
  function removeHandler(e) {
    e.preventDefault();
    let id = e.target.id
    let httpHeader = {
      method: "Delete"
    };
    fetch(`${BASE_URL}${id}`, httpHeader).then(() => loadHandler(e));
  }

  function addHandler(e) {
    e.preventDefault();
    let httpHeader = {
      method: "Post",
      body: JSON.stringify({ name: title.value }),
    };
    fetch(BASE_URL, httpHeader).then(() => loadHandler(e));
    title.value = "";
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
