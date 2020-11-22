import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * 
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 */

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> resultMap = new HashMap<>();

        if (nums.length < 2) {
            return null;
        }

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if(resultMap.containsKey(diff)) {
                return new int[] {resultMap.get(diff), i};
            }

            resultMap.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}