package classfyone.easy;

import com.utils.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目：同构字符串
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * 错误：badc-baba
 *
 */
public class IsIsomorphic {
    public static boolean isIsomorphic(String s, String t) {
        String[] sArr = s.split("");
        String[] tArr = t.split("");
        //存储映射关系
        Map<String, String> map = new HashMap<>();
        Map<String, String> map1 = new HashMap<>();

        for (int i = 0; i < sArr.length; i++) {

            if(!map.containsKey(sArr[i])){
                map.put(sArr[i],tArr[i]);
                continue;
            }
            //注意下什么时候是if if  什么时候是 if else
            if(!map.get(sArr[i]).equals(tArr[i])){
                return false;
            }
        }

        for (int i = 0; i < tArr.length; i++) {

            if(!map1.containsKey(tArr[i])){
                map1.put(tArr[i],sArr[i]);
                continue;
            }
            //注意下什么时候是if if  什么时候是 if else
            if(!map1.get(tArr[i]).equals(sArr[i])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<String[]> tests = new ArrayList();
        String[] test3 = new String[]{"egg","rff"};
        String[] test2 = new String[]{"d","e"};
        String[] test1 = new String[]{"badc","baba"};
        String[] test4 = new String[]{"title","paper"};
        tests.add(test1);
        tests.add(test2);
        tests.add(test3);
        tests.add(test4);
        for (int i = 0; i < tests.size(); i++) {
            boolean result = IsIsomorphic.isIsomorphic(tests.get(i)[0],tests.get(i)[1]);
            System.out.println("第"+i+"个测试数据为:"+ StringUtils.stingArrayToString(tests.get(i))+"\n"+
                    "第"+i+"个计算结果为:"+result+"\n");
        }

    }
}
