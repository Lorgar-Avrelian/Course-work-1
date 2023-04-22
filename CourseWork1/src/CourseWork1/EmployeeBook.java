package CourseWork1;

public class EmployeeBook {
    private Employee[] employeeBook;

    public EmployeeBook(Employee[] employeeBook) {
        this.employeeBook = employeeBook;
    }

    public Employee[] createNewEmployee(String surname, String name, String secondName, String department, int salary) {

        FIO defaultFIO = new FIO("Фамилия", "Имя", "Отчество");
        int position = 0;
        for (int i = 0; i < employeeBook.length; i++) {
            FIO currentFIO = employeeBook[i].getFIO();
            if (currentFIO.equals(defaultFIO)) {
                position = i;
            }
        }
        Employee[] cutEmployeeBook = new Employee[employeeBook.length - 1];
        for (int i = 0; i < cutEmployeeBook.length; i++) {
            if (i < position) {
                cutEmployeeBook[i] = employeeBook[i];
            } else {
                cutEmployeeBook[i] = employeeBook[i + 1];
            }
        }
        employeeBook = cutEmployeeBook;
        FIO newFIO = new FIO(surname, name, secondName);
        Employee newEmployee = new Employee(newFIO, department, salary);
        Employee[] newEmployeeBook = new Employee[employeeBook.length + 1];
        for (int i = 0; i < employeeBook.length; i++) {
            newEmployeeBook[i] = employeeBook[i];
        }
        newEmployeeBook[newEmployeeBook.length - 1] = newEmployee;
        employeeBook = newEmployeeBook;
        return employeeBook;
    }

    public Employee[] deleteOldEmployee(String surname, String name, String secondName) {
        FIO oldFIO = new FIO(surname, name, secondName);
        int position = 0;
        for (int i = 0; i < employeeBook.length; i++) {
            FIO currentFIO = employeeBook[i].getFIO();
            if (currentFIO.equals(oldFIO)) {
                position = i;
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
        FIO oldFIO = new FIO(surname, name, secondName);
        int position = 0;
        for (int i = 0; i < employeeBook.length; i++) {
            FIO currentFIO = employeeBook[i].getFIO();
            if (currentFIO.equals(oldFIO)) {
                position = i;
            }
        }
        employeeBook[position].setSalary(salary);
        System.out.println("Зарплата " + employeeBook[position].getFIO().toString() + " изменена");
        System.out.println();
        return employeeBook;
    }

    public Employee[] changeEmployeeDepartment(String surname, String name, String secondName, String department) {
        FIO oldFIO = new FIO(surname, name, secondName);
        int position = 0;
        for (int i = 0; i < employeeBook.length; i++) {
            FIO currentFIO = employeeBook[i].getFIO();
            if (currentFIO.equals(oldFIO)) {
                position = i;
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
