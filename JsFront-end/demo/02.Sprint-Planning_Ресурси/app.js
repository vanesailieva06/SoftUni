window.addEventListener('load', solve);

function solve() {
  let inputDomElements = {
      title: document.getElementById(`title`),
      description: document.getElementById(`description`),
      label: document.getElementById(`label`),
      estimationPoints: document.getElementById(`points`),
      assignee: document.getElementById(`assignee`),
  }
  let otherDomElements = {
      form: document.getElementById(`create-task-form`),
      tasksContainer: document.getElementById(`tasks-section`),
      createBtn: document.getElementById(`create-task-btn`),
      deleteBtn: document.getElementById(`delete-task-btn`),
      taskId: document.getElementById(`task-id`),
      totalPoints: document.getElementById(`total-sprint-points`),
  }
  otherDomElements.createBtn.addEventListener(`click`,createHandler);
  otherDomElements.deleteBtn.addEventListener(`click`, deleteHandler);

  let counter = 0;

  let icons = {
    'feature': '&#8865',
    'low': '&#9737',
    'high': '&#9888',
  };
  // let firstState = {
  //   title: null,
  //   description: null,
  //   label: null,
  //   estimationPoints: null,
  //   assignee: null,
  // };


  points = 0;

  function createHandler() {
      let {title, description, label, estimationPoints,assignee} = inputDomElements;
      let {form, tasksContainer, createBtn, deleteBtn,taskId,totalPoints} = otherDomElements;



      let AllHaveSomething = Object.values(inputDomElements).every((input) =>
      input.value !== ``);
      if (!AllHaveSomething) {
        return;
      }
      counter += 1;
      taskId.value = `task-${counter}`;


      let articleEl = createElement(`article`,``,otherDomElements.tasksContainer,taskId.value,[`task-card`]);
      let labelContent = '';
      let labelClass = '';
      if (label.value === 'Feature') {
        labelContent = `${label.value} ${icons['feature']}`;
        labelClass = 'feature';
      } else if (label.value === 'Low Priority Bug'){
        labelContent = `${label.value} ${icons['low']}`;
        labelClass = 'low-priority'
      } else if (label.value === 'High Priority Bug') {
        labelContent = `${label.value} ${icons['high']}`
        labelClass = 'high-priority';
      }
      let divElFeature = createElement(`div`,``,articleEl,``,[`task-card-label`]);
      divElFeature.innerHTML = labelContent;
      divElFeature.classList.add(labelClass);


      let h3El = createElement(`h3`,title.value,articleEl,``,[`task-card-title`]);
      let pEl = createElement(`p`,description.value,articleEl,``,[`task-card-description`]);
      let divElPoints = createElement(`div`,`Estimated at ${estimationPoints.value} pts`,articleEl,``,[`task-card-points`]);
      let divElAssignee = createElement(`div`,`Assigned to: ${assignee.value}`,articleEl,``,[`task-card-assignee`]);
      let divElActions = createElement(`div`,``,articleEl,``,[`task-card-actions`]);
      let deleteBtnInsider = createElement(`button`,`Delete`,divElActions,``,)

      deleteBtnInsider.addEventListener(`click`,deleteInsiderHandler)


      points += Number(estimationPoints.value);
      totalPoints.textContent = `Total Points ${points}pts`;

      // for (const key in firstState) {
      //   firstState[key] = inputDomElements[key].value;
      // };

      //form.reset();
      title.value = '';
      description.value = '';
      label.value = '';
      estimationPoints.value = '';
      assignee.value = '';

  }
  let deleteId = '';
  function deleteInsiderHandler(event) {
    let {title, description, label, estimationPoints, assignee} = inputDomElements;
    deleteId = event.currentTarget.parentNode.parentNode.id;
    // for (const key in inputDomElements) {
    //   inputDomElements[key].value = firstState[key];
    // }
    let deleteArticle = event.currentTarget.parentNode.parentNode;
    let data = deleteArticle.children;
    title.value = data[1].textContent;
    description.value = data[2].textContent;
    estimationPoints.value = data[3].textContent.split(' ')[2];
    assignee.value = data[4].textContent.split(': ')[1];
    let currentValueData = data[0].textContent.split(' ');
    currentValueData.pop();
    label.value = currentValueData.join(' ');
    

    otherDomElements.deleteBtn.removeAttribute(`disabled`);
    otherDomElements.createBtn.setAttribute(`disabled`,true);

    // let inputValues = Object.values(inputDomElements);
    // for (const value of inputValues) {
    //   value.setAttribute(`disabled`,true);
    // }
    title.setAttribute(`disabled`,true);
    description.setAttribute(`disabled`,true);
    label.setAttribute(`disabled`,true);
    estimationPoints.setAttribute(`disabled`,true);
    assignee.setAttribute(`disabled`,true);
  }
  function deleteHandler() {
    let {title,description,label,estimationPoints,assignee} = inputDomElements;
    let articles = Array.from(otherDomElements.tasksContainer.children);
    for (const article of articles) {
      if (article.id === deleteId) {
        points -= Number(inputDomElements.estimationPoints.value);
        article.remove();
        break;
      }
    }
    counter--;
    otherDomElements.totalPoints.textContent = `Total Points ${points}pts`;
    // let inputValues = Object.values(inputDomElements);
    // for (const value of inputValues) {
    //   value.removeAttribute(`disabled`);

    // }
    title.removeAttribute(`disabled`);
    description.removeAttribute(`disabled`);
    label.removeAttribute(`disabled`);
    estimationPoints.removeAttribute(`disabled`);
    assignee.removeAttribute(`disabled`);

    title.value = '';
    description.value = '';
    label.value = '';
    estimationPoints.value = '';
    assignee.value = '';
    otherDomElements.createBtn.removeAttribute(`disabled`);
    otherDomElements.deleteBtn.setAttribute(`disabled`,true);


  }

  function createElement(type, content, parent, id, classes, attributes) {
      const htmlElement = document.createElement(type);

      if (content && type !== 'input') {
        htmlElement.textContent = content;
      }

      if (content && type === 'input') {
        htmlElement.value = content;
      }

      if (id) {
        htmlElement.id = id;
      }

      //['list', 'item', ...]
      if (classes) {
        htmlElement.classList.add(...classes);
      }

      //{src: 'link to image, href: 'link to site', ...} => трябва да ги добавим
      //ще дойде като Обект => forin
      if (attributes) {
        for (const key in attributes) {
          htmlElement.setAttribute(key, attributes[key]);
        }
      }

      //ако имаме ParentNode => закачаме текушият Html елемент
      if (parent) {
        parent.appendChild(htmlElement);
      }

      return htmlElement;
    }
}