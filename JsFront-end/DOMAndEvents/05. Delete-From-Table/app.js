function deleteByEmail() {
  let email = Array.from(document.querySelectorAll('td:nth-child(even)'));
  let result = document.getElementById('result');
  let input = document.querySelector('input[name="email"]');
  let found = email.find((td) => td.textContent === input.value);
  console.log(found);
  if(found){
      result.textContent = "Deleted"
      found.parentElement.remove();
  }else{
      result.textContent = "Not found."
  }
}
