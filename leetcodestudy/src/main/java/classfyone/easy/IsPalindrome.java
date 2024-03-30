package classfyone.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：验证回文串
 * 如果在将所有大写字符转换为写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * 字母和数字都属于字母数字字符。
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 */
public class IsPalindrome {
    public static boolean isPalindrome(String s) {
        s =s.toLowerCase();
        String words = "qwertyuiopasdfghjklzxcvbnm1234567890";
        String[] strArr = s.split("");
        List<String> dealArr = new ArrayList<>();
        for(int i=0;i<strArr.length; i++){
            if (words.contains(strArr[i])){
                dealArr.add(strArr[i]);
            }
        }
        int left = 0;
        int right = dealArr.size()-1;
        while (left<right){
            if(!dealArr.get(left).equals(dealArr.get(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;

    }

    public static void main(String[] args) {
        String[] tests = new String[]{"aaa", "ada", "add"};
        for (int i = 0; i < tests.length; i++) {
            boolean result = IsPalindrome.isPalindrome(tests[i]);
            System.out.println("第" + i + "个测试数据为:" + tests[i] + "\n" +
                    "第" + i + "个计算结果为:" + result + "\n");
        }
    }
}
