package classfyone.easy;

/**
 * demo1:
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 */
public class CombineTwoList {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //先把最大的数放在最右边
        //如果num1没有遍历完，无需处理
        //如果num2没有遍历完，则需要将这些数据放在num1的前半部分

        int index = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[index--] = nums1[m--];
            } else {
                nums1[index--] = nums2[n--];
            }
        }

        if (n > -1) {
            while (index >= 0 && n >= 0) {
                nums1[index--] = nums2[n--];
            }
        }
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] num2 = new int[]{2, 4, 5};
        int n = 3;
        CombineTwoList.merge(num1, m, num2, n);


        int[] num11 = new int[]{6, 7, 8, 0, 0, 0};
        int m1 = 3;
        int[] num21 = new int[]{2, 4, 5};
        int n1 = 3;
        CombineTwoList.merge(num11, m1, num21, n1);
    }
}


