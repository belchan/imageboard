package org.belchan.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SinglePageController {

    @RequestMapping("/")
    public String main() {
        return "index.html";
    }

}
