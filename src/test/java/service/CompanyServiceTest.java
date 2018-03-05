package service;

import company.Company;
import employee.Employee;
import employee.Manager;
import employee.ManagerEmployee;
import employee.OrdinaryEmployee;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class CompanyServiceTest extends service.TestBase {
    private CompanyService unit = new CompanyServiceImpl();

    @Test
    public void shouldPrintNamesOfCompanyEmployees() throws Exception {
        //GIVEN
        Employee ceo = new ManagerEmployee("John", "Daw");
        ManagerEmployee director = new ManagerEmployee("Mr", "Director");
        director.setManager((Manager) ceo);

        Company company = new Company(ceo);
        company.hireEmployee(director);

        OrdinaryEmployee employee1 = new OrdinaryEmployee("First", "Employee");
        company.hireEmployee(employee1);
        employee1.setManager(director);

        OrdinaryEmployee employee2 = new OrdinaryEmployee("Second", "Employee");
        company.hireEmployee(employee2);
        employee2.setManager(director);


        //WHEN
        unit.printNamesOfCompanyEmployees(company);

        //THEN
        assertTrue(outContent.toString().contains("John Daw"));
        assertTrue(outContent.toString().contains("Mr Director"));
        assertTrue(outContent.toString().contains("First Employee"));
        assertTrue(outContent.toString().contains("Second Employee"));
        assertFalse(outContent.toString().contains("bullshit"));
    }

    @Test
    public void shouldPrintCeoNameIfThereAreNoEmployees() throws Exception {
        //GIVEN
        Employee ceo = new ManagerEmployee("John", "Daw");
        Company company = new Company(ceo);

        //WHEN
        unit.printNamesOfCompanyEmployees(company);

        //THEN
        assertTrue(outContent.toString().contains("John Daw"));
        assertFalse(outContent.toString().contains("Mr Director"));
    }

    @Test
    public void shouldPrinCorrectNamesIfEmployeeWasFired() throws Exception {
        //GIVEN
        Employee ceo = new ManagerEmployee("John", "Daw");
        ManagerEmployee director = new ManagerEmployee("Mr", "Director");
        director.setManager((Manager) ceo);

        Company company = new Company(ceo);
        company.hireEmployee(director);

        //WHEN
        unit.printNamesOfCompanyEmployees(company);

        //THEN
        assertTrue(outContent.toString().contains("John Daw"));
        assertTrue(outContent.toString().contains("Mr Director"));

        company.fireEmployee(director);
        outContent.reset();
        unit.printNamesOfCompanyEmployees(company);

        assertTrue(outContent.toString().contains("John Daw"));
        assertFalse(outContent.toString().contains("Mr Director"));
        assertFalse(outContent.toString().contains("bullshit"));
    }
}