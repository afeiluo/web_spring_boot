package com.afeiluo.hello.controller;

import com.afeiluo.hello.model.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ModelController {


    @RequestMapping("/getDemo")
    public Model getDemo() {
        Model demo = new Model();
        demo.setId("1");
        demo.setAge(20);
        demo.setCity("chengdu");
        return demo;
    }

}
