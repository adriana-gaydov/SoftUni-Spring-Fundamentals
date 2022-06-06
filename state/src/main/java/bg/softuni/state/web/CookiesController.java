package bg.softuni.state.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/cookies")
public class CookiesController {

    private final String COOKIE_LANG_NAME = "lang";
    private final String COOKIE_LANG_DEFAULT = "en";

    @GetMapping("")
    public String cookies(Model model, @CookieValue(name = COOKIE_LANG_NAME, defaultValue = COOKIE_LANG_DEFAULT) String cookie) {

        model.addAttribute("currentLanguage", cookie);

        return "cookies";
    }

    @PostMapping("")
    public String cookies(HttpServletResponse response, @RequestParam(name = "lang") String lang) {

        Cookie cookie = new Cookie(COOKIE_LANG_NAME, lang);
        cookie.setMaxAge(3);
        response.addCookie(cookie);

        return "redirect:/cookies";
    }
}
