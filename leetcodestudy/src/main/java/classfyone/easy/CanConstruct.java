package classfyone.easy;

import com.utils.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目：赎金信
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 *
 * 提示：
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote 和 magazine 由小写英文字母组成
 */
public class CanConstruct {
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<String,Integer> ransomNoteMap = new HashMap<>();
        Map<String, Integer> magazineMap = new HashMap<>();
        String[] ransomNoteArr = ransomNote.split("");
        String[] magazineArr = magazine.split("");
        for(String str: ransomNoteArr){
            if(ransomNoteMap.containsKey(str)){
                Integer value = ransomNoteMap.get(str);
                ransomNoteMap.put(str,value+1);
            }else {
            ransomNoteMap.put(str,1);}
        }

        for(String str: magazineArr){
            if(magazineMap.containsKey(str)){
                Integer value = magazineMap.get(str);
                magazineMap.put(str,value+1);
            }else {
            magazineMap.put(str,1);}
        }

        for(String key:ransomNoteMap.keySet()){
            if(!magazineMap.containsKey(key)){
                return false;
            }
            Integer wordSize = magazineMap.get(key);
            if(wordSize<ransomNoteMap.get(key)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<String[]> tests = new ArrayList();
        String[] test3 = new String[]{"a","b"};
        String[] test2 = new String[]{"aa","ab"};
        String[] test1 = new String[]{"aa","aab"};
        String[] test4 = new String[]{"bca","abc"};
        tests.add(test1);
        tests.add(test2);
        tests.add(test3);
        tests.add(test4);
        for (int i = 0; i < tests.size(); i++) {
            boolean result = CanConstruct.canConstruct(tests.get(i)[0],tests.get(i)[1]);
            System.out.println("第"+i+"个测试数据为:"+ StringUtils.stingArrayToString(tests.get(i))+"\n"+
                    "第"+i+"个计算结果为:"+result+"\n");
        }

    }
}
