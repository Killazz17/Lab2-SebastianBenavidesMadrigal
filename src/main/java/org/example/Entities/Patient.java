package org.example.Entities;

public class Patient {
    private String name;
    private String lastName;
    private int age;
    private String diagnost;

    //Constructor

    public Patient(String name, String lastName, int age, String diagnost) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.diagnost = diagnost;
    }

    //getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDiagnost() {
        return diagnost;
    }

    public void setDiagnost(String diagnost) {
        this.diagnost = diagnost;
    }

    //toString

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", diagnost='" + diagnost + '\'' +
                '}';
    }
}
