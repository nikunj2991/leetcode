import java.util.HashMap;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 * 
 * Given a string s, find the length of the longest substring without repeating characters.
 */

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int stringLength = s.length();

        Map<Character, Integer> map = new HashMap<>();

        if (stringLength < 2) {
            return stringLength;
        }

        for (int i = 0, j = 0; j < stringLength; j++) {
            char c = s.charAt(j);

            if(map.containsKey(c)) {
                i = Math.max(map.get(c), i);
            }

            result = Math.max(result, j - i + 1);
            map.put(c, j + 1);
        }

        return result;
    }
}
