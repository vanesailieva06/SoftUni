window.addEventListener("load", solve);

function solve() {
  let containerElements = {
    genre: document.getElementById("genre"),
    name: document.getElementById("name"),
    author: document.getElementById("author"),
    date: document.getElementById("date"),
    addBtn: document.getElementById("add-btn"),
    hitsContainer: document.querySelector(".all-hits-container"),
    saveContainer: document.querySelector(".saved-container"),
    likes: document.querySelector(".likes"),
  };
  containerElements.addBtn.addEventListener('click', addHandler);
  let otherContainer = {};
  let likes = 0;
  function addHandler(e) {
    e.preventDefault();
    if (
      containerElements.genre.value == '' ||
      containerElements.name.value == '' ||
      containerElements.author.value == '' ||
      containerElements.date.value == ''
    ) {
      return;
    }
    
    let divHitsInfo = createElement('div', containerElements.hitsContainer, '', ['hits-info']);
    createElement('img', divHitsInfo, null, null, null, {src: "./static/img/img.png"});
    createElement('h2', divHitsInfo, `Genre: ${containerElements.genre.value}`);
    createElement('h2', divHitsInfo, `Name: ${containerElements.name.value}`);
    createElement('h2', divHitsInfo, `Author: ${containerElements.author.value}`);
    createElement('h3', divHitsInfo, `Date: ${containerElements.date.value}`);
    let saveHitsBtn = createElement('button', divHitsInfo, `Save song`, ['save-btn']);
    let likeHitsBtn = createElement('button', divHitsInfo, 'Like Song', ['like-btn']);
    let deleteHitsBtn = createElement('button', divHitsInfo, 'Delete', ['delete-btn']);
    otherContainer = containerElements;
    let genreInfo = otherContainer.genre.value;
    let nameInfo = otherContainer.name.value;
    let authorInfo = otherContainer.author.value;
    let dateInfo = otherContainer.date.value;
    otherContainer.genre.value = '';
    otherContainer.name.value = '';
    otherContainer.author.value = '';
    otherContainer.date.value = '';

    likeHitsBtn.addEventListener('click', likeHandler);
    saveHitsBtn.addEventListener('click', saveHandler);
    deleteHitsBtn.addEventListener('click', deleteHitsHandler);

    function likeHandler(){
      let pLikes = containerElements.likes.children[0];
      pLikes.innerHTML = '';
      likes++;
      pLikes.textContent = `Total Likes: ${likes}`;
      likeHitsBtn.disabled = true;
    }

    function saveHandler(){
      otherContainer.genre.value = genreInfo;
      otherContainer.name.value = nameInfo;
      otherContainer.author.value = authorInfo;
      otherContainer.date.value = dateInfo;
      let divSaveInfo = createElement('div', containerElements.saveContainer, '', ['hits-info']);
      createElement('img', divSaveInfo, null, null, null, {src: "./static/img/img.png"});
      createElement('h2', divSaveInfo, `Genre: ${containerElements.genre.value}`);
      createElement('h2', divSaveInfo, `Name: ${containerElements.name.value}`);
      createElement('h2', divSaveInfo, `Author: ${containerElements.author.value}`);
      createElement('h3', divSaveInfo, `Date: ${containerElements.date.value}`);
      let deleteSavedBtn = createElement('button', divSaveInfo, 'Delete', ['delete-btn']);
      otherContainer.genre.value = '';
      otherContainer.name.value = '';
      otherContainer.author.value = '';
      otherContainer.date.value = '';
      divHitsInfo.remove();
      deleteSavedBtn.addEventListener('click', deleteSaveHandler);
      
      function deleteSaveHandler(){
      divSaveInfo.remove();
    }
    }
    
    function deleteHitsHandler(){
      divHitsInfo.remove();
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
