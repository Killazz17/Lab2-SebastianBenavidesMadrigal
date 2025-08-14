package org.example.Entities;

public class Doctor {
    private String name;
    private String lastName;
    private String speciality;
    private int age;

    //Constructor

    public Doctor(String name, String lastName, int age, String speciality) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.speciality = speciality;
    }

    //getter and setters

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

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    //toString

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", speciality='" + speciality + '\'' +
                ", age=" + age +
                '}';
    }
}
