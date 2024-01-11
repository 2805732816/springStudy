package classfyone.easy;

import java.util.*;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        //用map记录数组数的下标索引
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                List<Integer> temp = map.get(nums[i]);
                temp.add(i);
                map.put(nums[i],temp);
                continue;
            }
            List indexList = new ArrayList();
            indexList.add(i);
            map.put(nums[i], indexList);
        }
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;
        while (i<j){
            if(nums[i]+nums[j] == target){
                if(nums[i]==nums[j]){
                    result[0] = map.get(nums[i]).get(0);
                    result[1] = map.get(nums[j]).get(1);
                    return result;
                }
                result[0] = map.get(nums[i]).get(0);
                result[1] = map.get(nums[j]).get(0);
                return result;


            }

            if(nums[i]+nums[j]>target){
                j--;
            }
            if(nums[i]+nums[j]<target){
                i++;
            }
        }
        return result;


    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 4};
        int target = 6;
        int[] result = TwoSum.twoSum(nums, target);
        for(int num:result){
            System.out.println(num);
        }


    }
}
