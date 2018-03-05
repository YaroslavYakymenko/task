package employee;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.isNotNull;
import static org.mockito.Matchers.isNull;

public class ManagerTest {
    private Manager unit = new ManagerEmployee("Mighty", "Manager");

    @Before
    public void setUp() {
        unit.getSubordinates().clear();
    }

    @Test
    public void shouldReturnListOfSubordinates() throws Exception {
        //GIVEN
        Employee subordinate1 = new OrdinaryEmployee("First", "Employee");
        Employee subordinate2 = new OrdinaryEmployee("Second", "Employee");
        Employee subordinate3 = new OrdinaryEmployee("Third", "Employee");
        assertThat(unit.getSubordinates().size(), is(0));

        List<Employee> expected = new ArrayList<Employee>() {{
            add(subordinate1);
            add(subordinate2);
            add(subordinate3);
        }};

        unit.addSubordinate(subordinate1);
        unit.addSubordinate(subordinate2);
        unit.addSubordinate(subordinate3);

        //WHEN
        List<Employee> actual = unit.getSubordinates();
        int actualSize = unit.getSubordinates().size();

        //THEN
        assertThat(actualSize, is(3));
        assertTrue(actual.containsAll(expected));
    }

    @Test
    public void addSubordinate() throws Exception {
        //GIVEN
        Employee subordinate1 = new OrdinaryEmployee("First", "Employee");
        Employee subordinate2 = new OrdinaryEmployee("Second", "Employee");
        assertThat(unit.getSubordinates().size(), is(0));

        List<Employee> expected = new ArrayList<Employee>() {{
            add(subordinate1);
            add(subordinate2);
        }};

        //WHEN
        unit.addSubordinate(subordinate1);
        unit.addSubordinate(subordinate2);

        //THEN
        List<Employee> actual = unit.getSubordinates();
        int actualSize = unit.getSubordinates().size();
        assertThat(actualSize, is(2));
        assertTrue(actual.containsAll(expected));
    }

    @Test
    public void subordinateShouldHaveCorrectManager() throws Exception {
        //GIVEN
        OrdinaryEmployee subordinate = new OrdinaryEmployee("First", "Employee");
        unit.addSubordinate(subordinate);

        //WHEN
        Manager actualManager = subordinate.getManager();

        //THEN
        assertTrue(actualManager.equals(unit));
    }

    @Test
    public void removeSubordinate() throws Exception {
        //GIVEN
        Employee subordinate1 = new OrdinaryEmployee("First", "Employee");
        Employee subordinate2 = new OrdinaryEmployee("Second", "Employee");
        Employee subordinate3 = new OrdinaryEmployee("Third", "Employee");

        unit.addSubordinate(subordinate1);
        unit.addSubordinate(subordinate2);
        unit.addSubordinate(subordinate3);

        int actualSize = unit.getSubordinates().size();
        assertThat(actualSize, is(3));

        //WHEN
        unit.removeSubordinate(subordinate3);

        //THEN
        List<Employee> actual = unit.getSubordinates();
        actualSize = unit.getSubordinates().size();
        assertThat(actualSize, is(2));
        assertFalse(actual.contains(subordinate3));
    }

    @Test
    public void subordinatesManagerShouldBeNullAfterRemoving() throws Exception {
        //GIVEN
        OrdinaryEmployee subordinate = new OrdinaryEmployee("First", "Employee");
        unit.addSubordinate(subordinate);
        Manager actualManager = subordinate.getManager();
        assertTrue(actualManager.equals(unit));

        //WHEN
        unit.removeSubordinate(subordinate);

        //THEN
        actualManager = subordinate.getManager();
        assertTrue(actualManager == null);
    }
}