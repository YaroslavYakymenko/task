package employee;

public class OrdinaryEmployee extends Employee implements Subordinate {
    private Manager manager;

    public OrdinaryEmployee(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public OrdinaryEmployee(String firstName, String lastName, Manager manager) {
        super(firstName, lastName);
        this.manager = manager;
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
        return this.manager;
    }

    @Override
    public boolean hasManager() {
        return manager != null;
    }
}
