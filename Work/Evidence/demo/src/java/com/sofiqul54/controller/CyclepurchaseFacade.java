/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofiqul54.controller;

import com.sofiqul54.entity.Cyclepurchase;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author User
 */
@Stateless
public class CyclepurchaseFacade extends AbstractFacade<Cyclepurchase> {

    @PersistenceContext(unitName = "demoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CyclepurchaseFacade() {
        super(Cyclepurchase.class);
    }
    
}
