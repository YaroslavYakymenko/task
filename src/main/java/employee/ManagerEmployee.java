package employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ManagerEmployee extends Employee implements Manager, Subordinate {
    private List<Employee> subordinates;
    private Manager manager;

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
        ((Subordinate) subordinate).setManager(this);
    }

    @Override
    public void removeSubordinate(Employee subordinate) {
        subordinates.remove(subordinate);
        ((Subordinate) subordinate).setManager(null);
    }

    @Override
    public void setManager(Manager manager) {
        if (manager == null) {
            this.manager = null;
            return;
        }
        this.manager = manager;
        if (!this.manager.getSubordinates().contains(this)) {
            this.manager.addSubordinate(this);
        }
    }

    @Override
    public Manager getManager() {
        return manager;
    }

    @Override
    public boolean hasManager() {
        return manager != null;
    }
}
