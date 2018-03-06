package employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public abstract class Employee {
    private String firstName;
    private String lastName;
    private Employee manager;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "\"" + firstName + " " + lastName + "\"";
    }

    public void setManager(Employee employee) {
        removeManager();
        this.manager = employee;
        if (this.manager == null) return;
        List<Employee> subordinates = this.manager.getSubordinates();
        if (!subordinates.contains(this)) {
            this.manager.getSubordinates().add(this);
        }
    }

    public void removeManager() {
        if (this.manager != null) {
            this.manager.getSubordinates().remove(this);
            this.manager = null;
        }
    }

    public Employee getManager() {
        return manager;
    }

    public boolean hasManager() {
        return manager != null;
    }

    public abstract List<Employee> getSubordinates();
}
