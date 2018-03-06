package service;

import company.Company;

public interface CompanyPrintService extends PrintService<Company> {
    void printAllEmployeesNames(Company company);
}
