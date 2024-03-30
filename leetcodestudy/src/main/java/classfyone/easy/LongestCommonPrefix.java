package classfyone.easy;

import com.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        String result = "";
        for (int i = 0; i<strs[0].length(); i++){
            // 注意点：注意下这里是左闭右开
            String prefix = strs[0].substring(0,i+1);
            Boolean flag = true;
            for (int j = 1; j < strs.length; j++) {
                if (!strs[j].startsWith(prefix)){
                    flag = false;
                }
            }
            if(flag){
                result = prefix;
            }else {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String[]> tests = new ArrayList();
        String[] test3 = new String[]{"flower","flow","flight"};
        String[] test2 = new String[]{"dog","flow","dlight"};
        String[] test1 = new String[]{"a"};
        String[] test4 = new String[]{"abc","abc"};
        tests.add(test1);
        tests.add(test2);
        tests.add(test3);
        tests.add(test4);
        for (int i = 0; i < tests.size(); i++) {
            String result = LongestCommonPrefix.longestCommonPrefix(tests.get(i));
            System.out.println("第"+i+"个测试数据为:"+ StringUtils.stingArrayToString(tests.get(i))+"\n"+
                    "第"+i+"个计算结果为:"+result+"\n");
        }

    }
}
