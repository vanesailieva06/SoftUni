function attachEvents() {
  let BASE_URL = "http://localhost:3030/jsonstore/collections/books/";
  let loadBtn = document.getElementById("loadBooks");
  let booksContainer = document.querySelector("table > tbody");
  let headerForm = document.querySelector("#form > h3");
  let form = document.getElementById("form");

  let [titleInput, authorInput] = Array.from(
    document.querySelectorAll("#form > input")
  );
  let submitBtn = document.querySelector("#form > button");
  let submitBtnCopy = submitBtn;
  loadBtn.addEventListener("click", loadHandler);
  submitBtn.addEventListener("click", submitHandler);

  function loadHandler() {
    booksContainer.innerHTML = "";
    fetch(BASE_URL)
      .then((res) => res.json())
      .then((booksInfo) => {
        for (const bookId in booksInfo) {
          let { author, title } = booksInfo[bookId];
          let tr = createElement("tr", booksContainer);
          let trTitle = createElement("td", tr, title);
          let trAuthor = createElement("td", tr, author);
          let tdBtn = createElement("td", tr);
          let editBtn = createElement("button", tdBtn, "Edit");
          let deleteBtn = createElement("button", tdBtn, "Delete");
          editBtn.id = bookId;
          deleteBtn.id = bookId;
          deleteBtn.addEventListener("click", deleteHandler);
          editBtn.addEventListener("click", () => {
            headerForm.textContent = "Edit FORM";
            titleInput.value = trTitle.textContent;
            authorInput.value = trAuthor.textContent;
            submitBtn.remove();
            let saveBtn = createElement("button", form, "Save");
            saveBtn.addEventListener("click", saveHandler);
            saveBtn.id = editBtn.id;
            function saveHandler() {
              let id = this.id;
              let httpHeader = {
                method: "PUT",
                body: JSON.stringify({
                  author: authorInput.value,
                  title: titleInput.value,
                })
              };
              fetch(`${BASE_URL}${id}`, httpHeader).then(() => loadHandler());

              authorInput.value = '';
              titleInput.value = '';
              saveBtn.remove();
              createElement('button', form, 'Submit')
            }
          });
        }
      });
    function deleteHandler() {
      let id = this.id;
      let httpHeaders = {
        method: "Delete",
      };
      fetch(`${BASE_URL}${id}`, httpHeaders).then(() => loadHandler());
    }
  }

  function submitHandler() {
    let httpHeaders = {
      method: "POST",
      body: JSON.stringify({
        author: authorInput.value,
        title: titleInput.value,
      }),
    };
    fetch(BASE_URL, httpHeaders).then(() => loadHandler());
    authorInput.value = "";
    titleInput.value = "";
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
