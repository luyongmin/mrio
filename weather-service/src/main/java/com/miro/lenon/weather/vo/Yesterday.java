package com.miro.lenon.weather.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @program: mrio
 * @author: lu.yongmin
 * @create: 2019-05-13 22:55
 * @description:昨天天气
 **/
@Getter
@Setter
@ToString
public class Yesterday implements Serializable {
    private String date;
    private String high;
    private String fx;
    private String low;
    private String fl;
    private String type;
}
