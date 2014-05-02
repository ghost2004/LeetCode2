/*
 *  Given n non-negative integers a1, a2, ..., an, where each represents
 *  a point at coordinate (i, ai). n vertical lines are drawn such that 
 *  the two endpoints of line i is at (i, ai) and (i, 0). 
 *  Find two lines, which together with x-axis forms a container, such 
 *  that the container contains the most water.

Note: You may not slant the container
 */
public class ContainerMax {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2)
            return 0;
        int leftIdx = 0;
        int rightIdx = height.length -1;
        
        int max = 0;
        
        while (leftIdx < rightIdx) {
            int left = height[leftIdx];
            int right = height[rightIdx];
            max = Math.max(max, Math.min(left, right)*(rightIdx - leftIdx));
            if (left < right) {
                leftIdx++;
            } else {
                rightIdx--;
            }
        }
        return max;
    }
}
