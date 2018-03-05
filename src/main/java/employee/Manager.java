package employee;

import java.util.List;

public interface Manager {
    List<Employee> getSubordinates();

    void addSubordinate(Employee subordinate);

    void removeSubordinate(Employee subordinate);
}
