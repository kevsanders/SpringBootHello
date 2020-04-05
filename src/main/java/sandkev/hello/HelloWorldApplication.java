package sandkev.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


//@Controller
//@RestController
@SpringBootApplication
public class HelloWorldApplication {

/*
    //@RequestMapping("/hello")
    @GetMapping("/hello")
    String helloWorld() {
        return "Hello World! @" + new Date();
    }

    @GetMapping("/play")
    public String playGame(
            @RequestParam(name="choice", required=false)
                    String theChoice,
            Model model) {

        if (theChoice == null) {
            return "index";
        }

        String theOutcome = "error";
        if (theChoice.equals("rock")) {
            theOutcome = "tie";
        }
        if (theChoice.equals("paper")) {
            theOutcome = "win";
        }
        if (theChoice.equals("scissors")) {
            theOutcome = "loss";
        }

        model.addAttribute("outcome", theOutcome);
        return "results";

    }
*/

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class, args);
    }
}
