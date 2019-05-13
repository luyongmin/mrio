package com.miro.lenon.weather.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miro.lenon.weather.service.WeatherDataService;
import com.miro.lenon.weather.vo.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.zip.GZIPInputStream;

/**
 * @program: mrio
 * @author: lu.yongmin
 * @create: 2019-05-13 22:59
 * @description:
 **/
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    private Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) throws  Exception{
        String uri = WEATHER_URI + "citykey=" + cityId;
        return this.doGetWeahter(uri);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) throws Exception{
        String uri = WEATHER_URI + "city=" + cityName;
        return this.doGetWeahter(uri);
    }

    private WeatherResponse doGetWeahter(String uri) throws Exception{
        ResponseEntity<byte[]> respString = restTemplate.getForEntity(uri, byte[].class);

        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse resp = null;
        String strBody = null;

        if (respString.getStatusCodeValue() == 200) {
            byte[] bytes = respString.getBody();
            bytes = uncompress(bytes);
            strBody = new String(bytes,"UTF-8");
        }

        try {
            resp = mapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resp;
    }

    public static String inputStream2String(InputStream in) {
        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(in, "GBK");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        BufferedReader br = new BufferedReader(reader);
        StringBuilder sb = new StringBuilder();
        String line = "";
        try {
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public  byte[] uncompress(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        try {
            GZIPInputStream ungzip = new GZIPInputStream(in);
            byte[] buffer = new byte[256];
            int n;
            while ((n = ungzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
        } catch (IOException e) {
            logger.error("gzip uncompress error.", e);
        }

        return out.toByteArray();

    }

}
