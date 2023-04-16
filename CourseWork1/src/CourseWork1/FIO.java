package CourseWork1;

public class FIO {
    private String surname;
    private String name;
    private String secondName;

    public FIO(String surname, String name, String secondName) {
        this.surname = surname;
        this.name = name;
        this.secondName = secondName;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public String toString() {
        return "ФИО: " + getSurname() + " " + getName() + " " + getSecondName();
    }
}
