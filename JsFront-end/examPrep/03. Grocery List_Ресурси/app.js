function solve() {
  let container = {
    product: document.getElementById("product"),
    count: document.getElementById("count"),
    price: document.getElementById("price"),
    addBtn: document.getElementById("add-product"),
    updateBtn: document.getElementById("update-product"),
    loadBtn: document.getElementById("load-product"),
    tBody: document.getElementById("tbody"),
  };
  let BASE_URL = "http://localhost:3030/jsonstore/grocery/";
  container.loadBtn.addEventListener("click", loadHandler);
  container.addBtn.addEventListener("click", addHandler);
  container.updateBtn.addEventListener("click", loadUpdateFormHandler);
  let productstoEdit = {};
  let products = [];
  function loadHandler(e) {
    e.preventDefault();
    container.tBody.innerHTML = '';
    fetch(BASE_URL)
      .then((res) => res.json())
      .then((productsInfo) => {
        products = Object.values(productsInfo);
        products.forEach(({ product, count, price, _id }) => {
          let tr = createElement("tr", container.tBody);
          let tdName = createElement("td", tr, product, ["name"]);
          let tdCount = createElement("td", tr, count, ["count-product"]);
          let tdPrice = createElement("td", tr, price, ["product-price"]);
          let tdBtn = createElement("td", tr, "", ["btn"]);
          let updateBtnTd = createElement("button", tdBtn, "Update", [
            "update",
          ]);
          let deleteBtnTd = createElement("button", tdBtn, "Delete", [
            "delete",
          ]);

          updateBtnTd.id = _id;
          deleteBtnTd.id = _id;

          deleteBtnTd.addEventListener('click', deleteHandler);
          updateBtnTd.addEventListener('click', updateProductHandler)
        });
      });
  }

  function addHandler(e) {
    e.preventDefault();
    let httpHeader = {
      method: "Post",
      body: JSON.stringify({
        product: container.product.value,
        count: container.count.value,
        price: container.price.value,
      }),
    };

    fetch(BASE_URL, httpHeader).then(() => loadHandler(e));
    container.product.value = "";
    container.count.value = "";
    container.price.value = "";
  }

  function loadUpdateFormHandler(e) {
    e.preventDefault();
    const id = this.parentNode.parentNode.id;
    productstoEdit = products.find((p) => p._id === id);
    for (const key in container) {
      container[key].value = products[key];
    }
    container.addBtn.setAttribute('disabled', true);
    container.updateBtn.removeAttribute('disabled');
  }

  function updateProductHandler(event) {
    event.preventDefault();
    let product = container.product;
    let count = container.count;
    let price = container.price;
    const payload = JSON.stringify({
      product: product.value,
      count: count.value,
      price: price.value
    });
    const httpHeaders = {
      method: 'PATCH',
      body: payload
    }

    fetch(`${BASE_URL}${productstoEdit._id}`, httpHeaders)
      .then(() => {
        loadHandler(event);
        container.addBtn.removeAttribute('disabled');
        container.updateBtn.setAttribute('disabled', true);
      })
      .catch((err) => {
        console.error(err);
      })
  }


  function deleteHandler(e){
    e.preventDefault();
    let id = e.target.id;
    let httpHeader = {
        method: "Delete"
    }

    fetch(`${BASE_URL}${id}`, httpHeader)
    .then(() => loadHandler(e))
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
