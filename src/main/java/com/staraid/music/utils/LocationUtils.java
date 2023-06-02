package com.staraid.music.utils;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 解析位置信息
 *
 * @author idroid
 * @date 2023-06-02 22:58:38
 */
@Service
public class LocationUtils {

    private static String MAP_URL;
    private static String MAP_KEY;

    @Value("${map.url}")
    public void setMapUrl(String mapUrl){
        MAP_URL = mapUrl;
    }

    @Value("${map.key}")
    public void setMapKey(String mapKey){
        MAP_KEY = mapKey;
    }


    /**
     * 根据详细地址获取经纬度信息
     * @param t 参数信息
     */
    public static <T> T fillLngLat(T t) {
        Map<String, Object> map = BeanUtil.beanToMap(t);

        if(map.containsKey("address") && StringUtils.isNoneBlank((String)map.get("address"))){
            RestTemplate restTemplate = new RestTemplate();
            String url = MAP_URL+"?address="+map.get("address").toString()+"&key="+MAP_KEY;
            JSONObject forObject = restTemplate.getForObject(url, JSONObject.class);
            if(forObject.getInteger("status") != 0){
                BeanUtil.copyProperties(map, t);
                return t;
            }

            JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(forObject.get("result")));
            JSONObject location = JSONObject.parseObject(JSONObject.toJSONString(result.get("location")));

            map.put("lng", new BigDecimal(location.getString("lng")));
            map.put("lat", new BigDecimal(location.getString("lat")));
        }

        BeanUtil.copyProperties(map, t);
        return t;
    }
}