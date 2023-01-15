package bakery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
    //•	Field employees – List that holds added Employees
    //•	Method add(Employee employee) – adds an entity to the data if there is room for him/her.
    //•	Method remove(String name) – removes an employee by given name, if such exists, and returns a bool.
    //•	Method getOldestEmployee() – returns the oldest employee.
    //•	Method getEmployee(string name) – returns the employee with the given name.
    //•	Getter getCount() – returns the number of employees.
    public void add(Employee employee){
        if (isEnoughRoom(employees)) {
            employees.add(employee);
        }
    }
    public boolean remove(String name){
        Employee removedEmployee =  employees.stream().filter(e -> e.getName().equals(name))
                .findFirst().orElse(null);;
        if (removedEmployee != null){
            employees.remove(removedEmployee);
            return true;
        }
        return false;
    }

    public Employee getOldestEmployee(){
        return employees.stream().max(Comparator.comparingInt(Employee::getAge)).orElse(null);
    }

    public Employee getEmployee(String name){
        return  employees.stream().filter(e -> e.getName().equals(name))
                .findFirst().orElse(null);
    }

    private boolean isEnoughRoom(List<Employee> employees) {
        return capacity >= employees.size();
    }
    public int getCount(){
        return employees.size();
    }
    public String report(){
        //o	"Employees working at Bakery {bakeryName}:
        //{Employee1}
        //{Employee2}
        //(…)"
        StringBuilder sb = new StringBuilder();
        String format = String.format("Employees working at Bakery %s:", getName());
        sb.append(format);
        for (Employee employee : employees) {
            sb.append(System.lineSeparator()).append(employee);
        }
        return sb.toString();
    }

}
