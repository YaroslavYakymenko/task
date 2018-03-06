package service;

import employee.Employee;

public interface EmployeePrintService extends PrintService<Employee> {
    void printCeo(Employee employee);

    void printSubordinates(Employee employee);
}
