package service;

import employee.*;

import java.util.Objects;

public interface EmployeeService {
    default void printSubordinatesNames(Manager manager) {
        manager.getSubordinates().stream()
                .map(Employee::toString)
                .forEach(System.out::println);
    }

    default void printCEOName(Subordinate subordinate){
        Objects.requireNonNull(subordinate);
        ManagerEmployee manager =(ManagerEmployee) subordinate.getManager();
        while (manager.hasManager()) {
            manager = (ManagerEmployee) manager.getManager();
        }
        System.out.println(manager.toString());
    }
}
