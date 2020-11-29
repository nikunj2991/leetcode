import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to integer
 * 
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D
 * and M. 
 * 
 *  Symbol Value 
 *    I       1 
 *    V       5 
 *    X      10 
 *    L      50
 *    C     100 
 *    D     500 
 *    M    1000 
 * 
 * For example, 2 is written as II in Roman numeral, just two one's added together. 
 * 12 is written as XII, which is simply X + II. The number 27 is written as XXVII,
 * which is XX + V + II.
 * 
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is
 * written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX. There
 * are six instances where subtraction is used:
 * 
 * I can be placed before V (5) and X (10) to make 4 and 9. X can be placed
 * before L (50) and C (100) to make 40 and 90. C can be placed before D (500)
 * and M (1000) to make 400 and 900. 
 * 
 * Given an integer, convert it to a roman numeral.
 */

public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int power = (int) Math.log10(num);

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");

        while (num != 0) {
            int divider = (int) Math.pow(10, power);
            int temp = num / divider;
            num = num % divider;
            result.append(getRoman(num, map, divider));
            power--;
        }

        return result.toString();
    }
    
    private String getRoman(int num, Map<Integer, String> map, int multiplier) {
        StringBuilder roman = new StringBuilder();
        boolean isGreaterThanFive = num > 5;

        if(map.get(num) != null) {
            return map.get(num);
        } else {
            if(isGreaterThanFive) {
                num = num - 5;
            }
            for(int i = 0; i < num; i++) {
                
            }
        }
    }
}
