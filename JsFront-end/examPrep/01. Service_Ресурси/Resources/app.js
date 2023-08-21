window.addEventListener('load', solve);

function solve() {
    let elementContainer = {
        product: document.getElementById('type-product'),
        description: document.getElementById('description'),
        clientName: document.getElementById('client-name'),
        clientPhone: document.getElementById('client-phone'),
        sendBtn: document.querySelector('form > button'),
        receivedOrders: document.getElementById('received-orders'),
        completedOrders: document.getElementById('completed-orders'),
        clearBtn: document.querySelector('.clear-btn')
    }
    elementContainer.sendBtn.addEventListener('click', sendHandler);
    elementContainer.clearBtn.addEventListener('click', clearHandler);
    function sendHandler(e){
        e.preventDefault();
        if (
        elementContainer.description.value == '' || 
        elementContainer.clientName.value == '' || 
        elementContainer.clientPhone.value == ''){
          return
        }
        let divContainerReceived = createElement('div', elementContainer.receivedOrders, '', ['container']);
        createElement('h2', divContainerReceived, `Product type for repair: ${elementContainer.product.value}`);
        createElement('h3', divContainerReceived, `Client information: ${elementContainer.clientName.value}, ${elementContainer.clientPhone.value}`);
        createElement('h4', divContainerReceived, `Description of the problem: ${elementContainer.description.value}`);
        let startBtn = createElement('button', divContainerReceived, 'Start repair', ['start-btn']);
        let finishBtn = createElement('button', divContainerReceived, 'Finish repair', ['finish-btn']);
        let productInfo = elementContainer.product.value;
        let nameInfo = elementContainer.clientName.value;
        let phoneInfo = elementContainer.clientPhone.value;
        let descriptionInfo = elementContainer.description.value;
        finishBtn.disabled = true;
        elementContainer.clientName.value = '';
        elementContainer.clientPhone.value = '';
        elementContainer.description.value = '';
        finishBtn.addEventListener('click', () =>{
        divContainerReceived.remove();
        let divContainerCompleted  = createElement('div', elementContainer.completedOrders, '', ['container']);
        createElement('h2', divContainerCompleted, `Product type for repair: ${productInfo}`);
        createElement('h3', divContainerCompleted, `Client information: ${nameInfo}, ${phoneInfo}`);
        createElement('h4', divContainerCompleted, `Description of the problem: ${descriptionInfo}`);
        });
        startBtn.addEventListener('click', () =>{
            startBtn.disabled = true;
            finishBtn.removeAttribute('disabled');
        });
    }

    function clearHandler(){
        let container = Array.from(document.querySelectorAll('#completed-orders > .container'));
        container.forEach((div) => div.remove());
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