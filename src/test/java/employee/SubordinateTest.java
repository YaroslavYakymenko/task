package employee;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubordinateTest {
    private Subordinate unit = new OrdinaryEmployee("Mighty", "Clerk");

    @Before
    public void setUp() {
        unit.setManager(null);
    }

    @Test
    public void shouldSetManager() throws Exception {
        //GIVEN
        Manager expected = new ManagerEmployee("Mighty", "Manager");
        Manager actual = unit.getManager();
        assertTrue(actual == null);

        //WHEN
        unit.setManager(expected);

        //THEN
        actual = unit.getManager();
        assertTrue(actual != null);
        assertTrue(actual.equals(expected));
    }

    @Test
    public void managerShouldHaveCorrectSubordinate() throws Exception {
        //GIVEN
        Manager manager = new ManagerEmployee("Mighty", "Manager");
        unit.setManager(manager);

        //WHEN
        Employee actual = manager.getSubordinates().get(0);

        //THEN
        assertTrue(actual.equals(unit));
    }

    @Test
    public void shouldClearManager() throws Exception {
        //GIVEN
        Manager expected = new ManagerEmployee("Mighty", "Manager");
        unit.setManager(expected);
        Manager actual = unit.getManager();
        assertTrue(actual != null);

        //WHEN
        unit.setManager(null);

        //THEN
        actual = unit.getManager();
        assertTrue(actual == null);
    }

    @Test
    public void getManager() throws Exception {
        //GIVEN
        Manager expected = new ManagerEmployee("Mighty", "Manager");
        unit.setManager(expected);

        //WHEN
        Manager actual = unit.getManager();

        //THEN
        assertTrue(actual.equals(expected));
    }

    @Test
    public void hasManager() throws Exception {
        //GIVEN
        Manager manager = new ManagerEmployee("Mighty", "Manager");
        boolean actual = unit.hasManager();
        assertFalse(actual);

        //WHEN
        unit.setManager(manager);
        actual = unit.hasManager();

        //THEN
        assertTrue(actual);
    }
}