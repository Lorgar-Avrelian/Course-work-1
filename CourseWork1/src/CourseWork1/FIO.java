package CourseWork1;

import java.util.Objects;

public class FIO {
    private String surname;
    private String name;
    private String secondName;

    public FIO(String surname, String name, String secondName) {
        if (surname == null) {
            this.surname = "Фамилия";
        } else {
            this.surname = surname;
        }
        if (name == null) {
            this.name = "Имя";
        } else {
            this.name = name;
        }
        if (secondName == null) {
            this.secondName = "Отчество";
        } else {
            this.secondName = secondName;
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FIO)) return false;
        FIO fio = (FIO) o;
        return surname.equals(fio.surname) && name.equals(fio.name) && secondName.equals(fio.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, secondName);
    }
}
