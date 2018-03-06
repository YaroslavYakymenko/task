package employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ManagerEmployee extends Employee implements Manager {
    private List<Employee> subordinates;

    public ManagerEmployee(String firstName, String lastName) {
        super(firstName, lastName);
        this.subordinates = new ArrayList<>();
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    @Override
    public void addSubordinate(Employee subordinate) {
        this.subordinates.add(subordinate);
        subordinate.setManager(this);
    }

    @Override
    public void removeSubordinate(Employee subordinate) {
        subordinates.remove(subordinate);
        subordinate.setManager(null);
    }
}
