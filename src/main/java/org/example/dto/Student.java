package org.example.dto;

import org.example.enums.GeneralStatus;

import java.time.LocalDate;

public class Student {
    private Integer id;
    private String name;
    private String surname;
    private String phone;
    private GeneralStatus status;
    private LocalDate birthDate;
    public Student() {
    }
    public Student(Integer id, String name, String surname, String phone, GeneralStatus status, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.status = status;
        this.birthDate = birthDate;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public GeneralStatus getStatus() {
        return status;
    }
    public void setStatus(GeneralStatus status) {
        this.status = status;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", birthDate=" + birthDate +
                '}';
    }
}
