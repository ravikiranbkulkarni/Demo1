package com.example.demo.model;

import org.hibernate.annotations.GeneratorType;
import javax.persistence.*;
import java.util.Set;


@Entity
public class Author {

    private Long author_id;
    private String firstName;
    private String lastName;
    private String address_line1;
    private String address_line2;
    private String city;
    private String state;
    private String country;
    private int zipcode;


    public Author(){

    }

    public Author(String firstName, String lastName, String address_line1, String address_line2, String city,String state, String country, int zipcode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address_line1 = address_line1;
        this.address_line2 = address_line2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipcode = zipcode;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress_line1() {
        return address_line1;
    }

    public void setAddress_line1(String address_line1) {
        this.address_line1 = address_line1;
    }

    public String getAddress_line2() {
        return address_line2;
    }

    public void setAddress_line2(String address_line2) {
        this.address_line2 = address_line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Override

    public String toString() {
        return String.format(
                "Author[author_id=%d, firstName='%s', lastName='%s']",
                author_id, firstName, lastName);
    }

}
