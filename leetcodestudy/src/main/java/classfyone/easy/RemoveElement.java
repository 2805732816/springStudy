package classfyone.easy;

import java.util.Arrays;

public class RemoveElement {
    public static int removeElement(int[] nums, int val){
        int result = nums.length;
        //先遍历数组，遇到了等于val的时候，直接移到末尾，末尾也不用再判断了
        for (int i = 0; i < result; i++) {
            //如果等于移动数组
            if(nums[i]==val){
                //记得i要减一下，因为此时下标为i的数不等于val
                //result得减一，因为将等于val的数组移到最后面了
                nums[i--] = nums[--result];
            }

        }

        return result;
    }

    public static int removeElement1(int[] nums, int val){
        int result = 0;
        //先遍历数组，遇到了等于val的时候，再将数一个个移过去

        //移到后面了就不能遍历了哈，不然result会加一
        for (int i = 0; i < nums.length-result; i++) {
            //如果不等于直接下一个
            if (nums[i] != val){
                continue;
            }
            //这里不能这么判断！！不然i+1的时候又判断等于val了，必须与最后一位交换
            //等于就开始把后面的元素都往前移动一位
//            for (int j = i+1; j < nums.length-result+1; j++) {
//                nums[j-1] = nums[j];
//            }
            result++;
            nums[i--] = nums[nums.length-result];

        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        int val = 3;
        int result = RemoveElement.removeElement1(nums, val);
        System.out.println("result:" + result);
        for(int num: nums){
            System.out.println(num);
        }
    }
}
