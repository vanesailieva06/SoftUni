window.addEventListener("load", solve);

function solve() {
  let containerElement = {
    firstName: document.getElementById("first-name"),
    lastName: document.getElementById("last-name"),
    age: document.getElementById("age"),
    storyTitle: document.getElementById("story-title"),
    genre: document.getElementById("genre"),
    story: document.getElementById("story"),
    publishBtn: document.getElementById("form-btn"),
    preview: document.getElementById("preview-list"),
    main: document.getElementById("main"),
    body: document.querySelector(".body"),
  };

  containerElement.publishBtn.addEventListener("click", publishHandler);

  let otherContainer = {};
  function publishHandler(e) {
    e.preventDefault();
    if (
      containerElement.firstName.value == "" ||
      containerElement.lastName.value == "" ||
      containerElement.age.value == "" ||
      containerElement.storyTitle.value == "" ||
      containerElement.genre.value == "" ||
      containerElement.story.value == ""
    ) {
      return;
    }

    let li = createElement("li", containerElement.preview, null, [
      "story-info",
    ]);
    let article = createElement("article", li);
    let h4 = createElement(
      "h4",
      article,
      `Name: ${containerElement.firstName.value} ${containerElement.lastName.value}`
    );
    let pAge = createElement(
      "p",
      article,
      `Age: ${containerElement.age.value}`
    );
    let pTitle = createElement(
      "p",
      article,
      `Title: ${containerElement.storyTitle.value}`
    );
    let pGenre = createElement(
      "p",
      article,
      `Genre: ${containerElement.genre.value}`
    );
    let p = createElement("p", article, containerElement.story.value);
    let saveBtn = createElement(
      "button",
      containerElement.preview,
      `Save Story`,
      ["save-btn"]
    );
    let editBtn = createElement(
      "button",
      containerElement.preview,
      `Edit Story`,
      ["edit-btn"]
    );
    let deleteBtn = createElement(
      "button",
      containerElement.preview,
      `Delete Story`,
      ["delete-btn"]
    );

    containerElement.publishBtn.disabled = true;

    let firsNameInfo = containerElement.firstName.value;
    let lastNameInfo = containerElement.lastName.value;
    let ageInfo = containerElement.age.value;
    let stortTitleInfo = containerElement.storyTitle.value;
    let genreInfo = containerElement.genre.value;
    let storyInfo = containerElement.story.value;

    otherContainer = containerElement;

    otherContainer.firstName.value = "";
    otherContainer.lastName.value = "";
    otherContainer.age.value = "";
    otherContainer.storyTitle.value = "";
    otherContainer.story.value = "";

    editBtn.addEventListener("click", editHandler);

    function editHandler() {
      otherContainer.firstName.value = firsNameInfo;
      otherContainer.lastName.value = lastNameInfo;
      otherContainer.age.value = ageInfo;
      otherContainer.storyTitle.value = stortTitleInfo;
      otherContainer.genre.value = genreInfo;
      otherContainer.story.value = storyInfo;
      containerElement.publishBtn.removeAttribute("disabled");
      li.remove();
      h4.remove();
      pAge.remove();
      pTitle.remove();
      pGenre.remove();
      p.remove();
      saveBtn.remove();
      editBtn.remove();
      deleteBtn.remove();
    }

    deleteBtn.addEventListener("click", deleteHandler);
    function deleteHandler() {
      containerElement.publishBtn.removeAttribute("disabled");
      li.remove();
      h4.remove();
      pAge.remove();
      pTitle.remove();
      pGenre.remove();
      p.remove();
      saveBtn.remove();
      editBtn.remove();
      deleteBtn.remove();
    }

    saveBtn.addEventListener("click", saveHandler);
    function saveHandler() {
      containerElement.main.textContent = "";
      createElement("h1", containerElement.main, "Your scary story is saved!");
    }
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
