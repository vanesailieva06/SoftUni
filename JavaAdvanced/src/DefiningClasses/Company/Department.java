package DefiningClasses.Company;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String nameEmployee;
    private List<Employee> employees;

    public Department(String nameEmployee, List<Employee> employees){
       employees = new ArrayList<>();
      this.nameEmployee = nameEmployee;
      this.employees = employees;

    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
