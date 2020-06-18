/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nguyenhuuhoa.webshop.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

/**
 *
 * @author nguyenhuuhoa
 */

@Entity
@Table(name = "sanphams")
public class SanPham  implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "MaSP",nullable=false)
    private int id;
    
    @Column(name="TenSP",length=100)
    private String name;
    
    @Column(name="HinhAnh",length=100)
    private String image;
    
    @Min(1000)
    @Column(name="GiaBan")
    private Double cost;
    
    @Min(0)
    @Column(name="SoLuong")
    private int number;
    
    @Column(name="XuatXu",length=100)
    private String location;
    
    @Column(name="NhaSanXuat",length=100)
    private String nsx;
    
    @Column(name="MoTa",length=200)
    private String description;
    
    @Column(name="NgayTiepNhan")
    private Date date;
    
    @ManyToOne
    @JoinColumn(name="LoaiSP")
    private LoaiSanPham type;
    
    // getter

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public Double getCost() {
        return cost;
    }

    public int getNumber() {
        return number;
    }

    public String getLocation() {
        return location;
    }

    public String getNsx() {
        return nsx;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public LoaiSanPham getType() {
        return type;
    }
    
    // setter

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setNsx(String nsx) {
        this.nsx = nsx;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setType(LoaiSanPham type) {
        this.type = type;
    }
    
    // constructor

    public SanPham() {
        this.name="Sản phẩm " + Integer.toString(this.id);
    }

    public SanPham(String name, String image, Double cost, int number, String location, String nsx, String description, Date date, LoaiSanPham type) {
        this.name = name;
        this.image = image;
        this.cost = cost;
        this.number = number;
        this.location = location;
        this.nsx = nsx;
        this.description = description;
        this.date = date;
        this.type = type;
    }

    public SanPham(int id, String name, String image, Double cost, int number, String location, String nsx, String description, Date date, LoaiSanPham type) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.cost = cost;
        this.number = number;
        this.location = location;
        this.nsx = nsx;
        this.description = description;
        this.date = date;
        this.type = type;
    }
}
