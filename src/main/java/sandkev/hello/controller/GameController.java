package sandkev.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {
    @GetMapping("/play")
    public String playGame(
            @RequestParam(name="choice", required=false)
                    String theChoice,
            Model model) {

        if (theChoice == null) {
            return "rock";
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
}
