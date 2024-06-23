package com.knowledge.basic;


import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import sun.reflect.generics.tree.Tree;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * HashMap:非线程安全的，可以使用：Collections.synchronizedMap
 * ConcurrentHashMap:线程安全
 * LinkedHashMap:通过双向链表维护插入顺序或访问顺序，提供了一种既高效又有序的键值对存储结构
 * TreeMap:根据key的顺序进行排序，实现了comparator接口，非线程安全
 *
 */
@Slf4j
public class MapJava {
    @Test
    public void map(){
        //HashMap是非线程安全的
        Map<Object, Object> map = new HashMap<>();
        Object o = map.putIfAbsent("1", "1");
        Object o1 = map.putIfAbsent("1", "2");
        log.info("{},{},{}",JSON.toJSONString(map),o,o1);
    }


    @Test
    public void threadSafeMap(){
        //方式一、使用Collections.synchronizedMap
        Map<Object,Object> synchronizedMap = Collections.synchronizedMap(new HashMap<>());
        //方式二：
        Map<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();
    }

    @Test
    public void linkedHashMap(){
        Map<String, String> map = new HashMap<>();
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();

        //输出是无序的
        for (int i = 0; i < 100; i++) {
            map.put(String.valueOf(i),String.valueOf(i));
            linkedHashMap.put(String.valueOf(i),String.valueOf(i));

        }
        //按照插入顺序输出
        map.entrySet().forEach(stringStringEntry -> {
            System.out.println(stringStringEntry.getKey()+":"+stringStringEntry.getValue());
        });

        linkedHashMap.entrySet().forEach(stringStringEntry -> {
            System.out.println(stringStringEntry.getKey()+":"+stringStringEntry.getValue());
        });
    }


    @Test
    public void treeMapTest(){
        TreeMap<String, Object> objectObjectTreeMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        TreeMap<Object, Object> objectObjectTreeMap1 = new TreeMap<>();

        TreeMap<Person, String> treeMap = new TreeMap<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge().compareTo(o2.getAge());
            }
        });
        for (int i = 0; i < 20; i++) {
            objectObjectTreeMap.put(String.valueOf(i),String.valueOf(i));
            objectObjectTreeMap1.put(String.valueOf(i),String.valueOf(i));
            treeMap.put(new Person(i,"cxx",Arrays.asList()),String.valueOf(i));
        }

        List<Map.Entry<String, Person>> collect = treeMap.entrySet().parallelStream()
                .collect(Collectors.toMap(e -> e.getValue(), e -> e.getKey()))
                .entrySet().parallelStream().collect(Collectors.toList());
        //根据map的value降序输出
        Collections.sort(collect, new Comparator<Map.Entry<String, Person>>() {
            @Override
            public int compare(Map.Entry<String, Person> o1, Map.Entry<String, Person> o2) {
                return o2.getValue().getAge().compareTo(o1.getValue().getAge());
            }
        });


        //降序
        System.out.println("降序输出");
        objectObjectTreeMap.entrySet().forEach(stringStringEntry -> {
            System.out.println(stringStringEntry.getKey()+":"+stringStringEntry.getValue());
        });
        System.out.println("升序输出");
        objectObjectTreeMap1.entrySet().forEach(stringStringEntry -> {
            System.out.println(stringStringEntry.getKey()+":"+stringStringEntry.getValue());
        });

        System.out.println("按照年龄升序输出");
        treeMap.entrySet().forEach(stringStringEntry -> {
            System.out.println(stringStringEntry.getKey()+":"+stringStringEntry.getValue());
        });

        System.out.println("按照年龄降序输出");
        collect.stream().forEach(stringStringEntry->{
            System.out.println(stringStringEntry.getKey()+":"+stringStringEntry.getValue());


        });



    }
}
