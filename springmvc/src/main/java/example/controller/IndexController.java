package example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/home")
public class IndexController {
    @RequestMapping("/test")
    public String test() {
        return "test";
    }
}
