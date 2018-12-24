/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofiqul54.controller;

import com.sofiqul54.entity.Cyclesales;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author User
 */
@Stateless
public class CyclesalesFacade extends AbstractFacade<Cyclesales> {

    @PersistenceContext(unitName = "demoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CyclesalesFacade() {
        super(Cyclesales.class);
    }
    
}
