/*
 * Given a string S, find the longest palindromic 
 * substring in S. You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 */
public class LongPalSubStr {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return s;

        int max = 1;
        int length = s.length();
        // Matrix to store all palindromic state
        // flag[i][j] = true, means s.substring(i,j-1) is palindromic string
        boolean flags[][] = new  boolean[length][length];
        
        // Position of max palindromic
        int max_start = 0;
        int max_end = 0;
        
        // All single characters are palindromic
        for (int i = 0; i < length; i++) {
            flags[i][i] = true;
        }
        
        // Check every 2 characters in sequence 
        for (int i = 1; i < length; i++) {
            if (s.charAt(i-1) == s.charAt(i)) {
                flags[i-1][i] = true;
                max_start = i-1;
                max_end = i;
                max = 2;
            }
        }
        
        // Scan the whole string
        for (int len = 3; len <= length; len++) {
            for (int j = 0; j <= length-len; j++) {
                int end = j+len-1;
                if (s.charAt(j) == s.charAt(end) && flags[j+1][end-1]) {
                    flags[j][end] = true;
                    if (len > max) {
                        max = len;
                        max_start = j;
                        max_end = end;
                    }
                }
            }
        }
        
        return s.substring(max_start, max_end+1);
    }

}
