package CourseWork1;

import java.text.DecimalFormat;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int sizeOfCompany = 10;
        int salaryIndexationPercent = 10;
        int departmentSalaryIndexationPercent = 1;
        int departmentSalaryBorder = 50_000;
        String department = "1";
        FIO[] fio = new FIO[sizeOfCompany];
        Employee[] employee = new Employee[sizeOfCompany];
        System.out.println();

        // Cотрудники ООО "Демоны ада"
        fio[0] = new FIO("Гитлер", "Адольф", "Алоис");
        fio[1] = new FIO("Сталин", "Иосиф", "Виссарионович");
        fio[2] = new FIO("Муссолини", "Бенито", "Алессандро");
        fio[3] = new FIO("Хусейн", "Саддам", "Абд аль-Маджид аль-Тикрити");
        fio[4] = new FIO("Бен Ладен", "Усама", "ибн Мухаммед");
        fio[5] = new FIO("Каддафи", "Муаммар", "Мухаммед Абу Меньяр");
        fio[6] = new FIO("Асад", "Башар", "Хафез");
        fio[7] = new FIO("Пиночет", "Аугусто", "Хосе Рамон");
        fio[8] = new FIO("аз-Завахири", "Айман", "Мухаммад Раби");
        fio[9] = new FIO("Путин", "Владимир", "Владимирович");

        // Отделы: 1 - Боли, 2 - Мучений, 3 - Страданий, 4 - Ужаса, 5 - Горя
        employee[0] = new Employee(fio[0], "1", random.nextInt(100_000));
        employee[1] = new Employee(fio[1], "2", random.nextInt(100_000));
        employee[2] = new Employee(fio[2], "1", random.nextInt(100_000));
        employee[3] = new Employee(fio[3], "3", random.nextInt(100_000));
        employee[4] = new Employee(fio[4], "4", random.nextInt(100_000));
        employee[5] = new Employee(fio[5], "3", random.nextInt(100_000));
        employee[6] = new Employee(fio[6], "5", random.nextInt(100_000));
        employee[7] = new Employee(fio[7], "5", random.nextInt(100_000));
        employee[8] = new Employee(fio[8], "4", random.nextInt(100_000));
        employee[9] = new Employee(fio[9], "2", random.nextInt(100_000));

        System.out.println("Базовый уровень");
        System.out.println();

        // Базовый уровень - Распечатать список сотрудников со всеми данными
        new EmployeeService(sizeOfCompany, employee).printEmployeesList();

        // Базовый уровень - Расчет суммы затрат на зарплаты в месяц
        System.out.println("Сумма затрат на зарплаты в месяц: " + new DecimalFormat("###,###").format(new EmployeeService(sizeOfCompany, employee).sumExpenses()) + " $");
        System.out.println();

        // Базовый уровень - Поиск сотрудника с минимальной зарплатой
        System.out.println("Минимальная зарплата у сотрудника " + new EmployeeService(sizeOfCompany, employee).minSalaryEmployee().toString());
        System.out.println();

        // Базовый уровень - Поиск сотрудника с максимальной зарплатой
        System.out.println("Максимальная зарплата у сотрудника " + new EmployeeService(sizeOfCompany, employee).maxSalaryEmployee().toString());
        System.out.println();

        // Базовый уровень - Подсчет среднего значения зарплат
        System.out.println("Средняя зарплата за месяц " + new DecimalFormat("###,###").format(new EmployeeService(sizeOfCompany, employee).sumExpenses() / sizeOfCompany) + " $");
        System.out.println();

        // Базовый уровень - Список всех сотрудников
        System.out.println("Список сотрудников:");
        System.out.println();
        for (int i = 0; i < sizeOfCompany; i++) {
            System.out.println(employee[i].getFIO().toString());
        }
        System.out.println();
        System.out.println("Повышенная сложность");
        System.out.println();

        // Повышенная сложность - Проиндексировать зарплату на %
        new EmployeeService(sizeOfCompany, employee, salaryIndexationPercent).setSalaryOnPercent();
        new EmployeeService(sizeOfCompany, employee).printEmployeesList();

        // Повышенная сложность - Сотрудник с минимальной зарплатой по отделу
        System.out.println("Минимальная зарплата в отделе " + department + " у сотрудника " + new EmployeeService(sizeOfCompany, employee, department).printMinDepartmentSalary());
        System.out.println();

        // Повышенная сложность - Сотрудник с максимальной зарплатой по отделу
        System.out.println("Максимальная зарплата в отделе " + department + " у сотрудника " + new EmployeeService(sizeOfCompany, employee, department).printMaxDepartmentSalary());
        System.out.println();

        // Повышенная сложность - Сумма зарплат по отделу
        System.out.println("Сумма зарплат по отделу " + department + " равна " + new DecimalFormat("###,###").format(new EmployeeService(sizeOfCompany, employee, department).sumDepartmentSalary()) + " $");
        System.out.println();

        // Повышенная сложность - Среднюю зарплату по отделу
        System.out.println("Средняя зарплата по отделу " + department + " равна " + new DecimalFormat("###,###").format(new EmployeeService(sizeOfCompany, employee, department).averageDepartmentSalary()) + " $");
        System.out.println();

        // Повышенная сложность - Проиндексировать зарплату сотрудников отдела на %
        new EmployeeService(sizeOfCompany, employee, department, departmentSalaryIndexationPercent).setDepartmentSalaryOnPercent();
        new EmployeeService(sizeOfCompany, employee).printEmployeesList();

        // Повышенная сложность - Напечатать всех сотрудников отдела
        System.out.println("Перечень сотрудников отдела " + department);
        new EmployeeService(sizeOfCompany, employee, department).printDepartmentEmployees();

        // Повышенная сложность - Вывод всех сотрудников с зарплатой меньше числа
        new EmployeeService(departmentSalaryBorder, sizeOfCompany, employee, department).showLessSalary();

        // Повышенная сложность - Вывод всех сотрудников с зарплатой больше (или равно) числа
        new EmployeeService(departmentSalaryBorder, sizeOfCompany, employee, department).showAboveSalary();

        System.out.println();
        System.out.println("Очень сложно");
        System.out.println();

        // Очень сложно - Перенести данные о сотрудниках в класс EmployeeBook
        Employee[] employeeBook = new Employee[sizeOfCompany];
        System.arraycopy(employee, 0, employeeBook, 0, sizeOfCompany);
        new EmployeeBook(employeeBook);
        new EmployeeService(sizeOfCompany, employeeBook).printEmployeesList();

        // Очень сложно - Добавление нового сотрудника
        employeeBook = new EmployeeBook(employeeBook).createNewEmployee("Ленин", "Владимир", "Ильич", "2", random.nextInt(100_000));
        new EmployeeBook(employeeBook).printEmployeeBook();

        // Очень сложно - Удаление старого сотрудника по ФИО
        employeeBook = new EmployeeBook(employeeBook).deleteOldEmployee("Путин", "Владимир", "Владимирович");
        new EmployeeBook(employeeBook).printEmployeeBook();

        // Очень сложно - Изменение зарплаты сотрудника
        employeeBook = new EmployeeBook(employeeBook).changeEmployeeSalary("Ленин", "Владимир", "Ильич", 20_000);
        new EmployeeBook(employeeBook).printEmployeeBook();

        // Очень сложно - Изменение отдела сотрудника
        employeeBook = new EmployeeBook(employeeBook).changeEmployeeDepartment("Ленин", "Владимир", "Ильич", "1");
        new EmployeeBook(employeeBook).printEmployeeBook();
    }
}