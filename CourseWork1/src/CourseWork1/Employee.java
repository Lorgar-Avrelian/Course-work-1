package CourseWork1;

import java.text.DecimalFormat;

public class Employee {
    private final FIO fio;
    private String department;
    private int salary;
    private final int id;

    public Employee(FIO fio, String department, int salary, int id) {
        this.fio = fio;
        this.department = department;
        this.salary = salary;
        this.id = id;
    }

    public FIO getFIO() {
        return fio;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return fio.toString() + ", отдел " + getDepartment() + ", зарплата " + new DecimalFormat("###,###").format(salary) + " $ в месяц, id = " + id;
    }
}
