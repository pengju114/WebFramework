/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pj.admin.controller;

import com.pj.admin.beans.AdminUser;
import com.pj.admin.services.AdminService;
import com.pj.jdbc.core.ResultList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author luzhenwen
 */
@Controller
@RequestMapping(path = "/admin")
public class AdminOperation {
    
    @Autowired private AdminService adminService;
    
    @RequestMapping(path = "/listAdmins.do")
    public String findAdmin(
            @RequestParam(name = "adminName",defaultValue = "") String name, 
            @RequestParam(name = "pageNumber",defaultValue = "1") Integer page,
            @RequestParam(name = "pageSize",defaultValue = "100000000") Integer pageSize,
            ModelMap modelMap
            ){
        ResultList<AdminUser> admins = adminService.listAdmins(name, page, pageSize);
        modelMap.addAttribute("admins", admins);
        return "admin/fn/admins";
    }
}
