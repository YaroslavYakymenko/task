package employee;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import parameters.OrdinaryEmployeeParameterResolver;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(OrdinaryEmployeeParameterResolver.class)
class OrdinaryEmployeeTest {

    @Test
    void shouldReturnNullWhenGetSubordinates(OrdinaryEmployee employee) throws Exception {
        assertNull(employee.getSubordinates());
    }

    @Test
    void shouldSetManager(OrdinaryEmployee employee) throws Exception {
        assertNull(employee.getManager());
        employee.setManager(new ManagerEmployee("test","manager"));
        assertNotNull(employee.getManager());
    }

    @Test
    void shouldRemoveManager(OrdinaryEmployee employee) throws Exception {
        employee.setManager(new ManagerEmployee("test","manager"));
        assertNotNull(employee.getManager());
        employee.removeManager();
        assertNull(employee.getManager());
    }

    @Test
    void hasManager(OrdinaryEmployee employee) throws Exception {
        assertFalse(employee.hasManager());
        employee.setManager(new ManagerEmployee("test","manager"));
        assertTrue(employee.hasManager());
    }
}
