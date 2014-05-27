/*
 * A robot is located at the top-left corner of a
 *  m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any
point in time. The robot is trying to reach the
 bottom-right corner of the grid (marked 'Finish'
  in the diagram below).

How many possible unique paths are there?
 */

public class UniquePath {
    public int uniquePaths_oo(int m, int n) {
        if (m == 0 || n == 0)
            return 1;
        return uniquePaths(m-1, n) + uniquePaths(m,n-1);
        
    }
    
    public int uniquePaths(int m, int n) {
        int array[] = new int[n];
        int i, j;
        for (i = 0; i < n; i++)
            array[i] = 1;

        for (j = m-1; j > 0; j--) {
            for (i = n-2; i >= 0; i--) {
                array[i]  += array[i+1]; 
            }
        }
        
        return array[0];
    }
    
    public static void main(String arg[]){
        UniquePath u = new UniquePath();
        System.out.println(u.uniquePaths(2, 2));
    }
}
