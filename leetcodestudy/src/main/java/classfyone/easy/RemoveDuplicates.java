package classfyone.easy;

/**
 * 输入：nums = [1,1,1,2]
 * 输出：2, nums = [1,2,_]
 */
public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums){
        if(nums.length<=1){
            return nums.length;
        }
        int result = 1;
        int remove = 0;
        //如果遇见相等的就开始移动
        for (int i = 1; i < nums.length-remove; i++) {
            if(nums[i] != nums[i-1]){
                result = result+1;
                continue;
            }
            //标记一下看需要移动几位
            int flag = 0;
            while (i+flag<nums.length && nums[i-1]==nums[i+flag]){
                flag++;
            }

            for (int j = i+flag; j < nums.length-remove; j++) {
                nums[j-flag] = nums[j];
            }
            remove  = remove +flag;
            i--;
        }
        return result;

    }

    /**
     * 双指针法
     * @param nums
     * @return
     */
    public static int removeDuplicates1(int[] nums){
        if(nums.length<=1){
            return nums.length;
        }
        int left=0;
        int right=0;
        while (left<=right && right<nums.length){
            if(nums[left]==nums[right]){
                right++;
                continue;
            }
            nums[++left] = nums[right];

        }


        return left+1;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int[] nums1 = new int[]{1,1};
       int num = RemoveDuplicates.removeDuplicates1(nums1);
        for (int i = 0; i < num; i++) {
            System.out.println(nums1[i]);
        }
    }
}
