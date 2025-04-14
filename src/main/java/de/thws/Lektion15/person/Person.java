package de.thws.Lektion15.person;

public abstract class Person {
    protected String fach;

    public Person(String fach) {
        this.fach = fach;
    }

    public abstract void gibTaetigkeitAus();
}
