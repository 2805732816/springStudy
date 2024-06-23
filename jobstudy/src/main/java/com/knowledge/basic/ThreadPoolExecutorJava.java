package com.knowledge.basic;

import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.concurrent.*;
import java.util.logging.SimpleFormatter;

/**
 * 核心参数
 * corePoolSize（必需）：核心线程数。默认情况下，核心线程会一直存活，但是当将 allowCoreThreadTimeout 设置为 true 时，核心线程也会超时回收。
 * maximumPoolSize（必需）：线程池所能容纳的最大线程数。当活跃线程数达到该数值后，后续的新任务将会阻塞。
 * keepAliveTime（必需）：线程闲置超时时长。如果超过该时长，非核心线程就会被回收。如果将 allowCoreThreadTimeout 设置为 true 时，核心线程也会超时回收。
 * unit（必需）：指定 keepAliveTime 参数的时间单位。常用的有：TimeUnit.MILLISECONDS（毫秒）、TimeUnit.SECONDS（秒）、TimeUnit.MINUTES（分）。
 * workQueue（必需）：任务队列。通过线程池的 execute() 方法提交的 Runnable 对象将存储在该参数中。其采用阻塞队列实现。
 * threadFactory（可选）：线程工厂。用于指定为线程池创建新线程的方式。
 * handler（可选）：拒绝策略。当达到最大线程数时需要执行的饱和策略。
 *
 * 三种创建线程池方法（已不推荐）
 *
 */
public class ThreadPoolExecutorJava {
    /**
     * 拒绝策略
     */
    //默认拒绝策略 有问题直接抛异常
    private static final RejectedExecutionHandler defaultHandler =
            new ThreadPoolExecutor.AbortPolicy();
    //直接由提交任务者执行这个任务
    public static final RejectedExecutionHandler callerRunsPolicyHander =
            new ThreadPoolExecutor.CallerRunsPolicy();
    //什么也不做，直接忽略
    public static final RejectedExecutionHandler discardPolicyHander =
            new ThreadPoolExecutor.DiscardPolicy();
    //把最老的任务直接丢掉
    public static final RejectedExecutionHandler discardOldPolicyHander =
            new ThreadPoolExecutor.DiscardOldestPolicy();

    //默认工厂
    private static final ThreadFactory defaultFactory =
            Executors.defaultThreadFactory();

    //简易创建线程池的防范
    public ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
    public ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
    public ExecutorService newWorkStealingPool = Executors.newWorkStealingPool(10);

    /**
     * 手动创建线程池
     * 等待队列：SynchronousQueue，没有容量，一直提交任务
     * 拒绝策略：defaultHandler 默认拒绝策略，直接抛出异常RejectedExecutionException
     *
     */
    public ThreadPoolExecutor executorSynDef = new ThreadPoolExecutor
            (2, 4, 10, TimeUnit.SECONDS
                    ,new SynchronousQueue<Runnable>(),defaultFactory,defaultHandler);

    public ThreadPoolExecutor executorSynCel = new ThreadPoolExecutor
            (2, 4, 10, TimeUnit.SECONDS
                    ,new SynchronousQueue<Runnable>(),defaultFactory,callerRunsPolicyHander);

    public ThreadPoolExecutor executorSynDis = new ThreadPoolExecutor
            (2, 4, 10, TimeUnit.SECONDS
                    ,new SynchronousQueue<Runnable>(),defaultFactory,discardPolicyHander);

    public ThreadPoolExecutor executorSynDisOld = new ThreadPoolExecutor
            (2, 4, 10, TimeUnit.SECONDS
                    ,new SynchronousQueue<Runnable>(),defaultFactory,discardOldPolicyHander);

    /**
     *LinkedBlockingQueue 基于链表的先进先出队列，无界，与有界队列相比，除非系统资源耗尽，否则不存在任务入队失败的情况；
     */
    public ThreadPoolExecutor executorLinkDisOld = new ThreadPoolExecutor
            (2, 4, 10, TimeUnit.SECONDS,
                    new LinkedBlockingQueue<>(),defaultFactory,discardOldPolicyHander);
    /**
     * ArrayBlockingQueue:基于数组的先进先出队列，有界（创建队列时，指定队列的最大容量）
     */

