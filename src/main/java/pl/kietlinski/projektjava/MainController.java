package pl.kietlinski.projektjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MainController {

    private MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
    public String get() {
        return "redirect:/app";
    }

    @GetMapping("/app")
    public String get(Model model) {
        model.addAttribute("dirtVisibility", mainService.getDirtVisibility());
        model.addAttribute("bowlFilling", mainService.getBowlFilling());
        model.addAttribute("feetVisibility", mainService.getFeetVisibility());
        model.addAttribute("dog", mainService.getDog());
        if(mainService.getDog().getLvlValue() >= 2){
            return "redirect:/end";
        }
        return "menu";
    }

    @PostMapping("/doFeed")
    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
    public String doFeed() {
        mainService.doFeed();
        return "redirect:/app";
    }

    @PostMapping("/doCleanUp")
    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
    public String doCleanUp() {
        mainService.doCleanUp();
        return "redirect:/app";
    }

    @PostMapping("/doWashDog")
    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
    public String doWashDog() {
        mainService.doWashDog();
        return "redirect:/app";
    }

    @RequestMapping("/reset")
    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
    public String reset() {
        mainService.reset();
        return "redirect:/app";
    }

    @GetMapping("/end")
    public String end() {
        return "endgame";
    }

    @GetMapping("/newGame")
    public String newGame() {
        mainService.reset();
        return "redirect:/app";
    }
}
