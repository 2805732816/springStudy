package classfyone.easy;

import com.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：找出字符串中第一个匹配项的下标
 * 给你两个字符串 haystack 和 needle ，
 * 请你在 haystack 字符串中找出 needle字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
 */
public class StrStr {
    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);

    }

    public static void main(String[] args) {
        List<String[]> tests = new ArrayList();
        String[] test3 = new String[]{"flower","ow"};
        String[] test2 = new String[]{"dog","sff"};
        String[] test1 = new String[]{"a","sdaf"};
        String[] test4 = new String[]{"abc","abc"};
        tests.add(test1);
        tests.add(test2);
        tests.add(test3);
        tests.add(test4);
        for (int i = 0; i < tests.size(); i++) {
            int result = StrStr.strStr(tests.get(i)[0],tests.get(i)[1]);
            System.out.println("第"+i+"个测试数据为:"+ StringUtils.stingArrayToString(tests.get(i))+"\n"+
                    "第"+i+"个计算结果为:"+result+"\n");
        }

    }
}
