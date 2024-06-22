package com.knowledge.basic;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.util.Streams;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * 记录java8的常用写法
 */
@Slf4j
public class ScreamJava {
    public List<String> strList = Arrays.asList("aaa","aaa","bbbb","cccccccc");
    public List<Integer> integerList = Arrays.asList(1,2,3,3,3,99,100);
    public List<Person> personList = Arrays.asList(new Person(24,"cxx",Arrays.asList("篮球"))
            ,new Person(27,"ycx",Arrays.asList("游泳")));

    @Test
    public void streamTest(){
        System.out.println("串行输出");
        integerList.stream().forEach(System.out::println);
        System.out.println("并行输出");
        integerList.parallelStream().forEach(System.out::println);
    }

    @Test
    public void forEachTest(){
        log.info("foreach前，integerList={}",JSON.toJSONString(integerList));
        integerList.parallelStream().forEach(num->{
            num++;
        });
        log.info("foreach后，integerList={}",JSON.toJSONString(integerList));

    }

    @Test
    public void mapTest(){
        //数组是基本数据类型时map不会改变
        log.info("\nmap前：integerList={}",JSON.toJSONString(integerList));
        List<Integer> newIntegerList = integerList.parallelStream().map(integer-> integer+3).collect(Collectors.toList());
        log.info("\nmap后：integerList={}",JSON.toJSONString(integerList));
        log.info("\nmap后：newIntegerList={}",JSON.toJSONString(newIntegerList));

        log.info("\nmap前：strList={}",JSON.toJSONString(strList));
        List<String> newStrList = strList.parallelStream().map(String::toUpperCase).collect(Collectors.toList());
        log.info("\nmap后：strList={}",JSON.toJSONString(strList));
        log.info("\nmap后：newStrList={}",JSON.toJSONString(newStrList));


        //如果是数组则会改变对象数组的对象
        log.info("\nmap前，personList={}",JSON.toJSONString(personList));
        personList.parallelStream().map(person->person.setAge(10)).collect(Collectors.toList());
        log.info("\nmap后，personList={}",JSON.toJSONString(personList));
    }



    @Test
    public void maxTest(){
        String maxLengthStr = strList.parallelStream().max(Comparator.comparing(String::length)).orElse(null);
        Integer integerMax = integerList.parallelStream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        }).orElse(null);
        log.info("\nintegerList的最大值为：{}",integerMax.toString());
        log.info("\nstrList的最长字段为：{}",maxLengthStr);
    }
    @Test
    public void countTest(){
        long count = integerList.parallelStream().filter(num -> num > 1).count();
        List<Integer> collect = integerList.parallelStream().filter(num -> num > 1).collect(Collectors.toList());
        log.info("\nintegerList中大于1的个数为：{}",count);
        log.info("\nintegerList中大于1的数字为为：{}",JSON.toJSONString(collect));
    }


    @Test
    public void findFirstTest(){
        log.info(String.valueOf(integerList.stream().parallel().filter(x->x>=10).findFirst().orElse(null)));
        log.info(String.valueOf(integerList.stream().parallel().filter(x->x>=10).findAny().orElse(null)));
    }


    public void concatTest(){

    }

    @Test
    public void flatMapTest(){
        //flatMap要求返回的是流
        log.info("\nmap前，personList={}",JSON.toJSONString(personList));
        List<String> hobbies = personList.parallelStream()
                .flatMap(person -> person.getHobbies().stream()).collect(Collectors.toList());
        log.info("\nmap后，personList={}",JSON.toJSONString(personList));
        log.info("hobbies={}",JSON.toJSONString(hobbies));
    }


    @Test
    public void reduceTest(){
        //规约
        //求乘积
        Integer integer = integerList.stream().reduce((x, y) -> x * y).orElse(0);
        //求和
        Integer integerSum = integerList.stream().reduce((x, y) -> x + y).orElse(0);
        Integer integerMax = integerList.stream().reduce((x, y) -> x > y?x:y).orElse(0);
        log.info("乘积为：{}",integer);
        log.info("和为：{}",integerSum);
        log.info("最大值为：{}",integerMax);
    }

    @Test
    public void collectTest(){
        Set<Integer> collect = integerList.parallelStream().collect(Collectors.toSet());
        Set<String> collect2 = strList.parallelStream().collect(Collectors.toSet());
        String collect1 = strList.parallelStream().collect(Collectors.joining("_"));
        String collect3 = integerList.parallelStream().map(e -> String.valueOf(e)).collect(Collectors.joining("_"));
        log.info("\n去重整数数组为：{}\n去重字符串数组为：{}\n连接字符串数组为；{}\n连接的整数数组为：{}"
        ,collect,collect2,collect1,collect3);

        Long collect4 = integerList.parallelStream().collect(Collectors.counting());
        Double collect5 = personList.parallelStream().collect(Collectors.averagingDouble(Person::getAge));
        Map<Integer, List<Person>> collect6 = personList.parallelStream().collect(Collectors.groupingBy(Person::getAge));
        Map<Boolean, List<Person>> collect7 = personList.parallelStream().collect(Collectors.partitioningBy(person -> person.getAge() > 10));

        log.info("\ncount函数：{}\naveragingDouble为：{}\ngroupingBy结果为：{}\npartitioningBy函数结果为：{}"
        ,collect4,collect5,JSON.toJSONString(collect6),JSON.toJSONString(collect7));

    }


    @Test
    public void sortTest(){
        List<String> collect = personList.stream().sorted(Comparator.comparing(Person::getAge))
                .map(Person::getName).collect(Collectors.toList());
        List<Integer> collect1 = integerList.parallelStream().distinct().collect(Collectors.toList());

        List<Integer> collect2 = integerList.stream().limit(2).collect(Collectors.toList());
        List<Integer> collect3 = integerList.stream().skip(1).collect(Collectors.toList());


        log.info("\nsorted的结果为：{}\ndistinct的结果为:{}\nlimit的结果为：{}\nskip的结果为：{}"
        ,JSON.toJSONString(collect),JSON.toJSONString(collect1)
        ,JSON.toJSONString(collect2),JSON.toJSONString(collect3));

    }













}
