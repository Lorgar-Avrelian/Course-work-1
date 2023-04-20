package CourseWork1;

import java.text.DecimalFormat;

public class EmployeeService {
    private static int sum;
    private int salaryIndexationPercent;
    private static int minSalaryId;
    private static int maxSalaryId;
    private int sizeOfCompany;
    private Employee[] employee;
    private String department;
    private int departmentSalaryBorder;

    public EmployeeService(int sizeOfCompany, Employee[] employee) {
        this.sizeOfCompany = sizeOfCompany;
        FIO defaultFio = new FIO("Фамилия", "Имя", "Отчество");
        for (int i = 0; i < sizeOfCompany; i++) {
            if (employee[i] == null) {
                employee[i] = new Employee(defaultFio, "Отдел", 0);
            }
        }
        this.employee = employee;
    }

    public EmployeeService(int sizeOfCompany, Employee[] employee, int salaryIndexationPercent) {
        this.salaryIndexationPercent = salaryIndexationPercent;
        this.sizeOfCompany = sizeOfCompany;
        this.employee = employee;
    }

    public EmployeeService(int sizeOfCompany, Employee[] employee, String department) {
        this.sizeOfCompany = sizeOfCompany;
        this.employee = employee;
        this.department = department;
    }

    public EmployeeService(int sizeOfCompany, Employee[] employee, String department, int salaryIndexationPercent) {
        this.sizeOfCompany = sizeOfCompany;
        this.employee = employee;
        this.department = department;
        this.salaryIndexationPercent = salaryIndexationPercent;
    }

    public EmployeeService(int departmentSalaryBorder, int sizeOfCompany, Employee[] employee, String department) {
        this.sizeOfCompany = sizeOfCompany;
        this.employee = employee;
        this.department = department;
        this.departmentSalaryBorder = departmentSalaryBorder;
    }

    public int getSalaryIndexationPercent() {
        return salaryIndexationPercent;
    }

    public int getDepartmentSalaryBorder() {
        return departmentSalaryBorder;
    }

    public int getSizeOfCompany() {
        return sizeOfCompany;
    }

    public String getDepartment() {
        return department;
    }


    public void printEmployeesList() {
        for (int i = 0; i < getSizeOfCompany(); i++) {
            System.out.println(employee[i].toString());
        }
        System.out.println();
    }

    public int sumExpenses() {
        sum = 0;
        for (int i = 0; i < getSizeOfCompany(); i++) {
            sum += employee[i].getSalary();
        }
        return sum;
    }

    public Employee minSalaryEmployee() {
        int minSalary = employee[0].getSalary();
        for (int i = 0; i < getSizeOfCompany(); i++) {
            if (minSalary >= employee[i].getSalary()) {
                minSalary = employee[i].getSalary();
                minSalaryId = i;
            }
        }
        return employee[minSalaryId];
    }

    public Employee maxSalaryEmployee() {
        int maxSalary = employee[0].getSalary();
        for (int i = 0; i < getSizeOfCompany(); i++) {
            if (maxSalary <= employee[i].getSalary()) {
                maxSalary = employee[i].getSalary();
                maxSalaryId = i;
            }
        }
        return employee[maxSalaryId];
    }

    public void setSalaryOnPercent() {
        int newSalary = 0;
        for (int i = 0; i < getSizeOfCompany(); i++) {
            newSalary = employee[i].getSalary() + employee[i].getSalary() * getSalaryIndexationPercent() / 100;
            employee[i].setSalary(newSalary);
        }
    }

    public Employee minDepartmentSalary() {
        int minDepartmentSalaryId = 0;
        int minDepartmentSalary = Integer.MAX_VALUE;
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
        int maxDepartmentSalaryId = 0;
        int maxDepartmentSalary = Integer.MIN_VALUE;
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
        int sumDepartmentSalary = 0;
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
        int averageDepartmentSalary = sumDepartmentSalary() / countDepartmentEmployees();
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
