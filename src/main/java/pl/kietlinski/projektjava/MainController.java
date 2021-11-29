package pl.kietlinski.projektjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MainController {

    private Dog dog;

    @Autowired
    public MainController() {
        dog = new Dog();
    }

    @GetMapping("/app")
    public String get(Model model) {
        model.addAttribute("lvlValue", dog.getLvlValue());
        model.addAttribute("expValue", dog.getExpValue());
        return "menu";
    }

    @PostMapping("/upExpValue")
    public String upExpValue() {
        dog.upExpValue();
        return "redirect:/app";
    }

    @PostMapping("/reset")
    public String reset() {
        dog.reset();
        return "redirect:/app";
    }
}
