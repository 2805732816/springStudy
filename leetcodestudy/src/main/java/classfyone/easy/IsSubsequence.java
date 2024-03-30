package classfyone.easy;

import com.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：判断子序列
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）

 */
public class IsSubsequence {
    public static Boolean isSubsequence(String s, String t) {
        if(s.length()==0){
            return true;
        }
        String[] sArr = s.split("");
        int flag = 0;
        for(int i=0; i<sArr.length; i++){
            String str = sArr[i];
            int index = t.indexOf(str);
            if(index==-1){
                return false;
            }
            t = t.substring(index+1);
            flag = i;
        }
        return flag==sArr.length-1 ? true:false;
    }

    public static void main(String[] args) {
        List<String[]> tests = new ArrayList();
        String[] test3 = new String[]{"o","ow"};
        String[] test2 = new String[]{"dog","sff"};
        String[] test1 = new String[]{"",""};
        String[] test4 = new String[]{"abc","abc"};
        tests.add(test1);
        tests.add(test2);
        tests.add(test3);
        tests.add(test4);
        for (int i = 0; i < tests.size(); i++) {
            Boolean result = IsSubsequence.isSubsequence(tests.get(i)[0],tests.get(i)[1]);
            System.out.println("第"+i+"个测试数据为:"+ StringUtils.stingArrayToString(tests.get(i))+"\n"+
                    "第"+i+"个计算结果为:"+result+"\n");
        }

    }
}
