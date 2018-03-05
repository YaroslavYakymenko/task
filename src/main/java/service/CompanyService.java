package service;

import company.Company;
import employee.Employee;

public interface CompanyService {
    default void printNamesOfCompanyEmployees(Company company) {
        company.getEmployees().stream()
                .map(Employee::toString)
                .forEach(System.out::println);
    }
}
