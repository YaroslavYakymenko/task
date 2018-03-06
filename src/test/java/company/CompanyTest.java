package company;

import employee.Employee;
import employee.OrdinaryEmployee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import parameters.CompanyParameterResolver;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(CompanyParameterResolver.class)
class CompanyTest {

    @Test
    void shouldHireEmployee(Company company) throws Exception {
        //GIVEN
        assertTrue(company.getEmployees().size() == 1);
        Employee emp = new OrdinaryEmployee("test", "test");

        //WHEN
        company.hireEmployee(emp);

        //THEN
        assertTrue(company.getEmployees().size() == 2);
    }

    @Test
    void shouldFireEmployee(Company company) throws Exception {
        //GIVEN
        assertTrue(company.getEmployees().size() == 1);

        //WHEN
        company.fireEmployee(company.getCeo());

        //THEN
        assertTrue(company.getEmployees().size() == 0);
    }
}
