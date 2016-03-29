package org.belchan.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController implements org.springframework.boot.autoconfigure.web.ErrorController{

    @RequestMapping ("error")
    public ModelAndView error() {

        return new ModelAndView("error");
    }

    @Override
    public String getErrorPath() {
        return "null";
    }
}
