package com.knowledge.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


/**
 * 共同点
 * 1、
 *
 * 不同点
 * 1、语法不同：wait必须搭配synchronized使用，sleep可以单独使用
 * 2、唤醒方式不同：sleep到达只当时间后就会自动唤醒，而无参的wait只能通过notify唤醒
 * 3、等待状态不同：sleep进入TIMED_WAIT、wait进入WAIT
 * 4、释放锁资源不同：sleep不会释放锁，wait会释放锁
 */
@Slf4j
public class ThreadJava {
    private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
    private final static Object lock = new Object();


    @Test
    public void sleepTest() throws Exception{
        //等待时间到了后则会唤醒线程
        log.info("sleep前时间为：{}",getCurrentTime());
        Thread.sleep(10000L);
        log.info("sleep后时间为：{}",getCurrentTime());
    }


    @Test
    public void waitTest() throws Exception{
        log.info("wait前时间为：{}",getCurrentTime());
        synchronized (lock){
            //等待时间结束后线程唤醒
            lock.wait(1000L);
            log.info("wait(1000L)时间为：{}",getCurrentTime());
            //无限等待
            lock.wait();
        }
        log.info("wait()后时间为：{}",getCurrentTime());
    }


    @Test
    public void notifyTest() throws Exception{
        new Thread(() -> {
            log.info("{}开始执行：{}", Thread.currentThread().getName(),getCurrentTime());
            synchronized (lock){
                log.info("{}抢占到锁：{}",Thread.currentThread().getName(),sdf.format(new Date()));
                try {
                    log.info("{}等待开始:{}",Thread.currentThread().getName(),sdf.format(new Date()));
                    //wait会自动化释放锁
                    lock.wait();
                    log.info("{}等待结束:{}",Thread.currentThread().getName(),sdf.format(new Date()));
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }
            log.info("{}释放锁：{}",Thread.currentThread().getName(),sdf.format(new Date()));

        }).start();


        new Thread(() -> {
            log.info("{}开始执行：{}", Thread.currentThread().getName(),sdf.format(new Date()));
            log.info("{}sleep开始：{}",Thread.currentThread().getName(),sdf.format(new Date()));
            //sleep不会释放锁
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("{}sleep结束：{}",Thread.currentThread().getName(),sdf.format(new Date()));
            synchronized (lock){
                log.info("{}抢占到锁：{}",Thread.currentThread().getName(),sdf.format(new Date()));
                lock.notifyAll();
                log.info("{}唤醒lock结束",Thread.currentThread().getName());
            }
        }).start();
    }




    public static String getCurrentTime(){
        return sdf.format(new Date());
    }

    public static void main(String[] args) {
        new Thread(() -> {
            log.info("{}开始执行：{}", Thread.currentThread().getName(),getCurrentTime());
            synchronized (lock){
                log.info("{}抢占到锁：{}",Thread.currentThread().getName(),sdf.format(new Date()));
                try {
                    log.info("{}等待开始:{}",Thread.currentThread().getName(),sdf.format(new Date()));
                    //wait会自动化释放锁
                    lock.wait();
                    log.info("{}等待结束:{}",Thread.currentThread().getName(),sdf.format(new Date()));
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }
            log.info("{}释放锁：{}",Thread.currentThread().getName(),sdf.format(new Date()));

        }).start();


        new Thread(() -> {
            log.info("{}开始执行：{}", Thread.currentThread().getName(),sdf.format(new Date()));
            log.info("{}sleep开始：{}",Thread.currentThread().getName(),sdf.format(new Date()));
            //sleep不会释放锁
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("{}sleep结束：{}",Thread.currentThread().getName(),sdf.format(new Date()));
            synchronized (lock){
                log.info("{}抢占到锁：{}",Thread.currentThread().getName(),sdf.format(new Date()));
                lock.notifyAll();
                log.info("{}唤醒lock结束",Thread.currentThread().getName());
            }
        }).start();
    }
}
