/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nguyenhuuhoa.webshop.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author nguyenhuuhoa
 */

@Entity
@Table(name = "loaisanphams")
public class LoaiSanPham implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "MaLoaiSP",nullable=false)
    private int id;
    
    @Column(name="TenLoaiSP",length=100)
    private String name;
    
    // getter

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    // setter

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    // constructor

    public LoaiSanPham() {
        this.name="Loại " + Integer.toString(this.id);
    }

    public LoaiSanPham(String name) {
        this.name = name;
    }

    public LoaiSanPham(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
