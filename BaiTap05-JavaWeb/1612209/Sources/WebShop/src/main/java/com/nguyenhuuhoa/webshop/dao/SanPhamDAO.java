/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nguyenhuuhoa.webshop.dao;

import com.nguyenhuuhoa.webshop.dto.SanPham;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author nguyenhuuhoa
 */
public class SanPhamDAO {
    private EntityManager em;
    private EntityManagerFactory emf;
    public SanPhamDAO()
    {
        emf = Persistence.createEntityManagerFactory("WebShop");
        em = emf.createEntityManager();
    }
    public List<SanPham> readAll()
    {
        em.clear();
        em.getTransaction().begin();
        List<SanPham> result=em.createQuery("from SanPham",SanPham.class).getResultList();
        em.getTransaction().commit();
        return result;
    }
    
    public void create(SanPham object)
    {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }
    
    public SanPham read(int id)
    {
        return em.find(SanPham.class,id);
    }
    
    public void update(SanPham object)
    {
        SanPham item = em.find(SanPham.class,object.getId());
        em.getTransaction().begin();
        item.setName(object.getName());
        item.setImage(object.getImage());
        item.setCost(object.getCost());
        item.setNumber(object.getNumber());
        item.setLocation(object.getLocation());
        item.setNsx(object.getNsx());
        item.setDescription(object.getDescription());
        item.setDate(object.getDate());
        item.setType(object.getType());
        em.getTransaction().commit();
    }
    
    public void delete(int id)
    {
        SanPham item = em.find(SanPham.class, id);
        em.getTransaction().begin();
        em.remove(item);
        em.getTransaction().commit();
    }
}
