package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity  //owners end
public class Address {
        @Id
        private int aid;
        private String number;
        private String street;
        private String city;

    public Address() {
    }

    public Address(int aid, String number, String street, String city) {
        this.aid = aid;
        this.number = number;
        this.street = street;
        this.city = city;
    }

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
}
