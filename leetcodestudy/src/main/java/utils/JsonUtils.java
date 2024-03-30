package utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.Objects;

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


    public static String simpleToString(Object data){
        if(Objects.isNull(data)){
            return null;
        }
        return JSONObject.toJSONString(data, SerializerFeature.IgnoreNonFieldGetter);
    }


}
