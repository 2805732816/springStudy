package classfyone.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。
 *
 *
 * 注意点：不要被特例数字迷惑了
 */


public class RomanToInt {
    public static int romanToInt(String s) {
        int result = 0;
        Map<String, Integer> romanMap = new HashMap<>();
        romanMap.put("I",1);
        romanMap.put("V",5);
        romanMap.put("X",10);
        romanMap.put("L",50);
        romanMap.put("C",100);
        romanMap.put("D",500);
        romanMap.put("M",1000);

        //错误1:将s转成字符串数组  这是转换成了char，但是map里面的key是String类型
//        char[] stringArray = s.toCharArray();

        String[] stringArray = s.split("");
        int length = s.length();
        for (int i = 0; i < length; i++) {
            int value = romanMap.get(stringArray[i]);
            if(i<length-1 && value<romanMap.get(stringArray[i+1])){
                result -= value;
            }else {
                result += value;
            }
        }
        return result;



    }

    public static void main(String[] args) {
        String[] tests = new String[]{"III","VI","IV"};
        for (int i = 0; i < tests.length; i++) {
            int result = RomanToInt.romanToInt(tests[i]);
            System.out.println("第"+i+"个测试数据为:"+tests[i]+"\n"+
                    "第"+i+"个计算结果为:"+result+"\n");
        }

    }
}
