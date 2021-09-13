package telran.employee.controller;

import telran.employee.model.Employee;
import telran.employee.model.Manager;
import telran.employee.model.SalesManager;
import telran.employee.model.WageEmployee;

public class EmployeeAppl {
    public static void main(String[] args) {
        Employee[] firm = new Employee[6]; //Upper Casting ява делает сама.
        firm[0] = new Manager(34519264, "John", "Smith", 182, 20000, 20);
        firm[1] = new WageEmployee(12543645, "Mary", "Smith", 182, 40);
        firm[2] = new SalesManager(2546516, "Peter", "Jackson", 182, 20000, 0.1);
        firm[3] = new SalesManager(34514654, "Ivan", "Balda", 91, 80000, 0.1);
        printArray(firm);
        double total = totalSalary(firm);
        System.out.println("Total Salary= " + total);
        total =  totalSalesValue(firm);
        System.out.println("Total Sales= " + total);

    }

    private static double totalSalesValue(Employee[] firm) {
        double sum = 0;
        for (int i = 0; i < firm.length; i++) {
            if (firm[i] != null) {
                if (firm[i] instanceof SalesManager) {
                    SalesManager sm = (SalesManager) firm[i];
                    sum += sm.getSalesValue();
                }
            }
        }
        return sum;
    }
    private static double totalSalary(Employee[] firm) {
        double sum = 0;
        for (int i = 0; i < firm.length; i++) {
            if (firm[i] != null) {
                sum += firm[i].calcSalary();
            }

        }
        return sum;
    }

    private static void printArray(Employee[] firm) {
        for (int i = 0; i < firm.length; i++) {
            if (firm[i] != null) {
                System.out.println(firm[i]);
            }
        }
    }
}
