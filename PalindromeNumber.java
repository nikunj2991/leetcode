/**
 * 9. Palindrome Number
 * 
 * Determine whether an integer is a palindrome. 
 * An integer is a palindrome when it reads the same backward as forward.
 * 
 * Follow up: Could you solve it without converting the integer to a string?
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        
        if (x == 0) return true;
        
        int temp = x;
        int reverse = 0;
        
        while (temp != 0) {
            reverse = reverse * 10 + temp % 10;
            temp = temp / 10;
        }
        
        return reverse == x ? true : false;
    }
}
