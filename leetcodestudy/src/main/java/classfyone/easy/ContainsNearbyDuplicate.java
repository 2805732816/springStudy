package classfyone.easy;

import utils.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 题目：找出字符串中第一个匹配项的下标
 * 给你两个字符串 haystack 和 needle ，
 * 请你在 haystack 字符串中找出 needle字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
 */
public class ContainsNearbyDuplicate {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k==0){
            return false;
        }
        //队列存储k长度的，如果超出k的长度就将对头去掉
        Queue<Integer> queue = new LinkedList<>();
        for (int num:nums){
            if(queue.size()==k+1){
                queue.remove();
            }

            if(queue.contains(num)){
                return true;
            }
            queue.add(num);
        }
        return false;
    }



    public static void main(String[] args) {
//        List<String[]> tests = new ArrayList();
//        String[] test1 = new String[]{"abba","dog cat cat dog"};
//        String[] test2 = new String[]{"abba","dog cat cat fish"};
//        String[] test3 = new String[]{"aaaa","dog cat cat dog"};
//        String[] test4 = new String[]{"aaa","dog cat cat dog"};
//        String[] test5 = new String[]{"abc","aaa aaa aaa"};
//        tests.add(test1);
//        tests.add(test2);
//        tests.add(test3);
//        tests.add(test4);
//        tests.add(test5);
//        for (int i = 0; i < tests.size(); i++) {
//            boolean result = ContainsNearbyDuplicate.containsNearbyDuplicate(tests.get(i)[0],tests.get(i)[1]);
//            System.out.println("第"+i+"个测试数据为:"+ StringUtils.stingArrayToString(tests.get(i))+"\n"+
//                    "第"+i+"个计算结果为:"+result+"\n");
//        }

        int[] nums = new int[]{1,2,3,1};
        int k = 3;
        System.out.println(ContainsNearbyDuplicate.containsNearbyDuplicate(nums,k));


    }
}
