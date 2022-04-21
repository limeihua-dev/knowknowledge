package com.amei.knowledge.controller;

import com.amei.knowledge.annotion.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessTypeAspect {

        @Log("#########做了一个测试#######3")
        @GetMapping("/hello")
        public String getLog(@RequestParam("name") String name){
            System.out.println("businessType is coming");
            return "annotion" + name;
        }


}
