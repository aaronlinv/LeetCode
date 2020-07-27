package _125valid_palindrome;

import org.junit.Assert;
import org.junit.Test;

public class Main {
    @Test
    public void test() {
        Solution solution = new Solution();

        boolean palindrome = solution.isPalindrome("A man, a plan, a canal: Panama");
        Assert.assertTrue(palindrome);

        palindrome = solution.isPalindrome("race a car");
        Assert.assertFalse(palindrome);

        palindrome = solution.isPalindrome("");
        Assert.assertTrue(palindrome);

    }

    // 双指针+正则
    class Solution {
        public boolean isPalindrome(String s) {

            int right = s.length() - 1;
            int left = 0;
            while (left < right) {


                String leftStr = String.valueOf(s.charAt(left));
                String rightStr = String.valueOf(s.charAt(right));

                if (!leftStr.matches("[a-zA-Z0-9]")) {
                    left++;
                    continue;
                }
                if (!rightStr.matches("[a-zA-Z0-9]")) {
                    right--;
                    continue;
                }

                if (leftStr.compareToIgnoreCase(rightStr) != 0) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }

}

// 自顶向下 
class Solution2 {
    public boolean isPalindrome(String s) {
        // 1. filter out number & char
        String filterS = filterOutNumberAndChat(s);
        // 2. reverse string 
        String reversedS = reverseString(filterS); 
        
        return s.equalsIgnoreCase(reversedS) ;
    }

    private String reverseString(String filterS) {
        return null;
    }

    private String filterOutNumberAndChat(String s) {
        
        return null;
    }
}