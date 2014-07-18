/*
 * Given a sorted array, remove the duplicates in place such 
 * that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place
 with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].
 */
public class RemoveDuplicateArray {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        int wrtIdx = 1;
        int prev = A[0];
        
        int rdIdx = 1;
        
        for (rdIdx = 1; rdIdx < A.length; rdIdx++) {
            if (rdIdx != wrtIdx) {
                A[wrtIdx] = A[rdIdx];
            }
            
            if (A[rdIdx] != prev) {
                wrtIdx++;
                prev = A[rdIdx];
            }
            
            
        }
        
        return wrtIdx;
    }
    
    public int removeDuplicatesV2(int[] A) {
        if (A == null || A.length == 0)
            return 0;

        int cur = 0;
        for (int rdIdx = 1; rdIdx < A.length; rdIdx++) {
            if (A[rdIdx] == A[cur])
                continue;
            
            A[++cur] = A[rdIdx]; 
        }
            
        return cur+1;
    }


}
