package petstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import petstore.config.Config;

@Controller
public class SimpleRestController {

    @Autowired
    private Config config;

    @RequestMapping("/")
    public String foo() {
        return "hello, i am a petstore";
    }

    @GetMapping("/properties")
    public String show(@RequestParam(name="name", required=false, defaultValue="World") String name,Model model) {
        model.addAttribute("location", config.getLocation());
        return "propertiesInfo";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "propertiesInfo";
    }
}
