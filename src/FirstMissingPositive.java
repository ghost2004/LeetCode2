/*
 * Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        int length = A.length;
        
        if (A == null || A.length == 0)
            return 1;
        
        int i = 0;
        
        while (i < length) {
            if (A[i] > 0 && A[i] < A.length && A[i] != i+1 && A[A[i]-1]!=A[i])  {
                int tmp = A[A[i]-1];
                A[A[i]-1] = A[i];
                A[i] = tmp;
            }
            else 
                i++;
        }
        
        for (i = 0; i < A.length;i++)
        {
            if (A[i] != i+1)
                return i+1;
        }
        
        return length+1;
        
    }
}
