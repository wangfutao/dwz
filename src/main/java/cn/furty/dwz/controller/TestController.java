package cn.furty.dwz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/dwz")
    public String t(){
        return "ttt";
    }

    @RequestMapping("/test")
    public String test(){
        return "dwz";
    }
}
