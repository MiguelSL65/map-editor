package org.academiadecodigo.rhashtafaris.tomcat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RhashtaController {

    @ModelAttribute("rasta")
    public Rhashtafari setUp() {
        return new Rhashtafari();
    }

    @GetMapping("/")
    public String form (Model model) {

        model.addAttribute("greeting", new Rhashtafari());
        return "homepage";
    }

    @PostMapping("/saveRasta")
    public String processingInfo(@ModelAttribute("rasta") Rhashtafari rasta, Model model) {

        System.out.println(rasta.getAge());
        System.out.println(rasta.getName());
        System.out.println(rasta.getPhoneNumber());

        model.addAttribute("message", new Rhashtafari());
        return "index";
    }
}
