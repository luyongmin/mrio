package com.miro.reed.servicea.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: mrio
 * @author: lu.yongmin
 * @create: 2019-05-13 21:10
 * @description:
 **/
@FeignClient("SERVICEA")
public interface HelloService {

    @RequestMapping("/index")
    String index();

}
