package de.thws.Lektion15.person;

public class Hochschule {
    public static void main(String[] args) {
        Person[] personen = new Person[100];

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                personen[i] = new Student("Programmieren");
            } else {
                personen[i] = new Professor("Programmieren");
            }
        }

        for (Person p : personen) {
            p.gibTaetigkeitAus();
        }
    }
}

