package com.FSDCourse.MVCdemo.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class RestControllerClass {



    @Value("${States}")
    List<String> States;

    @RequestMapping("/showForm")
    public String hello(Model themodel ){

        Student  s =new Student();
        themodel.addAttribute("Student",s);
        themodel.addAttribute("States",States);

         return "form";
    }
    @RequestMapping("/confirm")
    public String Confirm(@ModelAttribute Student s , Model theModel){

        String FN = s.firstName;
        String LN =s.lastName;
        String dept=s.dept;

        String Name=FN+" "+LN;

        theModel.addAttribute( "StudentName", Name);


        String Message = "Welcome "+Name;
        theModel.addAttribute("s",s);

        theModel.addAttribute("Greeting",Message);


        return "Confirmation";
    }

}
