 
package leetcode.editor.cn;
 
//<p>给你一个整数 <code>x</code> ，如果 <code>x</code> 是一个回文整数，返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>
//
//<p><span data-keyword="palindrome-integer">回文数</span>是指正序（从左向右）和倒序（从右向左）读都是一样的整数。</p>
//
//<ul> 
// <li>例如，<code>121</code> 是回文，而 <code>123</code> 不是。</li> 
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>x = 121
//<strong>输出：</strong>true
//</pre>
//
//<p><strong>示例&nbsp;2：</strong></p>
//
//<pre>
//<strong>输入：</strong>x = -121
//<strong>输出：</strong>false
//<strong>解释：</strong>从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>x = 10
//<strong>输出：</strong>false
//<strong>解释：</strong>从右向左读, 为 01 。因此它不是一个回文数。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>-2<sup>31</sup>&nbsp;&lt;= x &lt;= 2<sup>31</sup>&nbsp;- 1</code></li> 
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>进阶：</strong>你能不将整数转为字符串来解决这个问题吗？</p>
//
//<div><div>Related Topics</div><div><li>数学</li></div></div><br><div><li>👍 2861</li><li>👎 0</li></div>
public class PalindromeNumber{
    public static void main(String[] args) {
        Solution solution = new PalindromeNumber().new Solution();
        solution.isPalindrome(121);
        
    }
 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(int x){
        //StringBuilder和StringBuffer自带reverse方法，记得转回成string
        return String.valueOf(x).equals(new StringBuilder(String.valueOf(x)).reverse().toString());
    }

    public boolean isPalindrome1(int x){
        //记得记录原始的x的大小
        int initX = x;
        if(x<0){
            return false;
        }
        int reverse = 0;
        //把整数反转，再对比数组
        while (x!=0){
            int tail = x%10;
            x = x/10;
            reverse = reverse*10 + tail;
        }
        return initX-reverse==0;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}