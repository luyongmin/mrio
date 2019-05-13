package com.miro.lenon.weather.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @program: mrio
 * @author: lu.yongmin
 * @create: 2019-05-13 22:54
 * @description:未来天气
 **/
@Getter
@Setter
@ToString
public class Forecast implements Serializable {
    private String date;
    private String high;
    private String fengli;
    private String low;
    private String fengxiang;
    private String type;
}
