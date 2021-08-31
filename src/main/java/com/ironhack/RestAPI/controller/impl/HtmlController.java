package com.ironhack.RestAPI.controller.impl;

import com.ironhack.RestAPI.controller.interfaces.IHtmlController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlController implements IHtmlController {

    @RequestMapping("/")
    public String welcome() throws Exception {
        return "test.html"; //note that this says .html
    }

}
