package employee;

import java.util.List;

public class OrdinaryEmployee extends Employee {
    public OrdinaryEmployee(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public List<Employee> getSubordinates() {
        return null;
    }
}
