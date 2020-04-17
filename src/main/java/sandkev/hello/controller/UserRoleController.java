package sandkev.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserRoleController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