    public ThreadPoolExecutor executorArrDisOld = new ThreadPoolExecutor
            (2, 4, 10, TimeUnit.SECONDS
                    ,new ArrayBlockingQueue<>(2),defaultFactory,discardOldPolicyHander);

    /**
     * PriorityBlockingQueue：一个具有优先级的无界阻塞队列，总是具有高优先级的任务先执行
     * 需要设置优先级
     */
    public ThreadPoolExecutor executorPriDisOld = new ThreadPoolExecutor
            (2, 4, 10, TimeUnit.SECONDS
                    ,new PriorityBlockingQueue<>(2),defaultFactory,discardOldPolicyHander);


    public ThreadPoolExecutor executorArrCal = new ThreadPoolExecutor
            (2, 4, 10, TimeUnit.SECONDS
                    ,new ArrayBlockingQueue<>(2),defaultFactory,callerRunsPolicyHander);



    @Test
    public void test(){

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executorSynDef.execute(()->{
                System.out.println(
                        "当前执行节点为："+ finalI+" "+
                        "当前线程为："+Thread.currentThread().getName()  +
                        "当前时间为："+new SimpleDateFormat("yyyy-hh-dd hh:mm:ss").format(System.currentTimeMillis()));            });
        }

    }
    @Test
    public void test1(){
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executorSynCel.execute(()->{
                System.out.println(
                        "当前执行节点为："+ finalI+
                                " 当前线程为："+Thread.currentThread().getName()  +
                                " 当前时间为："+new SimpleDateFormat("yyyy-hh-dd hh:mm:ss").format(System.currentTimeMillis()));          });
        }
    }

    @Test
    public void test2(){
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executorSynDis.execute(()->{
                System.out.println(
                        "当前执行节点为："+ finalI+
                                " 当前线程为："+Thread.currentThread().getName()  +
                                " 当前时间为："+new SimpleDateFormat("yyyy-hh-dd hh:mm:ss").format(System.currentTimeMillis()));          });
        }
    }

    @Test
    public void test3(){
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executorSynDisOld.execute(()->{
                System.out.println(
                        "当前执行节点为："+ finalI+
                                " 当前线程为："+Thread.currentThread().getName()  +
                                " 当前时间为："+new SimpleDateFormat("yyyy-hh-dd hh:mm:ss").format(System.currentTimeMillis()));          });
        }
    }

    @Test
    public void test4(){
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executorLinkDisOld.execute(()->{
                System.out.println(
                        "当前执行节点为："+ finalI+
                                " 当前线程为："+Thread.currentThread().getName()  +
                                " 当前时间为："+new SimpleDateFormat("yyyy-hh-dd hh:mm:ss").format(System.currentTimeMillis()));          });
        }
    }

    @Test
    public void test5(){
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executorArrDisOld.execute(()->{
                System.out.println(
                        "当前执行节点为："+ finalI+
                                " 当前线程为："+Thread.currentThread().getName()  +
                                " 当前时间为："+new SimpleDateFormat("yyyy-hh-dd hh:mm:ss").format(System.currentTimeMillis()));          });
        }
    }


    @Test
    public void test6(){
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executorPriDisOld.execute(()->{
                System.out.println(
                        "当前执行节点为："+ finalI+
                                " 当前线程为："+Thread.currentThread().getName()  +
                                " 当前时间为："+new SimpleDateFormat("yyyy-hh-dd hh:mm:ss").format(System.currentTimeMillis()));          });
        }
    }
    @Test
    public void test7(){
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executorArrCal.execute(()->{
                System.out.println(
                        "当前执行节点为："+ finalI+
                                " 当前线程为："+Thread.currentThread().getName()  +
                                " 当前时间为："+new SimpleDateFormat("yyyy-hh-dd hh:mm:ss").format(System.currentTimeMillis()));          });
        }
    }

    public static void main(String[] args) {




    }


}
