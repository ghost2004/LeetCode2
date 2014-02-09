/*
 * There are two sorted arrays A and B of size m and n respectively.
 *  Find the median of the two sorted arrays.
 *  The overall run time complexity should be O(log (m+n)).
 */
public class MedianTwoSortedArray {
    
    public double findKth(int A[], int sa, int m, int B[], int sb, int n, int k) {
        if (m <= 0)
            return B[sb+k-1];
        if (n <= 0)
            return A[sa+k-1];
        if (k == 1) {
            return Math.min(A[sa], B[sb]);
        }
        if (m > n)
            return findKth(B, sb, n, A, sa, m, k);
        int pa = Math.min(k/2, m);
        int pb = k - pa;

        if (A[sa+pa-1] < B[sb+pb-1])
            return findKth(A, sa+pa, m-pa, B, sb, n, k-pa);
        else if (A[sa+pa-1] > B[sb+pb-1])
            return findKth(A, sa, m, B, sb+pb, n-pb, k-pb);
        else 
            return A[sa+pa-1];
    }
    
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        
        int k = (m + n)/2;
        
        if ((m + n) % 2 == 1) {
            return findKth(A, 0, m, B, 0, n, k+1);
        } 
        
        return (findKth(A, 0, m, B, 0, n, k) + findKth(A, 0, m, B, 0, n, k+1))/2;
    }

    
    public  static void main(String[] args) {
        
        int[][] A = {{},{1},{2},{},{1,1},{2,3,4},{1,2,3}};
        int[][] B = {{1},{1},{1},{1,2,3,4},{1,2},{1},{4,5,6}};
        MedianTwoSortedArray c = new MedianTwoSortedArray();
        for (int i = 0; i < A.length; i++){
            System.out.println(c.findMedianSortedArrays(A[i], B[i]));
        }
    }
    
}
