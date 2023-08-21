function addItem() {
  let items = document.getElementById('items');
  let newItem = document.getElementById("newItemText").value;
  let newLi = document.createElement("li");
  newLi.textContent = newItem;
  items.appendChild(newLi);
  document.getElementById('newItemText').value = '';
}
