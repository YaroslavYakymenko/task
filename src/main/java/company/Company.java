package company;

import employee.Employee;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
public class Company {
    private String companyName;
    private Employee ceo;
    private List<Employee> employees;

    public Company(String companyName, Employee ceo) {
        this.companyName = companyName;
        this.employees = new ArrayList<>();
        this.ceo = ceo;
        hireEmployee(ceo);
    }

    public void hireEmployee (Employee employee) {
        employees.add(employee);
    }

    public void fireEmployee(Employee employee) {
        employee.removeManager();
        employees.remove(employee);
    }
}
