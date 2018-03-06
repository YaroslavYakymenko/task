package employee;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import parameters.ManagerEmployeeParameterResolver;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ManagerEmployeeParameterResolver.class)
class ManagerEmployeeTest {

    @Test
    void shouldGetSubordinates(ManagerEmployee employee) throws Exception {
        assertNotNull(employee.getSubordinates());
    }

    @Test
    void shouldAddSubordinate(ManagerEmployee employee) throws Exception {
        assertTrue(employee.getSubordinates().size() == 0);
        employee.getSubordinates().add(employee);
        assertTrue(employee.getSubordinates().size() == 1);
    }

    @Test
    void shouldRemoveSubordinate(ManagerEmployee employee) throws Exception {
        OrdinaryEmployee test = new OrdinaryEmployee("test", "employee");
        employee.getSubordinates().add(test);
        assertTrue(employee.getSubordinates().size() == 1);
        employee.removeSubordinate(test);
        assertTrue(employee.getSubordinates().size() == 0);
    }

    @Test
    void shouldSetManager(ManagerEmployee employee) throws Exception {
        assertNull(employee.getManager());
        employee.setManager(employee);
        assertNotNull(employee.getManager());
    }

    @Test
    void shouldRemoveManager(ManagerEmployee employee) throws Exception {
        employee.setManager(employee);
        assertNotNull(employee.getManager());
        employee.removeManager();
        assertNull(employee.getManager());
    }

    @Test
    void hasManager(ManagerEmployee employee) throws Exception {
        assertFalse(employee.hasManager());
        employee.setManager(employee);
        assertTrue(employee.hasManager());
    }
}
