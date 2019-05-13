package com.miro.reed.servicea.controller.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: mrio
 * @author: lu.yongmin
 * @create: 2019-05-13 20:27
 * @description:
 **/
@RestController
public class TestController {


    private final Logger logger = LoggerFactory.getLogger(TestController.class);
    @RequestMapping("index")
    public String index(){
        logger.info("index");
        return "index";
    }

}
