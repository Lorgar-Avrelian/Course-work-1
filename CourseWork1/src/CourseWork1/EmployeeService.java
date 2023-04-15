package CourseWork1;

public class EmployeeService {
    private static int sum;
    private static int minSalaryId;
    private static int maxSalaryId;
    private int sizeOfCompany;
    private Employee[] employee;

    public EmployeeService(int sizeOfCompany, Employee[] employee) {
        this.sizeOfCompany = sizeOfCompany;
        this.employee = employee;
    }

    public int getSizeOfCompany() {
        return sizeOfCompany;
    }

    public Employee[] getEmployee() {
        return employee;
    }

    public void setSizeOfCompany(int sizeOfCompany) {
        this.sizeOfCompany = sizeOfCompany;
    }

    public void setEmployee(Employee[] employee) {
        this.employee = employee;
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
        for (int i = 0; i < sizeOfCompany; i++) {
            if (minSalary >= employee[i].getSalary()) {
                minSalary = employee[i].getSalary();
                minSalaryId = i;
            }
        }
        return employee[minSalaryId];
    }
    public Employee maxSalaryEmployee() {
        int maxSalary = employee[0].getSalary();
        for (int i = 0; i < sizeOfCompany; i++) {
            if (maxSalary <= employee[i].getSalary()) {
                maxSalary = employee[i].getSalary();
                maxSalaryId = i;
            }
        }
        return employee[maxSalaryId];
    }
}
