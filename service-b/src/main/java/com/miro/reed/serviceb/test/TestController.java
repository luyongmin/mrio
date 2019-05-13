package com.miro.reed.serviceb.test;

import com.miro.reed.servicea.api.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: mrio
 * @author: lu.yongmin
 * @create: 2019-05-13 20:49
 * @description:
 **/
@RestController
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HelloService helloService;

    @HystrixCommand(fallbackMethod = "helloFallback")
    @RequestMapping("/index")
    public String index(){
        logger.info("index");
        return restTemplate.getForEntity("http://SERVICEA/index",String.class).getBody();
    }
    public String helloFallback(){
        return "error";
    }


    @HystrixCommand(fallbackMethod = "helloFallback")
    @RequestMapping("/hello")
    public String hello(){
        logger.info("hello");
        return helloService.index();
    }

}
