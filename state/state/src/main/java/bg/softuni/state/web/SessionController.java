package bg.softuni.state.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/session")
public class SessionController {

    private final String SESSION_LANG = "lang";
    private final String SESSION_DEFAULT_LANG = "en";

    @GetMapping("")
    public String session(HttpSession session, Model model) {

        var langAttribute = session.getAttribute(SESSION_LANG);
        System.out.println("attrib "  + langAttribute);

        model.addAttribute("currentLanguage",
                langAttribute == null ?
                SESSION_DEFAULT_LANG :
                langAttribute);

        return "session";
    }

    @PostMapping("")
    public String session(HttpSession session, @RequestParam(name = "lang") String lang) {

        System.out.println(lang);
        session.setAttribute(SESSION_LANG, lang);

        return "redirect:/session";
    }
}
