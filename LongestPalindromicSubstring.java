/**
 * 4. Longest Palindromic Substring
 * 
 * Given a string s, return the longest palindromic substring in s.
 */

public class LongestPalindromicSubstring {
    // Solution with expanding around center.
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        
        int start = 0; 
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if(len > end - start) {
                start = i - ((len - 1)/2);
                end = i + (len/2);
            }
        }
        return s.substring(start, end + 1);
    }

    // Dynamic programming.
    public String longestPalindromeByDP(String s) {
        if (s == null || s.length() < 1) return "";
        
        int size = s.length();
        
        boolean table[][] = new boolean[size][size];
        
        // Strings with length equals 1
        int maxLength = 1;
        for(int i = 0; i < size; i++) {
            table[i][i] = true;
        }
        
        // Strings with length equals 2
        int start = 0;
        for(int i = 0; i < size - 1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                table[i][i+1] = true;
                start = i;
                maxLength = 2;
            }
        }
        
        // Strings with length equals or more than 3
        for(int k = 3; k <= size; k++) {
            // Fixing starting index
            for(int i = 0; i < size - k + 1; i++) {
                // Setting end index
                int j = i + k - 1;
                
                // Checking for the chars at start and end index and
                // non-boundary substring
                if (s.charAt(i) == s.charAt(j) && table[i+1][j-1]) {
                    table[i][j] = true;
                    if (k > maxLength) {
                        maxLength = k;
                        start = i;
                    }
                }
            }
        }
        
        // Return result based on start and maxLength of palindrome
        return s.substring(start, start + maxLength);
    }
    
    // Helper function to expand around center
    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
