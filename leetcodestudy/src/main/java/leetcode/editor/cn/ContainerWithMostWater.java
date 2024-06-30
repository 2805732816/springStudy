 
package leetcode.editor.cn;

//<div><div>Related Topics</div><div><li>贪心</li><li>数组</li><li>双指针</li></div></div><br><div><li>👍 5021</li><li>👎 0</li></div>
public class ContainerWithMostWater{
    public static void main(String[] args) {
        Solution solution = new ContainerWithMostWater().new Solution();
        solution.maxArea(new int[]{2,3,10,5,7,8,9});
        
    }
 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length-1;
        while (left<right){
            int low = Math.min(height[left],height[right]);
            int currentWater = (right-left)*low;
            maxWater = Math.max(currentWater,maxWater);
            //一定得是高度更低的一端开始移动，高度高的一段移动后存水量一定小于目前的，参考currentWater公式
            if(height[left]<height[right]){
                do {
                    left++;
                    //注意数组越界问题
                }while (left<height.length-1 && low>height[left]);
            }else {
                do {
                    right--;
                    //注意数组越界问题
                }while (right>0 && low>height[right]);
            }
        }
        return maxWater;
    }


    public int maxArea1(int[] height) {
        int maxWater = 0;
        for (int i = 0; i < height.length ; i++) {
            for (int j = i+1; j < height.length; j++) {
                int currentWater = (j-i)*Math.min(height[i],height[j]);
                maxWater = maxWater<currentWater? currentWater:maxWater;
            }
        }
        return maxWater;

    }


}
//leetcode submit region end(Prohibit modification and deletion)

}