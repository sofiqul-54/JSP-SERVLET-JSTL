/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofiqul54.controller;

import com.sofiqul54.controller.exceptions.NonexistentEntityException;
import com.sofiqul54.controller.exceptions.RollbackFailureException;
import com.sofiqul54.entity.Cyclepurchase;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.sofiqul54.entity.Purchasesalessummary;
import java.util.ArrayList;
import java.util.Collection;
import com.sofiqul54.entity.Cyclesales;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author User
 */
public class CyclepurchaseJpaController implements Serializable {

    public CyclepurchaseJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cyclepurchase cyclepurchase) throws RollbackFailureException, Exception {
        if (cyclepurchase.getPurchasesalessummaryCollection() == null) {
            cyclepurchase.setPurchasesalessummaryCollection(new ArrayList<Purchasesalessummary>());
        }
        if (cyclepurchase.getCyclesalesCollection() == null) {
            cyclepurchase.setCyclesalesCollection(new ArrayList<Cyclesales>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Collection<Purchasesalessummary> attachedPurchasesalessummaryCollection = new ArrayList<Purchasesalessummary>();
            for (Purchasesalessummary purchasesalessummaryCollectionPurchasesalessummaryToAttach : cyclepurchase.getPurchasesalessummaryCollection()) {
                purchasesalessummaryCollectionPurchasesalessummaryToAttach = em.getReference(purchasesalessummaryCollectionPurchasesalessummaryToAttach.getClass(), purchasesalessummaryCollectionPurchasesalessummaryToAttach.getId());
                attachedPurchasesalessummaryCollection.add(purchasesalessummaryCollectionPurchasesalessummaryToAttach);
            }
            cyclepurchase.setPurchasesalessummaryCollection(attachedPurchasesalessummaryCollection);
            Collection<Cyclesales> attachedCyclesalesCollection = new ArrayList<Cyclesales>();
            for (Cyclesales cyclesalesCollectionCyclesalesToAttach : cyclepurchase.getCyclesalesCollection()) {
                cyclesalesCollectionCyclesalesToAttach = em.getReference(cyclesalesCollectionCyclesalesToAttach.getClass(), cyclesalesCollectionCyclesalesToAttach.getId());
                attachedCyclesalesCollection.add(cyclesalesCollectionCyclesalesToAttach);
            }
            cyclepurchase.setCyclesalesCollection(attachedCyclesalesCollection);
            em.persist(cyclepurchase);
            for (Purchasesalessummary purchasesalessummaryCollectionPurchasesalessummary : cyclepurchase.getPurchasesalessummaryCollection()) {
                Cyclepurchase oldPIdOfPurchasesalessummaryCollectionPurchasesalessummary = purchasesalessummaryCollectionPurchasesalessummary.getPId();
                purchasesalessummaryCollectionPurchasesalessummary.setPId(cyclepurchase);
                purchasesalessummaryCollectionPurchasesalessummary = em.merge(purchasesalessummaryCollectionPurchasesalessummary);
                if (oldPIdOfPurchasesalessummaryCollectionPurchasesalessummary != null) {
                    oldPIdOfPurchasesalessummaryCollectionPurchasesalessummary.getPurchasesalessummaryCollection().remove(purchasesalessummaryCollectionPurchasesalessummary);
                    oldPIdOfPurchasesalessummaryCollectionPurchasesalessummary = em.merge(oldPIdOfPurchasesalessummaryCollectionPurchasesalessummary);
                }
            }
            for (Cyclesales cyclesalesCollectionCyclesales : cyclepurchase.getCyclesalesCollection()) {
                Cyclepurchase oldPIdOfCyclesalesCollectionCyclesales = cyclesalesCollectionCyclesales.getPId();
                cyclesalesCollectionCyclesales.setPId(cyclepurchase);
                cyclesalesCollectionCyclesales = em.merge(cyclesalesCollectionCyclesales);
                if (oldPIdOfCyclesalesCollectionCyclesales != null) {
                    oldPIdOfCyclesalesCollectionCyclesales.getCyclesalesCollection().remove(cyclesalesCollectionCyclesales);
                    oldPIdOfCyclesalesCollectionCyclesales = em.merge(oldPIdOfCyclesalesCollectionCyclesales);
                }
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

    public void edit(Cyclepurchase cyclepurchase) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Cyclepurchase persistentCyclepurchase = em.find(Cyclepurchase.class, cyclepurchase.getId());
            Collection<Purchasesalessummary> purchasesalessummaryCollectionOld = persistentCyclepurchase.getPurchasesalessummaryCollection();
            Collection<Purchasesalessummary> purchasesalessummaryCollectionNew = cyclepurchase.getPurchasesalessummaryCollection();
            Collection<Cyclesales> cyclesalesCollectionOld = persistentCyclepurchase.getCyclesalesCollection();
            Collection<Cyclesales> cyclesalesCollectionNew = cyclepurchase.getCyclesalesCollection();
            Collection<Purchasesalessummary> attachedPurchasesalessummaryCollectionNew = new ArrayList<Purchasesalessummary>();
            for (Purchasesalessummary purchasesalessummaryCollectionNewPurchasesalessummaryToAttach : purchasesalessummaryCollectionNew) {
                purchasesalessummaryCollectionNewPurchasesalessummaryToAttach = em.getReference(purchasesalessummaryCollectionNewPurchasesalessummaryToAttach.getClass(), purchasesalessummaryCollectionNewPurchasesalessummaryToAttach.getId());
                attachedPurchasesalessummaryCollectionNew.add(purchasesalessummaryCollectionNewPurchasesalessummaryToAttach);
            }
            purchasesalessummaryCollectionNew = attachedPurchasesalessummaryCollectionNew;
            cyclepurchase.setPurchasesalessummaryCollection(purchasesalessummaryCollectionNew);
            Collection<Cyclesales> attachedCyclesalesCollectionNew = new ArrayList<Cyclesales>();
            for (Cyclesales cyclesalesCollectionNewCyclesalesToAttach : cyclesalesCollectionNew) {
                cyclesalesCollectionNewCyclesalesToAttach = em.getReference(cyclesalesCollectionNewCyclesalesToAttach.getClass(), cyclesalesCollectionNewCyclesalesToAttach.getId());
                attachedCyclesalesCollectionNew.add(cyclesalesCollectionNewCyclesalesToAttach);
            }
            cyclesalesCollectionNew = attachedCyclesalesCollectionNew;
            cyclepurchase.setCyclesalesCollection(cyclesalesCollectionNew);
            cyclepurchase = em.merge(cyclepurchase);
            for (Purchasesalessummary purchasesalessummaryCollectionOldPurchasesalessummary : purchasesalessummaryCollectionOld) {
                if (!purchasesalessummaryCollectionNew.contains(purchasesalessummaryCollectionOldPurchasesalessummary)) {
                    purchasesalessummaryCollectionOldPurchasesalessummary.setPId(null);
                    purchasesalessummaryCollectionOldPurchasesalessummary = em.merge(purchasesalessummaryCollectionOldPurchasesalessummary);
                }
            }
            for (Purchasesalessummary purchasesalessummaryCollectionNewPurchasesalessummary : purchasesalessummaryCollectionNew) {
                if (!purchasesalessummaryCollectionOld.contains(purchasesalessummaryCollectionNewPurchasesalessummary)) {
                    Cyclepurchase oldPIdOfPurchasesalessummaryCollectionNewPurchasesalessummary = purchasesalessummaryCollectionNewPurchasesalessummary.getPId();
                    purchasesalessummaryCollectionNewPurchasesalessummary.setPId(cyclepurchase);
                    purchasesalessummaryCollectionNewPurchasesalessummary = em.merge(purchasesalessummaryCollectionNewPurchasesalessummary);
                    if (oldPIdOfPurchasesalessummaryCollectionNewPurchasesalessummary != null && !oldPIdOfPurchasesalessummaryCollectionNewPurchasesalessummary.equals(cyclepurchase)) {
                        oldPIdOfPurchasesalessummaryCollectionNewPurchasesalessummary.getPurchasesalessummaryCollection().remove(purchasesalessummaryCollectionNewPurchasesalessummary);
                        oldPIdOfPurchasesalessummaryCollectionNewPurchasesalessummary = em.merge(oldPIdOfPurchasesalessummaryCollectionNewPurchasesalessummary);
                    }
                }
            }
            for (Cyclesales cyclesalesCollectionOldCyclesales : cyclesalesCollectionOld) {
                if (!cyclesalesCollectionNew.contains(cyclesalesCollectionOldCyclesales)) {
                    cyclesalesCollectionOldCyclesales.setPId(null);
                    cyclesalesCollectionOldCyclesales = em.merge(cyclesalesCollectionOldCyclesales);
                }
            }
            for (Cyclesales cyclesalesCollectionNewCyclesales : cyclesalesCollectionNew) {
                if (!cyclesalesCollectionOld.contains(cyclesalesCollectionNewCyclesales)) {
                    Cyclepurchase oldPIdOfCyclesalesCollectionNewCyclesales = cyclesalesCollectionNewCyclesales.getPId();
                    cyclesalesCollectionNewCyclesales.setPId(cyclepurchase);
                    cyclesalesCollectionNewCyclesales = em.merge(cyclesalesCollectionNewCyclesales);
                    if (oldPIdOfCyclesalesCollectionNewCyclesales != null && !oldPIdOfCyclesalesCollectionNewCyclesales.equals(cyclepurchase)) {
                        oldPIdOfCyclesalesCollectionNewCyclesales.getCyclesalesCollection().remove(cyclesalesCollectionNewCyclesales);
                        oldPIdOfCyclesalesCollectionNewCyclesales = em.merge(oldPIdOfCyclesalesCollectionNewCyclesales);
                    }
                }
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
                Integer id = cyclepurchase.getId();
                if (findCyclepurchase(id) == null) {
                    throw new NonexistentEntityException("The cyclepurchase with id " + id + " no longer exists.");
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
            Cyclepurchase cyclepurchase;
            try {
                cyclepurchase = em.getReference(Cyclepurchase.class, id);
                cyclepurchase.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cyclepurchase with id " + id + " no longer exists.", enfe);
            }
            Collection<Purchasesalessummary> purchasesalessummaryCollection = cyclepurchase.getPurchasesalessummaryCollection();
            for (Purchasesalessummary purchasesalessummaryCollectionPurchasesalessummary : purchasesalessummaryCollection) {
                purchasesalessummaryCollectionPurchasesalessummary.setPId(null);
                purchasesalessummaryCollectionPurchasesalessummary = em.merge(purchasesalessummaryCollectionPurchasesalessummary);
            }
            Collection<Cyclesales> cyclesalesCollection = cyclepurchase.getCyclesalesCollection();
            for (Cyclesales cyclesalesCollectionCyclesales : cyclesalesCollection) {
                cyclesalesCollectionCyclesales.setPId(null);
                cyclesalesCollectionCyclesales = em.merge(cyclesalesCollectionCyclesales);
            }
            em.remove(cyclepurchase);
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

    public List<Cyclepurchase> findCyclepurchaseEntities() {
        return findCyclepurchaseEntities(true, -1, -1);
    }

    public List<Cyclepurchase> findCyclepurchaseEntities(int maxResults, int firstResult) {
        return findCyclepurchaseEntities(false, maxResults, firstResult);
    }

    private List<Cyclepurchase> findCyclepurchaseEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cyclepurchase.class));
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

    public Cyclepurchase findCyclepurchase(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cyclepurchase.class, id);
        } finally {
            em.close();
        }
    }

    public int getCyclepurchaseCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cyclepurchase> rt = cq.from(Cyclepurchase.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
