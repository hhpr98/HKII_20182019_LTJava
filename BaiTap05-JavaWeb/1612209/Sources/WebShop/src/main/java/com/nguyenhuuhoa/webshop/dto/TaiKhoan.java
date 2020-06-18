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
@Table(name = "taikhoans")
public class TaiKhoan implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "MaTaiKhoan",nullable=false)
    private int id;
    
    @Column(name = "TenTaiKhoan",length=100)
    private String name;
    
    @Column(name = "TenDangNhap",length=100)
    private String username;
    
    @Column(name = "MatKhau",length=100)
    private String password;
    
    // getter

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    // setter

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    // constructor

    public TaiKhoan() {
        this.name = "Tài khoản " + Integer.toString(this.id);
    }

    public TaiKhoan(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public TaiKhoan(int id, String name, String username, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
    }
    
}
