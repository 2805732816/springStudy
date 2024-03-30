package classfyone.easy;

import com.utils.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 题目：找出字符串中第一个匹配项的下标
 * 给你两个字符串 haystack 和 needle ，
 * 请你在 haystack 字符串中找出 needle字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
 */
public class WordPattern {
    public static boolean wordPattern1(String pattern, String s) {
        String[] pArr = pattern.split("");
        String[] sArr = s.split(" ");
        //注意一下前后不一致的情况
        if(pArr.length!=sArr.length){
            return false;
        }
        Set<String> pSet = Arrays.stream(pArr).collect(Collectors.toSet());
        Set<String> sSet = Arrays.stream(sArr).collect(Collectors.toSet());
        if (pSet.size()!=sSet.size()){
            return false;
        }
        Map<String, String> pToS = new HashMap<>();
        for (int i = 0; i< pArr.length && i<sArr.length; i++){
            if(!pToS.containsKey(pArr[i])){
                pToS.put(pArr[i], sArr[i]);
                continue;
            }

            if(!pToS.get(pArr[i]).equals(sArr[i])){
                return false;
            }
        }
        return true;
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] pArr = pattern.split("");
        String[] sArr = s.split(" ");
        //注意一下前后不一致的情况
        if(pArr.length!=sArr.length){
            return false;
        }
        Map<String, String> pToS = new HashMap<>();
        Map<String, String> sToP = new HashMap<>();

        for (int i = 0; i< pArr.length && i<sArr.length; i++){
            if(!pToS.containsKey(pArr[i])){
                pToS.put(pArr[i], sArr[i]);
                continue;
            }

            if(!pToS.get(pArr[i]).equals(sArr[i])){
                return false;
            }
        }

        for (int i = 0; i < sArr.length && i<pArr.length; i++) {
            if(!sToP.containsKey(sArr[i])){
                sToP.put(sArr[i],pArr[i]);
                continue;
            }

            if(!sToP.get(sArr[i]).equals(pArr[i])){
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        List<String[]> tests = new ArrayList();
        String[] test1 = new String[]{"abba","dog cat cat dog"};
        String[] test2 = new String[]{"abba","dog cat cat fish"};
        String[] test3 = new String[]{"aaaa","dog cat cat dog"};
        String[] test4 = new String[]{"aaa","dog cat cat dog"};
        String[] test5 = new String[]{"abc","aaa aaa aaa"};
        tests.add(test1);
        tests.add(test2);
        tests.add(test3);
        tests.add(test4);
        tests.add(test5);
        for (int i = 0; i < tests.size(); i++) {
            boolean result = WordPattern.wordPattern(tests.get(i)[0],tests.get(i)[1]);
            System.out.println("第"+i+"个测试数据为:"+ StringUtils.stingArrayToString(tests.get(i))+"\n"+
                    "第"+i+"个计算结果为:"+result+"\n");
        }

    }
}
