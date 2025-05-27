package com.example.axsos;

import javax.servlet.http.HttpSession;  
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class CounterController {

    @GetMapping("/")
    public String index(HttpSession session) {
        Integer count = (Integer) session.getAttribute("count");
        if (count == null) {
            count = 0;
        }
        session.setAttribute("count", count + 1);
        return "index.jsp";
    }

    @GetMapping("/counter")
    public String counter(HttpSession session, Model model) {
        Integer count = (Integer) session.getAttribute("count");
        if (count == null) {
            count = 0;
        }
        model.addAttribute("count", count);
        return "counter.jsp";
    }
    
    @GetMapping("/increment")
    public String increment(HttpSession session, Model model) {
        Integer count = (Integer) session.getAttribute("count");
        if (count == null) {
            count = 0;
        }

        session.setAttribute("count", count + 2);
        return "increment.jsp";
    }

  

}
