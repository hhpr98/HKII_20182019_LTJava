package com.nguyenhuuhoa.webshop.dao;


import com.nguyenhuuhoa.webshop.dto.LoaiSanPham;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nguyenhuuhoa
 */
public class LoaiSanPhamDAO {
    private EntityManager em;
    private EntityManagerFactory emf;
    public LoaiSanPhamDAO()
    {
        emf = Persistence.createEntityManagerFactory("WebShop");
        em = emf.createEntityManager();
    }
    public List<LoaiSanPham> readAll()
    {
        em.clear();
        em.getTransaction().begin();
        List<LoaiSanPham> result=em.createQuery("from LoaiSanPham",LoaiSanPham.class).getResultList();
        em.getTransaction().commit();
        return result;
    }
    
    public void create(LoaiSanPham object)
    {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }
    
    public LoaiSanPham read(int id)
    {
        return em.find(LoaiSanPham.class,id);
    }
    
    public void update(LoaiSanPham object)
    {
        LoaiSanPham item = em.find(LoaiSanPham.class,object.getId());
        em.getTransaction().begin();
        item.setName(object.getName());
        em.getTransaction().commit();
    }
    
    public void delete(int id)
    {
        LoaiSanPham item = em.find(LoaiSanPham.class, id);
        em.getTransaction().begin();
        em.remove(item);
        em.getTransaction().commit();
    }
}
