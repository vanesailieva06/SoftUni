function solve() {
  let container = {
    courseName: document.getElementById("course-name"),
    type: document.getElementById("course-type"),
    description: document.getElementById("description"),
    teacherName: document.getElementById("teacher-name"),
    addBtn: document.getElementById("add-course"),
    editBtn: document.getElementById("edit-course"),
    loadBtn: document.getElementById("load-course"),
    listContainer: document.getElementById("list"),
  };
  let BASE_URL = "http://localhost:3030/jsonstore/tasks/";
  container.loadBtn.addEventListener("click", loadHandler);
  container.addBtn.addEventListener("click", addHandler);
  container.editBtn.addEventListener("click", editHandler);

  let course = [];
  function loadHandler(e) {
    e.preventDefault();
    container.listContainer.innerHTML = "";
    cleanInfo();
    fetch(BASE_URL)
      .then((res) => res.json())
      .then((courseInfo) => {
        course = Object.values(courseInfo);
        course.forEach(({ title, type, description, teacher, _id }) => {
          let containerDiv = createElement(
            "div",
            container.listContainer,
            "",
            null,
            "list"
          );

          let h2Title = createElement("h2", containerDiv, title);
          let h3Teacher = createElement("h3", containerDiv, teacher);
          let h3Type = createElement("h3", containerDiv, type);
          let h4Description = createElement("h4", containerDiv, description);
          let editCourseBtn = createElement(
            "button",
            containerDiv,
            "Edit Course",
            ["edit-btn"]
          );

          let finishBtn = createElement(
            "button",
            containerDiv,
            "Finish Course",
            ["finish-btn"]
          );
          editCourseBtn.id = _id;
          finishBtn.id = _id;
          editCourseBtn.addEventListener("click", () => {
            containerDiv.remove();
            container.courseName.value = h2Title.textContent;
            container.type.value = h3Type.textContent;
            container.description.value = h4Description.textContent;
            container.teacherName.value = h3Teacher.textContent;
            container.editBtn.removeAttribute("disabled");
            container.addBtn.disabled = true;
          });
          finishBtn.addEventListener("click", finishHandler);
        });
      });
  }
  function finishHandler(e) {
    let id = this.id;
    let httpHeaders = {
      method: "DELETE",
    };
    fetch(`${BASE_URL}${id}`, httpHeaders).then(() => loadHandler(e));
  }
  function addHandler(e) {
    e.preventDefault();
    let httpHeaders = {
      method: "POST",
      body: JSON.stringify({
        title: container.courseName.value,
        type: container.type.value,
        description: container.description.value,
        teacher: container.teacherName.value,
      }),
    };
    console.log(httpHeaders);
    fetch(BASE_URL, httpHeaders).then(() => loadHandler(e));
  }
  function editHandler(e) {
    let id = "";
    for (const info of Object.values(course)) {
      id = info;
    }
    let httpHeaders = {
      method: "PATCH",
      body: JSON.stringify({
        title: container.courseName.value,
        type: container.type.value,
        description: container.description.value,
        teacher: container.teacherName.value,
      }),
    };
    fetch(`${BASE_URL}${id._id}`, httpHeaders).then(() => loadHandler(e));
    container.editBtn.disabled = true;
    container.addBtn.removeAttribute("disabled");
  }
  function cleanInfo() {
    container.courseName.value = "";
    container.type.value = "";
    container.description.value = "";
    container.teacherName.value = "";
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
solve();
