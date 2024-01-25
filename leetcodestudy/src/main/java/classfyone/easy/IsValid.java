package classfyone.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 题目：有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * 注意点：经典的栈
 */


public class IsValid {
    public static Boolean isValid(String s) {
        //java的栈结构
        Stack stack = new Stack();
        //存储五对括号
        Map<String,String> map = new HashMap<>();
        map.put("(",")");
        map.put("{","}");
        map.put("[","]");
        //将s转成String[]
        String[] strArr = s.split("");
        for (int i = 0; i < strArr.length; i++) {
            if(stack.isEmpty()){
                stack.add(strArr[i]);
                continue;
            }
            String peek = (String) stack.peek();
            if (strArr[i].equals(map.get(peek))){
                stack.pop();
                continue;
            }

            stack.add(strArr[i]);
        }
        return stack.isEmpty() ? true:false;
    }

    public static void main(String[] args) {
        String[] tests = new String[]{"()[]{}","())","((()))"};
        for (int i = 0; i < tests.length; i++) {
            Boolean result = IsValid.isValid(tests[i]);
            System.out.println("第"+i+"个测试数据为:"+tests[i]+"\n"+
                    "第"+i+"个计算结果为:"+result+"\n");
        }

    }
}
