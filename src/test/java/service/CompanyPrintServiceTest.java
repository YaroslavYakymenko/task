package service;

import company.Company;
import employee.ManagerEmployee;
import employee.OrdinaryEmployee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import parameters.CompanyParameterResolver;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(CompanyParameterResolver.class)
class CompanyPrintServiceTest extends TestBase {

    @Test
    void shouldPrintAllEmployeesNames(Company company) throws Exception {
        new CompanyPrintServiceImpl().printAllEmployeesNames(company);
        assertTrue(outContent.toString().contains("Test Manager"));
        assertFalse(outContent.toString().contains("John Daw"));
        company.hireEmployee(new ManagerEmployee("John", "Daw"));

        outContent.reset();
        new CompanyPrintServiceImpl().printAllEmployeesNames(company);
        assertTrue(outContent.toString().contains("Test Manager"));
        assertTrue(outContent.toString().contains("John Daw"));
    }
}
