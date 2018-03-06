package service;

import employee.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeePrintServiceImpl implements EmployeePrintService {
    @Override
    public void printCeo(Employee employee) {
        System.out.println("Ceo of the given employee is ");
        if (!employee.hasManager()) {
            printName(employee);
            return;
        }
        Employee manager = employee.getManager();
        while (manager.hasManager()) {
            manager = manager.getManager();
        }
        printName(manager);
    }

    @Override
    public void printSubordinates(Employee employee) {
        List<Employee> subordinates = employee.getSubordinates();
        if (subordinates != null) {
            String result = subordinates.stream()
                    .map(Employee::toString)
                    .collect(Collectors.joining(","));
            System.out.println("Manager " + employee.toString() + " has following subordinates: " + result);
            subordinates.forEach(this::printSubordinates);
        }
    }

    @Override
    public void printName(Employee employee) {
        System.out.println(employee.toString());
    }
}
