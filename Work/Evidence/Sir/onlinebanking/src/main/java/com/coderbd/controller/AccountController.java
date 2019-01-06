package com.coderbd.controller;

import com.coderbd.entity.Account;
import com.coderbd.entity.Nominee;
import com.coderbd.repo.AccountRepo;
import com.coderbd.repo.AccountTypeRepo;
import com.coderbd.repo.NomineeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/account/")
public class AccountController {
    @Autowired
    private AccountRepo repo;

    @Autowired
    private AccountTypeRepo accountTypeRepo;

    @Autowired
    private NomineeRepo nomineeRepo;

    @GetMapping(value = "create.jsf")
    public ModelAndView display() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("obj", new Account());
        modelAndView.addObject("accounttypelist", accountTypeRepo.findAll());
        modelAndView.addObject("nomnieelist", nomineeRepo.findAll());
        modelAndView.addObject("obj", new Account());
        modelAndView.setViewName("accounts/create");
        return modelAndView;
    }

    @PostMapping(value = "create.jsf")
    public ModelAndView save(@Valid Account obj, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        if (obj != null) {
            repo.save(obj);
            modelAndView.addObject("successMsg", "Save Success");
            modelAndView.addObject("obj", new Account());
            modelAndView.addObject("accounttypelist", accountTypeRepo.findAll());
            modelAndView.addObject("nomnieelist", nomineeRepo.findAll());
            modelAndView.setViewName("accounts/create");
        }
        modelAndView.setViewName("accounts/create");
        return modelAndView;
    }

    @GetMapping(value = "list.jsf")
    public ModelAndView getList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", repo.findAll());
        modelAndView.setViewName("accounts/list");
        return modelAndView;
    }

}
