/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.sam.qlphongban.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 *
 * @author nguyenhuuhoa
 */

@Entity
@Table(name = "projects")
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "name",length=50)
    private String name;
    
    @Column(name="location",length=100)
    private String location;
    
    @Column(name="numberOfEmp",nullable=false)
    @Min(1)
    @Max(100)
    private int numberOfEmp;
    
    @Column(name="cost")
    @Min(10000)
    private Double cost;
    
    @Column(name="dayStart")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dayStart;
    
    @Column(name="dayEnd")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dayEnd;
    
    // getter

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getNumberOfEmp() {
        return numberOfEmp;
    }

    public Double getCost() {
        return cost;
    }

    public Date getDayStart() {
        return dayStart;
    }

    public Date getDayEnd() {
        return dayEnd;
    }
    
    // setter

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setNumberOfEmp(int numberOfEmp) {
        this.numberOfEmp = numberOfEmp;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public void setDayStart(Date dayStart) {
        this.dayStart = dayStart;
    }

    public void setDayEnd(Date dayEnd) {
        this.dayEnd = dayEnd;
    }
    
    // Constructor

    public Project(int id, String name, String location, int numberOfEmp, Double cost, Date dayStart, Date dayEnd) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.numberOfEmp = numberOfEmp;
        this.cost = cost;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
    }

    public Project(String name, String location, int numberOfEmp, Double cost, Date dayStart, Date dayEnd) {
        this.name = name;
        this.location = location;
        this.numberOfEmp = numberOfEmp;
        this.cost = cost;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
    }
    
    public Project()
    {
        this.name = "Dự án"+Integer.toString(id);
    }
}
