package com.utils;

import java.util.Arrays;

public class SortUtils {
    /**
     * 找到数组的最大值
     * @return
     */
    public static void findMax(){
        int[] nums = new int[]{4,5,2,7,8,3,1};
        int min;
        //方法一：先排序，再返回末尾的数据
        Arrays.sort(nums);
        min = nums[nums.length-1];
        System.out.println("找到最大值方法一："+ min);


        min = Arrays.stream(nums).max().getAsInt();
        System.out.println("找到最大值方法二："+ min);

    }

    public static void main(String[] args) {
        SortUtils.findMax();
    }
}
