 
package leetcode.editor.cn;
 
//<p>给你一个字符串 <code>s</code>，找到 <code>s</code> 中最长的 <span data-keyword="palindromic-string">回文</span> <span data-keyword="substring-nonempty">子串</span>。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>s = "babad"
//<strong>输出：</strong>"bab"
//<strong>解释：</strong>"aba" 同样是符合题意的答案。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>s = "cbbd"
//<strong>输出：</strong>"bb"
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= s.length &lt;= 1000</code></li> 
// <li><code>s</code> 仅由数字和英文字母组成</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>双指针</li><li>字符串</li><li>动态规划</li></div></div><br><div><li>👍 7255</li><li>👎 0</li></div>
public class LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        solution.longestPalindrome("cbbd");
        
    }
 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        if(s.length()<=1){
            return s;
        }
        int left = 0;
        int right = 0;
        //动态规则
        String[] strList = s.split("");
        int length = strList.length;
        //初始化二维数组，初始值都是0
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            //是回文子串则设置成true
            dp[i][i] = true;
        }
        //  10 20 21 30 31 32

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if(!strList[i].equals(strList[j])){
                    dp[i][j] = false;
                }else {
                    if(i-j<3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i-1][j+1];
                    }
                }
                if(dp[i][j] && i-j>right-left){
                    right = i;
                    left = j;
                }
            }

        }
        return s.substring(left,right+1);

    }

    public String longestPalindrome0(String s) {
        if(s.length()<=1){
            return s;
        }
        String result = s.substring(0,1);
        //动态规则
        String[] strList = s.split("");
        int length = strList.length;
        //初始化二维数组，初始值都是0
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            //是回文子串则设置成1
            dp[i][i] = 1;
        }
        //  10 20 21 30 31 32

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if(!strList[i].equals(strList[j])){
                    dp[i][j] = 0;
                    continue;
                }
                if(i-j==1){
                    dp[i][j]=1;
                    if(result.length()<i-j+1){
                        result = s.substring(j,i+1);
                    }
                    continue;
                }
                if(dp[i-1][j+1]==1){
                    dp[i][j]=1;
                    if(result.length()<i-j+1){
                        result = s.substring(j,i+1);
                    }
                    continue;
                }
            }

        }
        return result;

    }

}
//leetcode submit region end(Prohibit modification and deletion)

}