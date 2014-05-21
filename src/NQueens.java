/*
 * Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement,
 where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
 */
import java.util.ArrayList;
public class NQueens {
    
    public void prtResult(ArrayList<String[]> out, int s[]) {
        String array[] = new String[s.length];
        char template[] = new char[s.length];
        for (int i = 0; i < s.length; i++)
            template[i]= '.';
        for (int i = 0; i < s.length; i++) {
            template[s[i]] = 'Q';
            array[i] = new String(template);
            template[s[i]] = '.';
            
        }
        out.add(array);
    }
    
    public boolean isValid(int s[], int l) {
        for (int i = 0; i < l;i++) {
            if (s[l] == s[i] || Math.abs(s[l] -s[i]) == l -i)
                return false;
        }
        return true;
    }
    
    public void nQueens(ArrayList<String[]> out, int s[], int n) {
        int idx = s.length - n;
        for (int i = 0; i < s.length; i++) {
            s[idx] = i;
            if (isValid(s, idx)) {
                if (n == 1)
                    prtResult(out, s);
                else 
                    nQueens(out, s, n-1);
            }
        }
        
    }
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> out = new ArrayList<String[]>();
        if (n == 0)
            return out;
        
        int s[] = new int[n];
        nQueens(out,s,n);
        
        return out;
    }
}
