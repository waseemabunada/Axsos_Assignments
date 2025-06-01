//package com.example.axsos;
//
//import org.springframework.stereotype.Controller;
//
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import jakarta.servlet.http.HttpSession;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.*;
//
//@Controller
//public class NinjaGold {
//
//    Random rand = new Random();
//
//    @PostMapping("/process_money")
//    public String processMoney(@RequestParam("location") String location, HttpSession session) {
//
//        if (session.getAttribute("total_gold") == null) {
//            session.setAttribute("total_gold", 0);
//        }
//        if (session.getAttribute("activities") == null) {
//            session.setAttribute("activities", new ArrayList<Map<String, String>>());
//        }
//
//        int gold = 0;
//        String activityMsg = "";
//        String color = "green";
//
//        if (location.equals("Farm")) {
//            gold = rand.nextInt(11) + 10;
//            activityMsg = "You entered the Farm and earned " + gold + " gold.";
//        }
//
//        if (location.equals("Cave")) {
//            gold = rand.nextInt(11) + 5; 
//            activityMsg = "You entered the Cave and earned " + gold + " gold.";
//        }
//
//        if (location.equals("House")) {
//            gold = rand.nextInt(11) + 2; 
//            activityMsg = "You entered the House and earned " + gold + " gold.";
//        }
//
//        if (location.equals("Quest")) {
//            gold = rand.nextInt(101) - 50; 
//            if (gold >= 0) {
//                activityMsg = "You completed a Quest and earned " + gold + " gold.";
//            } else {
//                activityMsg = "You failed the Quest and lost " + Math.abs(gold) + " gold.";
//                color = "red";
//            }
//        }
//
//        int totalGold = (int) session.getAttribute("total_gold") + gold;
//        session.setAttribute("total_gold", totalGold);
//
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//        String timestamp = dtf.format(LocalDateTime.now());
//
//        Map<String, String> activity = new HashMap<>();
//        activity.put("text", activityMsg + " (" + timestamp + ")");
//        activity.put("color", color);
//
//        List<Map<String, String>> activities = (List<Map<String, String>>) session.getAttribute("activities");
//        activities.add(0, activity); 
//        session.setAttribute("activities", activities);
//
//        return "redirect:/";
//    }
//}
