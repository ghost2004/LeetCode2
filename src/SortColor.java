/*
 * Given an array with n objects colored red, white or blue, sort them 
 * so that objects of the same color are adjacent, with the colors in
 *  the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red,
 white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then 
overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
 */
public class SortColor {
    // implemented by counting sort
    public void sortColors(int[] A) {
        int red = 0;
        int white = 0;

        int i;
        for (i = 0; i < A.length; i++) {
            switch (A[i]) {
            case 0:
                red++;
                break;
            case 1:
                white++;
                break;
               
            }
        }
        for (i = 0; i < A.length; i++) {
            if (i < red)
                A[i] = 0;
            else if (i >= red && i < white+red)
                A[i] = 1;
            else
                A[i] = 2;
        }
        
    }
    // Implemented for one pass 
    public void sortColors2(int[] A) {
        int redIdx = 0;
        int blueIdx = A.length - 1;
        
        int idx = 0;
        
        while (idx <= blueIdx) {
            if (A[idx] == 0 && idx > redIdx) {
                A[idx] = A[redIdx];
                A[redIdx]  = 0;
                redIdx++;
            } else if (A[idx] == 2) {
                A[idx] = A[blueIdx];
                A[blueIdx] = 2;
                blueIdx--;
            } else {
                idx++;
            }
        }
        
        
    }
    
}
