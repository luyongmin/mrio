package com.miro.lenon.weather.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @program: mrio
 * @author: lu.yongmin
 * @create: 2019-05-13 22:52
 * @description:天气信息
 **/
@Getter
@Setter
@ToString
public class Weather implements Serializable {
    private String city;
    private String aqi;
    private String ganmao;
    private String wendu;
    private Yesterday yesterday;
    private List<Forecast> forecast;
}
