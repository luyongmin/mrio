package com.miro.lenon.weather.controller;

import com.miro.lenon.weather.service.WeatherDataService;
import com.miro.lenon.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: mrio
 * @author: lu.yongmin
 * @create: 2019-05-13 23:06
 * @description:
 **/
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherDataService weatherDataService;

    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getWeatherByCityId(@PathVariable("cityId")String cityId)throws  Exception{
        return weatherDataService.getDataByCityId(cityId);
    }

    @GetMapping("/cityName/{cityName}")
    public WeatherResponse getWeatherByCityName(@PathVariable("cityName")String cityName)throws  Exception{
        return weatherDataService.getDataByCityName(cityName);
    }

}
