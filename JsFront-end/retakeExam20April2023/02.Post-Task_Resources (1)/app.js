window.addEventListener("load", solve);

function solve() {
  let elementContainer = {
    title: document.getElementById("task-title"),
    category: document.getElementById("task-category"),
    content: document.getElementById("task-content"),
    publishBtn: document.getElementById("publish-btn"),
    reviewList: document.getElementById("review-list"),
    publishedList: document.getElementById("published-list"),
  };

  elementContainer.publishBtn.addEventListener("click", publishHandler);
  let taskInfo = {
    titleInfo: "",
    categoryInfo: "",
    contentInfo: "",
  };
  function publishHandler() {
    if (
      elementContainer.title.value === "" ||
      elementContainer.category.value === "" ||
      elementContainer.content.value === ""
    ) {
      return;
    }

    taskInfo.titleInfo = elementContainer.title.value;
    taskInfo.categoryInfo = elementContainer.category.value;
    taskInfo.contentInfo = elementContainer.content.value;
    listContainer(elementContainer.reviewList);
    let rpost = document.querySelector(".rpost");
    let editBtn = createElement("button", rpost, "Edit", [
      "action-btn",
      "edit",
    ]);
    let postBtn = createElement("button", rpost, "Post", [
      "action-btn",
      "post",
    ]);
    editBtn.addEventListener('click', editHandler);
    postBtn.addEventListener('click', postHandler);
    cleanInput();
  }
  function postHandler(){
    removeInfo();
    listContainer(elementContainer.publishedList);
  }
  function editHandler(){
    removeInfo();
    fillInput();
  }
  function listContainer(parent) {
    fillInput();
    let rpost = createElement("li", parent, "", ["rpost"]);
    let article = createElement("article", rpost);
    createElement("h4", article, elementContainer.title.value);
    createElement("p", article, `Category: ${elementContainer.category.value}`);
    createElement("p", article, `Content: ${elementContainer.content.value}`);
    cleanInput();
  }
  function removeInfo(){
    let rpost = document.querySelector('#review-list > .rpost');
    rpost.remove();
  }
  function cleanInput() {
    elementContainer.title.value = "";
    elementContainer.category.value = "";
    elementContainer.content.value = "";
  }
  function fillInput() {
    elementContainer.title.value = taskInfo.titleInfo;
    elementContainer.category.value = taskInfo.categoryInfo;
    elementContainer.content.value = taskInfo.contentInfo;
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
