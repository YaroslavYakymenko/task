package company;

import employee.ManagerEmployee;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CompanyTest {
    @Test
    public void shouldHireEmployee() throws Exception {
        //GIVEN
        int expectedSize = 3;
        Company unit = new Company(new ManagerEmployee("John", "Daw"));
        ManagerEmployee employee = new ManagerEmployee("Fist", "Manager");
        ManagerEmployee employee2 = new ManagerEmployee("Second", "Manager");

        //WHEN
        unit.hireEmployee(employee);
        unit.hireEmployee(employee2);

        //THEN
        int actualSize = unit.getEmployees().size();
        assertTrue(actualSize == expectedSize);
    }

    @Test
    public void fireEmployee() throws Exception {
        //GIVEN
        int expectedSize = 3;
        Company unit = new Company(new ManagerEmployee("John", "Daw"));
        ManagerEmployee employee = new ManagerEmployee("Fist", "Manager");
        ManagerEmployee employee2 = new ManagerEmployee("Second", "Manager");
        unit.hireEmployee(employee);
        unit.hireEmployee(employee2);
        int actualSize = unit.getEmployees().size();

        assertTrue(actualSize == expectedSize);

        //WHEN
        unit.fireEmployee(employee);

        //THEN
        expectedSize = 2;
        actualSize = unit.getEmployees().size();
        assertTrue(actualSize == expectedSize);
    }
}