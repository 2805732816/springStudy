package classfyone.easy;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MaxProfit {
    public static int maxProfit(int[] prices){
        //空数组和数组长度为1的肯定不能买卖咯
        if (prices.length<=1){
            return 0;
        }
        int result = 0;
        int[] dp = new int[prices.length];
        dp[0] = 0;
        //标记一下过去天数的股价最低值
        int minPrice = prices[0];
        for (int i=1; i<prices.length; i++){
            minPrice = prices[i]<minPrice ? prices[i]:minPrice;
            dp[i] = prices[i]-minPrice<0 ? 0:prices[i]-minPrice;
        }

        //获取数组的最小值
        Arrays.sort(dp);

        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        int i = MaxProfit.maxProfit(prices);
        System.out.println(i);
    }
}
