import company.Company;
import employee.Employee;
import employee.ManagerEmployee;
import employee.OrdinaryEmployee;
import service.CompanyPrintService;
import service.CompanyPrintServiceImpl;
import service.EmployeePrintService;
import service.EmployeePrintServiceImpl;

public class Main {

    public static void main(String[] args) {
        EmployeePrintService employeePrintService = new EmployeePrintServiceImpl();
        CompanyPrintService companyPrintService = new CompanyPrintServiceImpl();

        //Step 2. Add functionality to track an employee's manager and subordinates.
        Employee ceo = new ManagerEmployee("John", "Daw");

        Employee legalManager = new ManagerEmployee("Legal", "Manager");
        legalManager.setManager(ceo);
        ManagerEmployee financeManager = new ManagerEmployee("Finance", "Manager");
        financeManager.setManager(ceo);

        Employee legalClerk1 = new OrdinaryEmployee("Legal", "FirstClerk");
        legalClerk1.setManager(legalManager);
        Employee legalClerk2 = new OrdinaryEmployee("Legal", "SecondClerk");
        legalClerk2.setManager(legalManager);
        Employee legalClerk3 = new OrdinaryEmployee("Legal", "ThirdClerk");

        OrdinaryEmployee financeClerk = new OrdinaryEmployee("Finance", "Clerk");

        //you can move both directions through management hierarchy by setting manager or adding subordinate
        legalClerk3.setManager(legalManager);
        financeManager.addSubordinate(financeClerk);

        ManagerEmployee lowerFinanceManager = new ManagerEmployee("LowerFinance", "Manager");
        //you can move manager up by hierarchy
        lowerFinanceManager.setManager(financeManager);
        lowerFinanceManager.setManager(ceo);

        OrdinaryEmployee lowerFinanceClerk = new OrdinaryEmployee("LowerFinance", "Clerk");
        lowerFinanceManager.addSubordinate(lowerFinanceClerk);

        //Step 3. Write a method that prints the names of all subordinates for a given employee.
        System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
        System.out.println("Prints the names of all subordinates for a given employee");
        System.out.println("----------------------------------------------------");
        employeePrintService.printSubordinates(financeManager);

        System.out.println("----------------------------------------------------");
        System.out.println("CEO's subordinates");
        employeePrintService.printSubordinates(ceo);

        System.out.println("Prints the names of all subordinates for a given employee");
        System.out.println("----------------------------------------------------");
        lowerFinanceManager.setManager(financeManager);
        employeePrintService.printSubordinates(financeManager);

        //Step 4. Write a method to print the CEO's name for a given employee.
        System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
        System.out.println("Print the CEO's name for a given employee");
        employeePrintService.printCeo(ceo);
        employeePrintService.printCeo(legalManager);
        employeePrintService.printCeo(lowerFinanceClerk);
        employeePrintService.printCeo(legalClerk2);

        //Step 5. Write a method that prints the names of every person in the company.
        System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
        System.out.println("Prints the names of every person in the company");
        Company company = new Company("Big company", ceo);
        company.hireEmployee(legalManager);
        company.hireEmployee(legalClerk1);
        company.hireEmployee(legalClerk2);
        company.hireEmployee(legalClerk3);
        company.hireEmployee(financeManager);
        company.hireEmployee(financeClerk);
        company.hireEmployee(lowerFinanceManager);
        company.hireEmployee(lowerFinanceClerk);

        companyPrintService.printAllEmployeesNames(company);
    }
}
