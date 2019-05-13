package com.miro.lenon.weather.service;

import com.miro.lenon.weather.vo.WeatherResponse;

/**
 * 天气服务接口
 */
public interface WeatherDataService {
    /**
     * 根据城市ID查询天气数据
     *
     * @param cityId
     * @return
     */
    WeatherResponse getDataByCityId(String cityId) throws  Exception;

    /**
     * 根据城市名称查询天气数据
     *
     * @param cityName
     * @return
     */
    WeatherResponse getDataByCityName(String cityName) throws  Exception;
}
