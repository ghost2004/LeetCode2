/*
 * Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. 
How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0
 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
 */
public class UniquePathII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid[0].length == 0)
            return 0;
        int i, j;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int status[] = new int[n];
        for (i = 0; i < n;i++)
            status[i] = 0;
        status[n-1] = 1;
        for (j = m-1; j >= 0; j--) {
            if (obstacleGrid[j][n-1] == 0 && status[n-1] == 1)
                status[n-1] = 1;
            else
                status[n-1] = 0;
            for (i = n-2; i >= 0; i--) {
                if (obstacleGrid[j][i] == 0)
                    status[i] += status[i+1];
                else 
                    status[i] = 0;
            }
        }
        
        return status[0];
    }
    
    public static void main(String args[]) {
        UniquePathII u = new UniquePathII();
        int t1[][] = {{0},{1}};
        System.out.println(u.uniquePathsWithObstacles(t1));
    }
}
