/**
 * 11. Container with most water.
 * 
 * Given n non-negative integers a1, a2, ..., an , 
 * where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints 
 * of the line i is at (i, ai) and (i, 0). Find two lines, which, 
 * together with the x-axis forms a container, such that the 
 * container contains the most water. 
 * 
 * Notice that you may not slant the container.
 */

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;

        if (height.length < 1) return maxArea;

        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            maxArea = Math.max(maxArea, (Math.min(height[l], height[r]) * (r - l)));

            if (height[l] < height[r]) {
                l--;
            } else {
                r++;
            }
        }

        return maxArea;
    }
}