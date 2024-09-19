package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;
@Entity
public class Address {
    @Id
    private int aid;
    private String number;
    private String street;
    private String city;

    @ManyToMany
    private List<Student> students;

    public Address(int aid, String number, String street, String city, List<Student> students) {
        this.aid = aid;
        this.number = number;
        this.street = street;
        this.city = city;
        this.students = students;
    }
    public Address() {}

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
