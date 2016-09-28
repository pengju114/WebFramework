/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pj.admin.controller;

import com.pj.admin.beans.AdminUser;
import com.pj.admin.services.AdminService;
import com.pj.utilities.ImageUtility;
import com.pj.utilities.StringUtility;
import com.pj.web.res.Constans;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

/**
 *
 * @author luzhenwen
 */
@Controller
@RequestMapping(path = "/admin")
public class AdminLogin {

    @Autowired
    private AdminService adminService;

    @RequestMapping(path = "/login.do")
    public Object login(
            @RequestParam(name = "validationCode") String validationCode,
            @RequestParam(name = "userName") String userName,
            @RequestParam(name = "password") String pwd,
            HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        if (StringUtility.isEmpty(validationCode)) {
            request.setAttribute("error", "请输入验证码");
        } else if(StringUtility.isEmpty(userName)){
            request.setAttribute("error", "请输入用户名");
        } else if(StringUtility.isEmpty(pwd)){
            request.setAttribute("error", "请输入密码");
        } else {

            if (StringUtility.isEmpty(validationCode) || !StringUtility.ensureAsString(session.getAttribute(ImageUtility.RandomCodeImageRanderer.RANDOM_STRING)).equalsIgnoreCase(validationCode)) {
                request.setAttribute("error", "验证码错误");
            } else {
                AdminUser user = adminService.findAdminUserByNameAndPassword(userName, pwd);
                if (user != null) {
                    session.setAttribute(Constans.Key.CURRENT_ADMIN, user);
                    session.setAttribute("admin", user);
                    try {
                        //                    return new ModelAndView(new InternalResourceView("/admin/main.jsp"));
                        response.sendRedirect(request.getContextPath()+"/admin/main.jsp");
                    } catch (IOException ex) {
                        Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    return null;
                } else {
                    request.setAttribute("error", "用户名或密码错误");
                }
            }
        }

        return new ModelAndView(new InternalResourceView("/admin.jsp"));
    }
    
    @RequestMapping(path = "/logout.do")
    public void logout(HttpServletRequest request,HttpServletResponse response, HttpSession session) throws IOException{
        session.invalidate();
        response.sendRedirect(request.getContextPath()+"/admin.jsp");
    }
}
