package pl.kietlinski.projektjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Controller
@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MainController {

    private Dog dog;

    @Autowired
    public MainController() {
        dog = new Dog();
    }

    @GetMapping("/app")
    public ModelAndView get(Model model) {
        return new ModelAndView("menu", "dog", dog);
    }

    @PostMapping("/upExpValue")
    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
    public String upExpValue() {
        dog.upExpValue();
        return "redirect:/app";
    }

    @PostMapping("/doCleanUp")
    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
    public String doCleanUp() {
        dog.doCleanUp();
        return "redirect:/app";
    }

    @PostMapping("/doWashDog")
    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
    public String doWashDog() {
        dog.doWashDog();
        return "redirect:/app";
    }

    @PostMapping("/reset")
    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
    public String reset() {
        dog = new Dog();
        return "redirect:/app";
    }

    public String washDogTime() {
        dog.washDogTime();
        return "redirect:/app";
    }
}
