package com.example.axsos;
import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model; 


@Controller
public class DisplayDate {

    @RequestMapping("/")
    public String index() {
        return "TimeDashboard.jsp";
    }
    
    
    @RequestMapping("/date")
    public String index2(Model model) {
    	model.addAttribute("now", new java.util.Date());
        return "data.jsp";
    }
    
    
    @RequestMapping("/time")
    public String index3(Model model) {
    	model.addAttribute("now", new java.util.Date());
        return "time.jsp";
    }
    
    
    
}