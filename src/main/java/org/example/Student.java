package org.example;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student
{
    @Id
    @Column(name = "stud_rollNo")
    private int rollNo;
    @Column(name = "stud_name")
    private String name;
    @Column(name="stud_address")
    private String address;
    @Column(name="stud_phNo")
    private String phNo;

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhNo() {
        return phNo;
    }

    public void setPhNo(String phNo) {
        this.phNo = phNo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phNo='" + phNo + '\'' +
                '}';
    }
}
