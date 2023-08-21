window.addEventListener("load", solve);

function solve() {
  let elementContainer = {
    title: document.getElementById("title"),
    description: document.getElementById("description"),
    label: document.getElementById("label"),
    points: document.getElementById("points"),
    assignee: document.getElementById("assignee"),
    createBtn: document.getElementById("create-task-btn"),
    deleteBtn: document.getElementById("delete-task-btn"),
    tasks: document.getElementById("tasks-section"),
    totalPoints: document.getElementById("total-sprint-points"),
    taskId: document.getElementById("task-id"),
  };
  let task = 0;
  let totalPoints = 0;
  elementContainer.createBtn.addEventListener("click", createHandler);

  function createHandler(e) {
    e.preventDefault();
    if (
      elementContainer.title.value === '' ||
      elementContainer.description.value === '' ||
      elementContainer.label.value === '' ||
      elementContainer.points.value === '' ||
      elementContainer.assignee.value === ''
    ) {
      return;
    }
    task++;
    let articleTask = createElement(
      "article",
      elementContainer.tasks,
      "",
      ["task-card"],
      `task-${task}`
    );
    if (elementContainer.label.value === "Feature") {
      let featureDiv = createElement("div", articleTask, "", [
        "task-card-label",
        "feature",
      ]);
      featureDiv.innerHTML = `${elementContainer.label.value} &#8865;`;
    } else if (elementContainer.label.value === "Low Priority Bug") {
      let lowPriorityDiv = createElement("div", articleTask, "", [
        "task-card-label",
        "low-priority",
      ]);
      lowPriorityDiv.innerHTML = `${elementContainer.label.value} &#9737;`;
    } else if (elementContainer.label.value === "High Priority Bug") {
      let highPriorityDiv = createElement(
        "div",
        articleTask,
        elementContainer.label.value,
        ["task-card-label", "high-priority"]
      );
      highPriorityDiv.innerHTML = `${elementContainer.label.value} &#9888;`;
    }
    createElement("h3", articleTask, elementContainer.title.value, [
      "task-card-title",
    ]);
    createElement("p", articleTask, elementContainer.description.value, [
      "task-card-description",
    ]);
    createElement(
      "div",
      articleTask,
      `Estimated at ${elementContainer.points.value} pts`,
      ["task-card-points"]
    );
    createElement(
      "div",
      articleTask,
      `Assigned to: ${elementContainer.assignee.value}`,
      ["task-card-assignee"]
    );
    let divBtn = createElement("div", articleTask, "", ["task-card-actions"]);
    let deleteTaskBtn = createElement("button", divBtn, "Delete");
    let titleInfo = elementContainer.title.value;
    let descriptionInfo = elementContainer.description.value;
    let labeInfo = elementContainer.label.value;
    let pointsInfo = elementContainer.points.value;
    let assigneeInfo = elementContainer.assignee.value;
    elementContainer.title.value = "";
    elementContainer.description.value = "";
    elementContainer.label.value = "";
    elementContainer.points.value = "";
    elementContainer.assignee.value = "";
    totalPoints += Number(pointsInfo);
    elementContainer.totalPoints.textContent = `Total Points ${totalPoints}pts`;
    deleteTaskBtn.addEventListener("click", deleteTaskHandler);

    function deleteTaskHandler() {
      elementContainer.taskId.value = document.querySelector('.task-card').id;
      elementContainer.title.value = titleInfo;
      elementContainer.description.value = descriptionInfo;
      elementContainer.label.value = labeInfo;
      elementContainer.points.value = pointsInfo;
      elementContainer.assignee.value = assigneeInfo;
      elementContainer.deleteBtn.removeAttribute("disabled");
      elementContainer.createBtn.disabled = true;
      elementContainer.title.disabled = true;
      elementContainer.description.disabled = true;
      elementContainer.label.disabled = true;
      elementContainer.points.disabled = true;
      elementContainer.assignee.disabled = true;

      elementContainer.deleteBtn.addEventListener("click", () => {
        totalPoints -= Number(pointsInfo);
        elementContainer.totalPoints.textContent = `Total Points ${totalPoints}pts`;
        task--;
        elementContainer.taskId.value = '';
        articleTask.remove();
        elementContainer.title.value = "";
        elementContainer.description.value = "";
        elementContainer.label.value = "";
        elementContainer.points.value = "";
        elementContainer.assignee.value = "";
        elementContainer.deleteBtn.disabled = true;
        elementContainer.createBtn.removeAttribute("disabled");
        elementContainer.title.removeAttribute("disabled");
        elementContainer.description.removeAttribute("disabled");
        elementContainer.label.removeAttribute("disabled");
        elementContainer.points.removeAttribute("disabled");
        elementContainer.assignee.removeAttribute("disabled");
      });
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
