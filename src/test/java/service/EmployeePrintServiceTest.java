package service;

import employee.Employee;
import employee.ManagerEmployee;
import employee.OrdinaryEmployee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import parameters.ManagerEmployeeParameterResolver;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(ManagerEmployeeParameterResolver.class)
class EmployeePrintServiceTest extends TestBase {

    @Test
    void shouldPrintCeo(ManagerEmployee employee) throws Exception {
        Employee ceo = new ManagerEmployee("Mighty", "Ceo");
        Employee firstManager = new ManagerEmployee("First","Manager");
        firstManager.setManager(ceo);
        Employee secondManager = new ManagerEmployee("Second","Manager");
        secondManager.setManager(ceo);
        employee.setManager(secondManager);

        new EmployeePrintServiceImpl().printCeo(employee);
        assertTrue(outContent.toString().contains("Mighty Ceo"));
        assertFalse(outContent.toString().contains("First Manager"));
        assertFalse(outContent.toString().contains("Second Manager"));
    }


    @Test
    void shouldPrintSubordinates(ManagerEmployee employee) throws Exception {
        Employee ceo = new ManagerEmployee("Mighty", "Ceo");
        Employee firstManager = new ManagerEmployee("First","Manager");
        firstManager.setManager(employee);

        Employee secondManager = new ManagerEmployee("Second","Manager");
        secondManager.setManager(firstManager);

        Employee thirdManager = new ManagerEmployee("Third","Manager");
        thirdManager.setManager(ceo);

        Employee clerk1 = new OrdinaryEmployee("First","Clerk");
        clerk1.setManager(firstManager);
        Employee clerk2 = new OrdinaryEmployee("Second","Clerk");
        clerk2.setManager(firstManager);
        Employee clerk3 = new OrdinaryEmployee("Third","Clerk");
        clerk3.setManager(secondManager);

        new EmployeePrintServiceImpl().printSubordinates(employee);
        assertTrue(outContent.toString().contains("First Manager"));
        assertTrue(outContent.toString().contains("Second Manager"));
        assertTrue(outContent.toString().contains("Second Clerk"));
        assertTrue(outContent.toString().contains("First Clerk"));
        assertFalse(outContent.toString().contains("Third Manager"));

    }
}
