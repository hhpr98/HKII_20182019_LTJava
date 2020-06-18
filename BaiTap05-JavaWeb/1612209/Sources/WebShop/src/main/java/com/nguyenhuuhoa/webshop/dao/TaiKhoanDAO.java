/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nguyenhuuhoa.webshop.dao;

import com.nguyenhuuhoa.webshop.dto.TaiKhoan;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author nguyenhuuhoa
 */
public class TaiKhoanDAO {
    private EntityManager em;
    private EntityManagerFactory emf;
    public TaiKhoanDAO()
    {
        emf = Persistence.createEntityManagerFactory("WebShop");
        em = emf.createEntityManager();
    }
    public List<TaiKhoan> readAll()
    {
        em.clear();
        em.getTransaction().begin();
        List<TaiKhoan> result=em.createQuery("from TaiKhoan",TaiKhoan.class).getResultList();
        em.getTransaction().commit();
        return result;
    }
    
    public void create(TaiKhoan object)
    {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }
    
    public TaiKhoan read(int id)
    {
        return em.find(TaiKhoan.class,id);
    }
    
    public void update(TaiKhoan object)
    {
        TaiKhoan item = em.find(TaiKhoan.class,object.getId());
        em.getTransaction().begin();
        item.setName(object.getName());
        item.setUsername(object.getUsername());
        item.setPassword(object.getPassword());
        em.getTransaction().commit();
    }
    
    public void delete(int id)
    {
        TaiKhoan item = em.find(TaiKhoan.class, id);
        em.getTransaction().begin();
        em.remove(item);
        em.getTransaction().commit();
    }
}
