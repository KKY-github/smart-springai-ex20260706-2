package com.example.bookapi.book;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String passwd;

    private Integer age;

    private Integer birth;

    protected Users() {
    }

    public Users(String name, String passwd, Integer age, Integer birth) {
        this.name = name;
        this.passwd = passwd;
        this.age = age;
        this.birth = birth;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPasswd() {
        return passwd;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getBirth() {
        return birth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirth(Integer birth) {
        this.birth = birth;
    }
}
