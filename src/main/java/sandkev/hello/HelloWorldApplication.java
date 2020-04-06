package sandkev.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


//@Controller
//@RestController
@SpringBootApplication
public class HelloWorldApplication {

/*
    @GetMapping("/fifa")
    public String index(Model model) {
        model.addAttribute("eventName", "FIFA 2018");
        return "fifa";
    }
*/
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
