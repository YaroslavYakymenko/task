import company.Company;
import employee.Employee;
import employee.Manager;
import employee.ManagerEmployee;
import employee.OrdinaryEmployee;
import service.CompanyService;
import service.CompanyServiceImpl;
import service.EmployeeService;
import service.EmployeeServiceImpl;

public class Main {

    public static void main(String[] args) {
        //Step 2. Add functionality to track an employee's manager and subordinates.
        ManagerEmployee ceo = new ManagerEmployee("John", "Daw");

        ManagerEmployee legalManager = new ManagerEmployee("Legal", "Manager");
        legalManager.setManager(ceo);

        OrdinaryEmployee legalClerk1 = new OrdinaryEmployee("Legal", "Clerk");
        OrdinaryEmployee legalClerk2 = new OrdinaryEmployee("Legal", "Employee");
        legalClerk1.setManager(legalManager);
        legalClerk2.setManager(legalManager);

        ManagerEmployee financeManager = new ManagerEmployee("Finance", "Manager");
        OrdinaryEmployee financeClerk = new OrdinaryEmployee("Finance", "Clerk");
        financeManager.setManager(ceo);
        financeManager.addSubordinate(financeClerk);

        //Step 3. Write a method that prints the names of all subordinates for a given employee.
        System.out.println("Names of all subordinates for a given employee.");
        EmployeeService employeeService = new EmployeeServiceImpl();
        System.out.println("Subordinates of " + legalManager.toString() + ":");
        employeeService.printSubordinatesNames(legalManager);
        System.out.println("Subordinates of " + financeManager.toString() + ":");
        employeeService.printSubordinatesNames(financeManager);
        System.out.println("Subordinates of " + ceo.toString() + ":");
        employeeService.printSubordinatesNames(ceo);

        //Step 4. Write a method to print the CEO's name for a given employee.
        System.out.println("CEO's name for a given employee");
        System.out.println("CEO of " + legalClerk1.toString() + ":");
        employeeService.printCEOName(legalClerk1);
        System.out.println("CEO of " + legalClerk2.toString() + ":");
        employeeService.printCEOName(legalClerk2);
        System.out.println("CEO of " + legalManager.toString() + ":");
        employeeService.printCEOName(legalManager);
        System.out.println("CEO of " + financeManager.toString() + ":");
        employeeService.printCEOName(financeManager);

        //Step 5. Write a method that prints the names of every person in the company.
        Company company = new Company(ceo);
        company.hireEmployee(legalManager);
        company.hireEmployee(legalClerk1);
        company.hireEmployee(legalClerk2);
        company.hireEmployee(financeManager);
        company.hireEmployee(financeClerk);

        CompanyService companyService = new CompanyServiceImpl();
        System.out.println("Every person in the company:");
        companyService.printNamesOfCompanyEmployees(company);
    }
}
