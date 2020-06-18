/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam.qlphongban.dao;

import com.sam.qlphongban.dto.Project;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author nguyenhuuhoa
 */
public class ProjectDAO {
    private EntityManager em;
    private EntityManagerFactory emf;
    public ProjectDAO()
    {
        emf = Persistence.createEntityManagerFactory("QLPhongBanService");
        em = emf.createEntityManager();
    }
    public List<Project> readAll()
    {
        em.clear();
        em.getTransaction().begin();
        List<Project> result=em.createQuery("from Project",Project.class).getResultList();
        em.getTransaction().commit();
        return result;
    }
    
    public void create(Project object)
    {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }
    
    public Project read(int id)
    {
        return em.find(Project.class,id);
    }
    
    public void update(Project object)
    {
        Project curr = em.find(Project.class,object.getId());
        em.getTransaction().begin();
        curr.setName(object.getName());
        curr.setLocation(object.getLocation());
        curr.setNumberOfEmp(object.getNumberOfEmp());
        curr.setCost(object.getCost());
        curr.setDayStart(object.getDayStart());
        curr.setDayEnd(object.getDayEnd());
        em.getTransaction().commit();
    }
    
    public void delete(int id)
    {
        Project curr = em.find(Project.class, id);
        em.getTransaction().begin();
        em.remove(curr);
        em.getTransaction().commit();
    }
}
