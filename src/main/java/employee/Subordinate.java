package employee;

public interface Subordinate {
    void setManager(Manager employee);

    Manager getManager();

    boolean hasManager ();
}
