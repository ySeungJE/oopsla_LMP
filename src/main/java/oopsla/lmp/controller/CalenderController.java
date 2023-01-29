package oopsla.lmp.controller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalenderController {

    @GetMapping("/calender")
    public String goCalender(){
        return "/full_calender/calender";
    }

}
