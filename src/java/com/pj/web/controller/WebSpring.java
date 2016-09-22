/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pj.web.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author luzhenwen
 */
@Controller
@RequestMapping(path = "/web")
public class WebSpring {
    
    @RequestMapping(path = "index.do")
    public ModelAndView fuck(@RequestParam(name = "name",required = false) String name, HttpSession session){
        HashMap<String, Object> ret = new HashMap<>();
        ret.put("name", name);
        ret.put("age", 123);
        ModelAndView modelAndView = new ModelAndView("index", "ret", ret);
        session.setAttribute("shit", "session");
        return modelAndView;
    }
    
    @RequestMapping(path = "error.do")
    public String error() throws Exception{
        throw new Exception("fuck web");
//        return "";
    }
    
    @RequestMapping(path = "json.do")
    @ResponseBody
    public Object json(){
//        Map<String,String> map = new HashMap<>();
//        map.put("name", "pengju");
//        return map;
        User user = new User();
        user.setAge(34);
        user.setName("gfhghg");
        return user;
    }
    
    public class User{
        private String name;
        private int age;

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setName(String name) {
            this.name = name;
        }
        
        
        
    }
}
