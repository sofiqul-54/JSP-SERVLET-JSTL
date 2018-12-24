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
import com.sofiqul54.entity.Purchasesalessummary;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author User
 */
public class PurchasesalessummaryJpaController implements Serializable {

    public PurchasesalessummaryJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Purchasesalessummary purchasesalessummary) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Cyclepurchase PId = purchasesalessummary.getPId();
            if (PId != null) {
                PId = em.getReference(PId.getClass(), PId.getId());
                purchasesalessummary.setPId(PId);
            }
            em.persist(purchasesalessummary);
            if (PId != null) {
                PId.getPurchasesalessummaryCollection().add(purchasesalessummary);
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

    public void edit(Purchasesalessummary purchasesalessummary) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Purchasesalessummary persistentPurchasesalessummary = em.find(Purchasesalessummary.class, purchasesalessummary.getId());
            Cyclepurchase PIdOld = persistentPurchasesalessummary.getPId();
            Cyclepurchase PIdNew = purchasesalessummary.getPId();
            if (PIdNew != null) {
                PIdNew = em.getReference(PIdNew.getClass(), PIdNew.getId());
                purchasesalessummary.setPId(PIdNew);
            }
            purchasesalessummary = em.merge(purchasesalessummary);
            if (PIdOld != null && !PIdOld.equals(PIdNew)) {
                PIdOld.getPurchasesalessummaryCollection().remove(purchasesalessummary);
                PIdOld = em.merge(PIdOld);
            }
            if (PIdNew != null && !PIdNew.equals(PIdOld)) {
                PIdNew.getPurchasesalessummaryCollection().add(purchasesalessummary);
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
                Integer id = purchasesalessummary.getId();
                if (findPurchasesalessummary(id) == null) {
                    throw new NonexistentEntityException("The purchasesalessummary with id " + id + " no longer exists.");
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
            Purchasesalessummary purchasesalessummary;
            try {
                purchasesalessummary = em.getReference(Purchasesalessummary.class, id);
                purchasesalessummary.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The purchasesalessummary with id " + id + " no longer exists.", enfe);
            }
            Cyclepurchase PId = purchasesalessummary.getPId();
            if (PId != null) {
                PId.getPurchasesalessummaryCollection().remove(purchasesalessummary);
                PId = em.merge(PId);
            }
            em.remove(purchasesalessummary);
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

    public List<Purchasesalessummary> findPurchasesalessummaryEntities() {
        return findPurchasesalessummaryEntities(true, -1, -1);
    }

    public List<Purchasesalessummary> findPurchasesalessummaryEntities(int maxResults, int firstResult) {
        return findPurchasesalessummaryEntities(false, maxResults, firstResult);
    }

    private List<Purchasesalessummary> findPurchasesalessummaryEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Purchasesalessummary.class));
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

    public Purchasesalessummary findPurchasesalessummary(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Purchasesalessummary.class, id);
        } finally {
            em.close();
        }
    }

    public int getPurchasesalessummaryCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Purchasesalessummary> rt = cq.from(Purchasesalessummary.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
