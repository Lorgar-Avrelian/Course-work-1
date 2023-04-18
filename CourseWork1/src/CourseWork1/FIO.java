package CourseWork1;

public class FIO {
    private String surname;
    private String name;
    private String secondName;

    public FIO(String surname, String name, String secondName) {
        if (surname == null) {
            this.surname = " ";
        } else {
            this.surname = surname;
        }
        if (name == null) {
            this.name = " ";
        } else {
            this.name = name;
        }
        if (secondName == null) {
            this.secondName = " ";
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

    public boolean equals(FIO fio) {
        if (fio.getSurname().equals(this.getSurname()) && fio.getName().equals(this.getName()) && fio.getSurname().equals(this.getSurname())) {
            return true;
        } else {
            return false;
        }
    }
}
