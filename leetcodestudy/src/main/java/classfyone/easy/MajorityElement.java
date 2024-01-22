package classfyone.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 多数元素：给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class MajorityElement {
    public static int majorityElement(int[] nums){
        int result = 0;
        int length = nums.length;
        int target = length/2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num:nums){
            if (map.containsKey(num)){
                int value = map.get(num);
                map.put(num,++value);

            }else {
                map.put(num,1);
            }
            if(map.get(num)>target){
                return num;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,3,3};
        System.out.println(MajorityElement.majorityElement(nums));
    }
}
