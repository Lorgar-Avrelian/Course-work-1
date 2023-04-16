package CourseWork1;

public class EmployeeService {
    private static int sum;
    private int salaryIndexationPercent;
    private static int minSalaryId;
    private static int maxSalaryId;
    private int sizeOfCompany;
    private Employee[] employee;

    public EmployeeService(int sizeOfCompany, Employee[] employee) {
        this.sizeOfCompany = sizeOfCompany;
        this.employee = employee;
    }
    public EmployeeService(int sizeOfCompany, Employee[] employee, int salaryIndexationPercent) {
        this.salaryIndexationPercent = salaryIndexationPercent;
        this.sizeOfCompany = sizeOfCompany;
        this.employee = employee;
    }

    public int getSizeOfCompany() {
        return sizeOfCompany;
    }

    public int getSalaryIndexationPercent() {
        return salaryIndexationPercent;
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
}
