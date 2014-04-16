/*
 * Given two sorted integer arrays A and B, merge B into A
 *  as one sorted array.

Note:
You may assume that A has enough space (size that is greater or equal to m + n) 
to hold additional elements from B. The number of elements initialized in A and
 B are m and n respectively.
 */
public class MergeSortArray {
    public void merge(int A[], int m, int B[], int n) {
        int pA = m-1;
        int pB = n-1;
        int p = m+n-1;
        
        while (pA >=0 && pB >= 0) {
            if (A[pA] >= B[pB]) {
                A[p] = A[pA];
                pA--;
            } else {
                A[p] = B[pB];
                pB--;
            }
            p--;
        }
        
        while (pB >= 0) {
            A[p] = B[pB];
            pB--;
            p--;
        }
    }

}
