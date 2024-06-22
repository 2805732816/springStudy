package com.knowledge.basic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 基本类型：byte、short、int、float、long、double、char、boolean
 * 包装类：Byte、Short、Integer、Float、Long、Double、Character、Boolean
 * 引用类型：类（String）、数组、接口
 * 区别：非基本类型跟基本类型的本质区别，在于非基本型变量存储的不是值，而是引用。
 *
 */
@Data
//链式写法
@Accessors(chain = true)

@Builder
//@Data @Builder放在一起使用参数构造的时候会编译失败，所以得加上@AllArgsConstructor、@NoArgsConstructor
@AllArgsConstructor
@NoArgsConstructor

public class DataType {
    /**
     * 初始值为0
     */
    private int intA;
    /**
     * 初始值为null
     */
    private Integer IntegerA;

    /**
     * 初始值为0.0
     */
    private double aDouble;

    /**
     * 初始值为null
     */
    private Double aDDouble;

    /**
     * 初始值为0
     */
    private long longA;

    /**
     * 初始值为null
     */
    private Long lLongA;

    /**
     * 初始值为0.0
     */
    private float aFloat;
    /**
     * 初始值为null
     */
    private Float aFFloat;

    /**
     * 初始值为0
     */
    private short aShort;

    /**
     * 初始值为null
     */
    private Short aSShort;

    /**
     * 初始值为\u0000
     */
    private char aChar;

    /**
     * 初始值为null
     */
    private Character aCharacter;

    /**
     * 初始值为0
     */
    private byte aByte;
    /**
     * 初始值为null
     */
    private Byte aBByte;

    /**
     * 初始值为false
     */
    private boolean aBoolean;

    /**
     * B
     */
    private Boolean aBBoolean;

    private Long currentTime = System.currentTimeMillis();

    private Date data = new Date();


    /**
     * 序列化的时候不会被序列化
     */
    @JSONField(serialize = false)
    private String password="密码";


    @Override
    public String toString(){
        return JSON.toJSONString(JSON.toJSON(this));
    }






    //todo 写一个序列化的方法吧时间戳转成时间
    public static void main(String[] args) {
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //链式写法
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);

        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        fastJsonConfig.setSerializeConfig(SerializeConfig.globalInstance);


        DataType dataType = new DataType();
        dataType.setABoolean(false).setABBoolean(true);
        System.out.println(JSON.toJSONString(dataType,fastJsonConfig.getSerializerFeatures()));
        System.out.println(dataType);
        System.out.println(dataType.toString());
        //build写法
        DataType buildData = DataType.builder().aBBoolean(false).build();





    }
}

