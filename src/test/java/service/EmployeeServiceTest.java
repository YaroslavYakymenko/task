package service;

import employee.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeServiceTest extends service.TestBase {
    private EmployeeService unit = new EmployeeServiceImpl();

    @Test
    public void shouldPrintSubordinatesNames() throws Exception {
        //GIVEN
        Manager manager = new ManagerEmployee("Mr", "Director");

        OrdinaryEmployee employee1 = new OrdinaryEmployee("First", "Employee");
        employee1.setManager(manager);

        OrdinaryEmployee employee2 = new OrdinaryEmployee("Second", "Employee");
        employee2.setManager(manager);

        //WHEN
        unit.printSubordinatesNames(manager);

        //THEN
        assertFalse(outContent.toString().contains("Mr Director"));
        assertTrue(outContent.toString().contains("First Employee"));
        assertTrue(outContent.toString().contains("Second Employee"));
        assertFalse(outContent.toString().contains("Third Employee"));
    }

    @Test
    public void shouldPrintOnlyActiveSubordinates() throws Exception {
        //GIVEN
        Manager manager = new ManagerEmployee("Mr", "Director");

        OrdinaryEmployee employee1 = new OrdinaryEmployee("First", "Employee");
        employee1.setManager(manager);

        OrdinaryEmployee employee2 = new OrdinaryEmployee("Second", "Employee");
        employee2.setManager(manager);

        //WHEN
        unit.printSubordinatesNames(manager);

        //THEN
        assertFalse(outContent.toString().contains("Mr Director"));
        assertTrue(outContent.toString().contains("First Employee"));
        assertTrue(outContent.toString().contains("Second Employee"));

        manager.removeSubordinate(employee1);
        outContent.reset();

        unit.printSubordinatesNames(manager);
        assertFalse(outContent.toString().contains("First Employee"));
        assertTrue(outContent.toString().contains("Second Employee"));
    }

    @Test
    public void shouldPrintCEONameForOrdinaryEmployee() throws Exception {
        //GIVEN
        ManagerEmployee ceo = new ManagerEmployee("John", "Daw");
        ManagerEmployee topManager = new ManagerEmployee("Top", "Manager");
        topManager.setManager(ceo);

        ManagerEmployee legalManager = new ManagerEmployee("Legal", "Manager");
        ManagerEmployee financeManager = new ManagerEmployee("Finance", "Manager");
        legalManager.setManager(topManager);
        financeManager.setManager(topManager);

        OrdinaryEmployee clerk1 = new OrdinaryEmployee("Firstlegal", "Clerk");
        OrdinaryEmployee clerk2 = new OrdinaryEmployee("Secondlegal", "Clerk");

        legalManager.addSubordinate(clerk1);
        legalManager.addSubordinate(clerk2);

        OrdinaryEmployee clerk3 = new OrdinaryEmployee("FirstFinance", "Clerk");
        financeManager.addSubordinate(clerk3);

        //WHEN
        unit.printCEOName(clerk1);

        //THEN
        assertTrue(outContent.toString().contains("John Daw"));
        assertFalse(outContent.toString().contains("Legal Manager"));
        assertFalse(outContent.toString().contains("Firstlegal Clerk"));
    }

    @Test
    public void shouldPrintCeoNameForManager() throws Exception {
        //GIVEN
        ManagerEmployee ceo = new ManagerEmployee("John", "Daw");
        ManagerEmployee topManager = new ManagerEmployee("Top", "Manager");
        topManager.setManager(ceo);

        ManagerEmployee legalManager = new ManagerEmployee("Legal", "Manager");
        ManagerEmployee financeManager = new ManagerEmployee("Finance", "Manager");
        legalManager.setManager(topManager);
        financeManager.setManager(topManager);

        //WHEN
        unit.printCEOName(legalManager);

        //THEN
        assertTrue(outContent.toString().contains("John Daw"));
        assertFalse(outContent.toString().contains("Legal Manager"));
        assertFalse(outContent.toString().contains("Finance Manager"));
    }
}