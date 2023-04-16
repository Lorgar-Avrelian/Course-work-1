package CourseWork1;

import java.text.DecimalFormat;

public class EmployeeDepartmentService {
    private final int sizeOfCompany;
    private final Employee[] employee;
    private final String department;
    private int departmentSalaryBorder;
    private int salaryIndexationPercent;
    private static int minDepartmentSalary;
    private static int maxDepartmentSalary;
    private static int sumDepartmentSalary;
    private static int averageDepartmentSalary;
    private static int minDepartmentSalaryId;
    private static int maxDepartmentSalaryId;

    public EmployeeDepartmentService(int sizeOfCompany, Employee[] employee, String department) {
        this.sizeOfCompany = sizeOfCompany;
        this.employee = employee;
        this.department = department;
    }

    public EmployeeDepartmentService(int sizeOfCompany, Employee[] employee, String department, int salaryIndexationPercent) {
        this.sizeOfCompany = sizeOfCompany;
        this.employee = employee;
        this.department = department;
        this.salaryIndexationPercent = salaryIndexationPercent;
    }

    public EmployeeDepartmentService(int departmentSalaryBorder, int sizeOfCompany, Employee[] employee, String department) {
        this.sizeOfCompany = sizeOfCompany;
        this.employee = employee;
        this.department = department;
        this.departmentSalaryBorder = departmentSalaryBorder;
    }

    public int getSizeOfCompany() {
        return sizeOfCompany;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalaryIndexationPercent() {
        return salaryIndexationPercent;
    }

    public int getDepartmentSalaryBorder() {
        return departmentSalaryBorder;
    }

    public Employee minDepartmentSalary() {
        minDepartmentSalaryId = 0;
        minDepartmentSalary = Integer.MAX_VALUE;
        for (int i = 0; i < getSizeOfCompany(); i++) {
            if (department.equals(employee[i].getDepartment())) {
                if (minDepartmentSalary >= employee[i].getSalary()) {
                    minDepartmentSalary = employee[i].getSalary();
                    minDepartmentSalaryId = i;
                }
            }
        }
        return employee[minDepartmentSalaryId];
    }

    public Employee maxDepartmentSalary() {
        maxDepartmentSalaryId = 0;
        maxDepartmentSalary = Integer.MIN_VALUE;
        for (int i = 0; i < getSizeOfCompany(); i++) {
            if (department.equals(employee[i].getDepartment())) {
                if (maxDepartmentSalary <= employee[i].getSalary()) {
                    maxDepartmentSalary = employee[i].getSalary();
                    maxDepartmentSalaryId = i;
                }
            }
        }
        return employee[maxDepartmentSalaryId];
    }

    public int sumDepartmentSalary() {
        sumDepartmentSalary = 0;
        for (int i = 0; i < getSizeOfCompany(); i++) {
            if (department.equals(employee[i].getDepartment())) {
                sumDepartmentSalary += employee[i].getSalary();
            }
        }
        return sumDepartmentSalary;
    }

    public int countDepartmentEmployees() {
        int countDepartmentEmployees = 0;
        for (int i = 0; i < getSizeOfCompany(); i++) {
            if (department.equals(employee[i].getDepartment())) {
                countDepartmentEmployees += 1;
            }
        }
        return countDepartmentEmployees;
    }

    public int averageDepartmentSalary() {
        averageDepartmentSalary = sumDepartmentSalary() / countDepartmentEmployees();
        return averageDepartmentSalary;
    }

    public void setDepartmentSalaryOnPercent() {
        int newSalary;
        for (int i = 0; i < getSizeOfCompany(); i++) {
            if (department.equals(employee[i].getDepartment())) {
                newSalary = employee[i].getSalary() + employee[i].getSalary() * getSalaryIndexationPercent() / 100;
                employee[i].setSalary(newSalary);
            }
        }
    }

    public String printMinDepartmentSalary() {
        return minDepartmentSalary().getFIO().toString() + ", зарплата " + new DecimalFormat("###,###").format(minDepartmentSalary().getSalary()) + " $ в месяц, id = " + minDepartmentSalary().getId();
    }

    public String printMaxDepartmentSalary() {
        return maxDepartmentSalary().getFIO().toString() + ", зарплата " + new DecimalFormat("###,###").format(maxDepartmentSalary().getSalary()) + " $ в месяц, id = " + maxDepartmentSalary().getId();
    }

    public void printDepartmentEmployees() {
        for (int i = 0; i < getSizeOfCompany(); i++) {
            if (getDepartment().equals(employee[i].getDepartment())) {
                System.out.println(employee[i].getFIO().toString() + ", зарплата " + new DecimalFormat("###,###").format(employee[i].getSalary()) + " $ в месяц, id = " + employee[i].getId());
            }
        }
        System.out.println();
    }

    public void showLessSalary() {
        System.out.println("Перечень сотрудников отдела " + getDepartment() + ", зарплата которых меньше " + getDepartmentSalaryBorder() + " $:");
        for (int i = 0; i < getSizeOfCompany(); i++) {
            if (getDepartment().equals(employee[i].getDepartment())) {
                if (employee[i].getSalary() < getDepartmentSalaryBorder()) {
                    System.out.println(employee[i].getFIO().toString() + ", зарплата " + new DecimalFormat("###,###").format(employee[i].getSalary()) + " $ в месяц, id = " + employee[i].getId());
                }
            }
        }
        System.out.println();
    }

    public void showAboveSalary() {
        System.out.println("Перечень сотрудников отдела " + getDepartment() + ", зарплата которых больше " + getDepartmentSalaryBorder() + " $:");
        for (int i = 0; i < getSizeOfCompany(); i++) {
            if (getDepartment().equals(employee[i].getDepartment())) {
                if (employee[i].getSalary() >= getDepartmentSalaryBorder()) {
                    System.out.println(employee[i].getFIO().toString() + ", зарплата " + new DecimalFormat("###,###").format(employee[i].getSalary()) + " $ в месяц, id = " + employee[i].getId());
                }
            }
        }
        System.out.println();
    }
}
