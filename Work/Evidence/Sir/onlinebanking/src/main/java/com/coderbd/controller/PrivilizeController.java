package com.coderbd.controller;

import com.coderbd.entity.Role;
import com.coderbd.repo.PrivilizeRepo;
import com.coderbd.repo.RoleRepo;
import com.coderbd.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/privilize/")
public class PrivilizeController {
    @Autowired
    private RoleService service;
    @Autowired
    PrivilizeRepo privilizeRepo;

    @Autowired
    private RoleRepo repo;

    @GetMapping(value = "create.jsf")
    public String displayRole(Model model) {
        model.addAttribute("obj", new Role());
        return "role/create";

    }

    @GetMapping(value = "list.jsf")
    public String getRoleList(Model model) {
        model.addAttribute("list", repo.findAll());
        return "role/list";
    }

    
}
