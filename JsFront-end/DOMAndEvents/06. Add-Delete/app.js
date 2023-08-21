function addItem() {
  let items = document.getElementById("items");
  let newItem = document.getElementById("newItemText").value;
  let newLi = document.createElement("li");
  newLi.textContent = newItem;
  console.log(newLi);
  items.appendChild(newLi);
  document.getElementById("newItemText").value = "";
  let deleted = document.createElement("a");
  deleted.textContent = "[Delete]";
  deleted.href = "#";
  newLi.appendChild(deleted);
  deleted.addEventListener('click', deleteItem);
    function deleteItem(e) {
      let liItem = e.currentTarget.parentElement;
      liItem.remove();
    }
}
