// TODO:
function attachEvents() {
  let BASE_URL = "http://localhost:3030/jsonstore/tasks/";
  let container = {
    loadBtn: document.getElementById("load-board-btn"),
    title: document.getElementById("title"),
    description: document.getElementById("description"),
    addBtn: document.getElementById("create-task-btn"),
    todoSection: document.getElementById("todo-section"),
    taskListToDo: document.querySelector("#todo-section  .task-list"),
    taskListInProgress: document.querySelector(
      "#in-progress-section .task-list"
    ),
    taskListCodeReview: document.querySelector(
      "#code-review-section .task-list"
    ),
    taskListDone: document.querySelector("#done-section .task-list"),
    inProgressSection: document.getElementById("in-progress-section"),
    codeReviewSection: document.getElementById("code-review-section"),
    doneSection: document.getElementById("done-section"),
  };
  container.loadBtn.addEventListener("click", loadHandler);
  container.addBtn.addEventListener("click", createHandler);
  function loadHandler() {
    container.taskListToDo.innerHTML = "";
    container.taskListInProgress.innerHTML = "";
    container.taskListCodeReview.innerHTML = "";
    container.taskListDone.innerHTML = "";
    fetch(BASE_URL)
      .then((res) => res.json())
      .then((taskInfo) => {
        let tasks = Object.values(taskInfo);
        tasks.forEach(({ title, description, status, _id }) => {
          if (status === "ToDo") {
            let liTask = createElement("li", container.taskListToDo, "", [
              "task",
            ]);
            createElement("h3", liTask, title);
            createElement("p", liTask, description);
            let toDoBtn = createElement(
              "button",
              liTask,
              "Move to In Progress"
            );
            toDoBtn.id = _id;
            toDoBtn.addEventListener("click", toDoHandler);
          } else if (status === "In Progress") {
            let liTask = createElement("li", container.taskListInProgress, "", [
              "task",
            ]);
            createElement("h3", liTask, title);
            createElement("p", liTask, description);
            let inProgressBtn = createElement(
              "button",
              liTask,
              "Move to Code Review"
            );
            inProgressBtn.id = _id;
            inProgressBtn.addEventListener("click", inProgressHandler);
          } else if (status === "Code Review") {
            let liTask = createElement("li", container.taskListCodeReview, "", [
              "task",
            ]);
            createElement("h3", liTask, title);
            createElement("p", liTask, description);
            let codeReviewBtn = createElement("button", liTask, "Move to Done");
            codeReviewBtn.id = _id;
            codeReviewBtn.addEventListener("click", codeReviewHandler);
          } else if (status === "Done") {
            let liTask = createElement("li", container.taskListDone, "", [
              "task",
            ]);
            createElement("h3", liTask, title);
            createElement("p", liTask, description);
            let doneBtn = createElement("button", liTask, "Close");
            doneBtn.id = _id;
            doneBtn.addEventListener("click", doneHandler);
          }
        });
      });
    function toDoHandler() {
      let id = this.id;
      let httpHeaders = {
        method: "PATCH",
        body: JSON.stringify({ status: "In Progress" }),
      };

      fetch(`${BASE_URL}${id}`, httpHeaders).then(() => loadHandler());
    }

    function inProgressHandler() {
      let id = this.id;
      let httpHeaders = {
        method: "PATCH",
        body: JSON.stringify({ status: "Code Review" }),
      };

      fetch(`${BASE_URL}${id}`, httpHeaders).then(() => loadHandler());
    }

    function codeReviewHandler() {
      let id = this.id;
      let httpHeaders = {
        method: "PATCH",
        body: JSON.stringify({ status: "Done" }),
      };

      fetch(`${BASE_URL}${id}`, httpHeaders).then(() => loadHandler());
    }
    function doneHandler() {
      let id = this.id;
      let httpHeaders = {
        method: "DELETE",
      };
      fetch(`${BASE_URL}${id}`, httpHeaders).then(() => loadHandler());
    }
  }
  function createHandler() {
    let httpHeaders = {
      method: "POST",
      body: JSON.stringify({
        title: container.title.value,
        description: container.description.value,
        status: "ToDo",
      }),
    };
    container.title.value = '';
    container.description.value = '';
    fetch(BASE_URL, httpHeaders).then(() => loadHandler());
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
