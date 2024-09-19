package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Student {

    @Id
    private int id;
    private String name;
    private int age;
    public Student() {}

    @OneToMany(mappedBy = "student",fetch = FetchType.EAGER)
    private List<Address> addresses;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Student(int id, String name, int age, List<Address> addresses) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.addresses = addresses;
    }
}
