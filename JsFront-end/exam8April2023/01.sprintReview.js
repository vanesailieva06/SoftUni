function solve(input) {
  let n = Number(input.shift());
  let sprintMap = {};
  let statusPoints = {
    ToDo: 0,
    "In Progress": 0,
    "Code Review": 0,
    Done: 0,
  };
  for (let i = 0; i < n; i++) {
    let [assignee, taskId, title, status, estimatedPoints] = input
      .shift()
      .split(":");
    if (!sprintMap.hasOwnProperty(assignee)) {
      sprintMap[assignee] = [];
    }
    sprintMap[assignee].push({
      taskId: taskId,
      title: title,
      status: status,
      estimatedPoints: Number(estimatedPoints),
    });
    statusPoints[status] += Number(estimatedPoints);
  }
  input.forEach((line) => {
    let tokens = line.split(":");
    let command = tokens.shift();
    if (command === "Add New") {
      addNew(tokens);
    } else if (command === "Change Status") {
      changeStatus(tokens);
    } else if (command === "Remove Task") {
      removeTask(tokens);
    }
  });

  function addNew(tokens) {
    let [assignee, taskId, title, status, estimatedPoints] = tokens;
    if (sprintMap.hasOwnProperty(assignee)) {
      sprintMap[assignee].push({
        taskId: taskId,
        title: title,
        status: status,
        estimatedPoints: Number(estimatedPoints),
      });
      statusPoints[status] += Number(estimatedPoints);
    } else {
      console.log(`Assignee ${assignee} does not exist on the board!`);
    }
  }

  function changeStatus(tokens) {
    let [assignee, taskId, newStatus] = tokens;
    if (!sprintMap.hasOwnProperty(assignee)) {
      console.log(`Assignee ${assignee} does not exist on the board!`);
    } else {
      for (let i = 0; i < sprintMap[assignee].length; i++) {
        if (sprintMap[assignee][i].taskId === taskId) {
          let oldStatus = sprintMap[assignee][i].status;
          statusPoints[oldStatus] -= sprintMap[assignee][i].estimatedPoints;
          sprintMap[assignee][i].status = newStatus;
          statusPoints[newStatus] += sprintMap[assignee][i].estimatedPoints;
        } else {
          console.log(`Task with ID ${taskId} does not exist for ${assignee}!`);
        }
      }
    }
  }

  function removeTask(tokens) {
    let [assignee, index] = tokens;
    if (!sprintMap.hasOwnProperty(assignee)) {
      console.log(`Assignee ${assignee} does not exist on the board!`);
    } else if (
      Number(index) >= sprintMap[assignee].length ||
      Number(index) < 0
    ) {
      console.log(`Index is out of range!`);
    } else {
      for (let i = 0; i < sprintMap[assignee].length; i++) {
        if (Number(index) === i) {
          statusPoints[sprintMap[assignee][i].status] -=
            sprintMap[assignee][i].estimatedPoints;
          sprintMap[assignee].splice(Number(index), 1);
        }
      }
    }
  }

  for (const status in statusPoints) {
    if (status === "Done") {
      console.log(`Done Points: ${statusPoints[status]}pts`);
    } else {
      console.log(`${status}: ${statusPoints[status]}pts`);
    }
  }
  if (
    statusPoints["ToDo"] +
      statusPoints["In Progress"] +
      statusPoints["Code Review"] <=
    statusPoints["Done"]
  ) {
    console.log("Sprint was successful!");
  } else {
    console.log("Sprint was unsuccessful...");
  }
}
solve(    [
  '5',
  'Kiril:BOP-1209:Fix Minor Bug:ToDo:3',
  'Mariya:BOP-1210:Fix Major Bug:In Progress:3',
  'Peter:BOP-1211:POC:Code Review:5',
  'Georgi:BOP-1212:Investigation Task:Done:2',
  'Mariya:BOP-1213:New Account Page:In Progress:13',
  'Add New:Kiril:BOP-1217:Add Info Page:In Progress:5',
  'Change Status:Peter:BOP-1290:ToDo',
  'Remove Task:Mariya:1',
  'Remove Task:Joro:1',
]
);
