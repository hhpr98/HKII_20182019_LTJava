/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam.qlphongban.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author nguyenhuuhoa
 */

@Entity
@Table(name = "employees")
public class Employee implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    @Column(name ="eid")
    private int eid;
    
    @Column(name="name")
    private String ename;
    
    @Column(name="salary")
    private double salary;
    
    @Column(name="deg")
    private String deg;
    
    @ManyToOne
    @JoinColumn(name="did")
    private Department department;
    
    // getter

    public int getEid() {
        return eid;
    }

    public String getEname() {
        return ename;
    }

    public double getSalary() {
        return salary;
    }

    public String getDeg() {
        return deg;
    }

    public Department getDepartment() {
        return department;
    }
    
    // setter

    public void setEid(int eid) {
        this.eid = eid;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDeg(String deg) {
        this.deg = deg;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    
    // constructor

    public Employee(int eid, String ename, double salary, String deg, Department department) {
        this.eid = eid;
        this.ename = ename;
        this.salary = salary;
        this.deg = deg;
        this.department = department;
    }

    public Employee(String ename, double salary, String deg, Department department) {
        this.ename = ename;
        this.salary = salary;
        this.deg = deg;
        this.department = department;
    }

    public Employee(String ename, double salary, String deg) {
        this.ename = ename;
        this.salary = salary;
        this.deg = deg;
    }
    
    public Employee()
    {
        this.ename="Nhân viên " + Integer.toString(this.eid);
        this.salary = 0;
        this.deg = "";
    }
    
}
