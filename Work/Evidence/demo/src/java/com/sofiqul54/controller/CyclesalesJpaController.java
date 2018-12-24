/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofiqul54.controller;

import com.sofiqul54.controller.exceptions.NonexistentEntityException;
import com.sofiqul54.controller.exceptions.RollbackFailureException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.sofiqul54.entity.Cyclepurchase;
import com.sofiqul54.entity.Cyclesales;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author User
 */
public class CyclesalesJpaController implements Serializable {

    public CyclesalesJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cyclesales cyclesales) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Cyclepurchase PId = cyclesales.getPId();
            if (PId != null) {
                PId = em.getReference(PId.getClass(), PId.getId());
                cyclesales.setPId(PId);
            }
            em.persist(cyclesales);
            if (PId != null) {
                PId.getCyclesalesCollection().add(cyclesales);
                PId = em.merge(PId);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cyclesales cyclesales) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Cyclesales persistentCyclesales = em.find(Cyclesales.class, cyclesales.getId());
            Cyclepurchase PIdOld = persistentCyclesales.getPId();
            Cyclepurchase PIdNew = cyclesales.getPId();
            if (PIdNew != null) {
                PIdNew = em.getReference(PIdNew.getClass(), PIdNew.getId());
                cyclesales.setPId(PIdNew);
            }
            cyclesales = em.merge(cyclesales);
            if (PIdOld != null && !PIdOld.equals(PIdNew)) {
                PIdOld.getCyclesalesCollection().remove(cyclesales);
                PIdOld = em.merge(PIdOld);
            }
            if (PIdNew != null && !PIdNew.equals(PIdOld)) {
                PIdNew.getCyclesalesCollection().add(cyclesales);
                PIdNew = em.merge(PIdNew);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cyclesales.getId();
                if (findCyclesales(id) == null) {
                    throw new NonexistentEntityException("The cyclesales with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Cyclesales cyclesales;
            try {
                cyclesales = em.getReference(Cyclesales.class, id);
                cyclesales.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cyclesales with id " + id + " no longer exists.", enfe);
            }
            Cyclepurchase PId = cyclesales.getPId();
            if (PId != null) {
                PId.getCyclesalesCollection().remove(cyclesales);
                PId = em.merge(PId);
            }
            em.remove(cyclesales);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cyclesales> findCyclesalesEntities() {
        return findCyclesalesEntities(true, -1, -1);
    }

    public List<Cyclesales> findCyclesalesEntities(int maxResults, int firstResult) {
        return findCyclesalesEntities(false, maxResults, firstResult);
    }

    private List<Cyclesales> findCyclesalesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cyclesales.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Cyclesales findCyclesales(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cyclesales.class, id);
        } finally {
            em.close();
        }
    }

    public int getCyclesalesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cyclesales> rt = cq.from(Cyclesales.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
