package net.zuobin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sahinn
 * @date 16/6/8
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloWorld(){
        return  "Hello World!!!!";
    }
}
