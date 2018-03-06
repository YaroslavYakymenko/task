package service;

import company.Company;
import employee.Employee;

public class CompanyPrintServiceImpl implements CompanyPrintService {
    @Override
    public void printAllEmployeesNames(Company company) {
        System.out.println("The following employees are working for the company " + company.getCompanyName() + ":");
        company.getEmployees().stream()
                .map(Employee::toString)
                .forEach(System.out::println);
    }

    @Override
    public void printName(Company company) {
        System.out.println(company.getCompanyName());
    }
}
