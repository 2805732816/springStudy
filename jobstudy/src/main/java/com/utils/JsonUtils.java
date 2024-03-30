package com.utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import java.util.Objects;


@Slf4j
public class JsonUtils {
    /**
     * 包含非空字段
     */
    private static final ObjectMapper OBJECT_MAPPER_INCLUDE_NULL;

    /**
     * 排除非空字段
     */
    private static final ObjectMapper OBJECT_MAPPER_EXCLUDE_NULL;

    static {
        OBJECT_MAPPER_INCLUDE_NULL = new ObjectMapper();
    }

    static {
        OBJECT_MAPPER_EXCLUDE_NULL = new ObjectMapper();
    }


    /**
     * 序列化
     * @param data
     * @return
     */
    public static String transferObjectToString(Object data){
        if(Objects.isNull(data)){
            return null;
        }
        return JSONObject.toJSONString(data, SerializerFeature.IgnoreNonFieldGetter);
    }

    public static <T> T transferStringToClass(String data, Class<T> targetClass){
        try {
            return OBJECT_MAPPER_INCLUDE_NULL.readValue(data,targetClass);
        }catch (Exception e){
            return null;
        }

    }


}
