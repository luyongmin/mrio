package com.miro.lenon.weather.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @program: mrio
 * @author: lu.yongmin
 * @create: 2019-05-13 22:56
 * @description:
 **/
@Getter
@Setter
@ToString
public class WeatherResponse implements Serializable {
    private Weather data;
    private Integer status;
    private String desc;
}
