package company;

import employee.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Company {
    private Employee ceo;
    private List<Employee> employees;

    public Company(Employee ceo) {
        this.employees = new ArrayList<>();
        this.ceo = ceo;
        employees.add(ceo);
    }

    public Employee getCeo() {
        return ceo;
    }

    public void setCeo(Employee ceo) {
        this.ceo = ceo;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void hireEmployee (Employee employee) {
        employees.add(employee);
    }

    public boolean fireEmployee(Employee employee) {
        return employees.remove(employee);
    }
}
