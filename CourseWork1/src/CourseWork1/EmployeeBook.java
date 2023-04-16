package CourseWork1;

public class EmployeeBook {
    private Employee[] employeeBook;
    private String department;
    private int id;
    private int salary;
    private String surname;
    private String name;
    private String secondName;

    public EmployeeBook(Employee[] employeeBook) {
        this.employeeBook = employeeBook;
    }

    public Employee[] createNewEmployee(String surname, String name, String secondName, String department, int salary, int id) {
        this.surname = surname;
        this.name = name;
        this.secondName = secondName;
        this.department = department;
        this.salary = salary;
        this.id = id;
        FIO newFIO = new FIO(surname, name, secondName);
        Employee newEmployee = new Employee(newFIO, department, salary, id);
        Employee[] newEmployeeBook = new Employee[employeeBook.length + 1];
        for (int i = 0; i < employeeBook.length; i++) {
            newEmployeeBook[i] = employeeBook[i];
        }
        newEmployeeBook[newEmployeeBook.length - 1] = newEmployee;
        employeeBook = newEmployeeBook;
        return employeeBook;
    }

    public Employee[] deleteOldEmployee(String surname, String name, String secondName) {
        this.surname = surname;
        this.name = name;
        this.secondName = secondName;
        FIO oldFIO = new FIO(surname, name, secondName);
        int position = 0;
        for (int i = 0; i < employeeBook.length; i++) {
            FIO currentFIO = employeeBook[i].getFIO();
            if (currentFIO.getSurname().equals(oldFIO.getSurname())) {
                if (currentFIO.getName().equals(oldFIO.getName())) {
                    if (currentFIO.getSurname().equals(oldFIO.getSurname())) {
                        position = i;
                    }
                }
            }
        }
        System.out.println(employeeBook[position].getFIO().toString() + " удален");
        System.out.println();
        Employee[] newEmployeeBook = new Employee[employeeBook.length - 1];
        for (int i = 0; i < newEmployeeBook.length; i++) {
            if (i < position) {
                newEmployeeBook[i] = employeeBook[i];
            } else {
                newEmployeeBook[i] = employeeBook[i + 1];
            }
        }
        employeeBook = newEmployeeBook;
        return employeeBook;
    }

    public Employee[] changeEmployeeSalary(String surname, String name, String secondName, int salary) {
        this.surname = surname;
        this.name = name;
        this.secondName = secondName;
        this.salary = salary;
        FIO oldFIO = new FIO(surname, name, secondName);
        int position = 0;
        for (int i = 0; i < employeeBook.length; i++) {
            FIO currentFIO = employeeBook[i].getFIO();
            if (currentFIO.getSurname().equals(oldFIO.getSurname())) {
                if (currentFIO.getName().equals(oldFIO.getName())) {
                    if (currentFIO.getSurname().equals(oldFIO.getSurname())) {
                        position = i;
                    }
                }
            }
        }
        employeeBook[position].setSalary(salary);
        System.out.println("Зарплата " + employeeBook[position].getFIO().toString() + " изменена");
        System.out.println();
        return employeeBook;
    }

    public Employee[] changeEmployeeDepartment(String surname, String name, String secondName, String department) {
        this.surname = surname;
        this.name = name;
        this.secondName = secondName;
        this.department = department;
        FIO oldFIO = new FIO(surname, name, secondName);
        int position = 0;
        for (int i = 0; i < employeeBook.length; i++) {
            FIO currentFIO = employeeBook[i].getFIO();
            if (currentFIO.getSurname().equals(oldFIO.getSurname())) {
                if (currentFIO.getName().equals(oldFIO.getName())) {
                    if (currentFIO.getSurname().equals(oldFIO.getSurname())) {
                        position = i;
                    }
                }
            }
        }
        employeeBook[position].setDepartment(department);
        System.out.println("Отдел " + employeeBook[position].getFIO().toString() + " изменен");
        System.out.println();
        return employeeBook;
    }

    public void printEmployeeBook() {
        for (int i = 0; i < employeeBook.length; i++) {
            System.out.println(employeeBook[i].toString());
        }
        System.out.println();
    }
}
