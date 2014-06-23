/*
 * Given a string s and a dictionary of words dict, determine if s can 
 * be segmented into a space-separated sequence of one or more 
 * dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
 */
import java.util.*;
public class WordBreak {
    // Running time exceed 
    public boolean wordBreak1(String s, Set<String> dict) {
        if (s == null || s.length() == 0) 
            return false;
        if (dict.contains(s))
            return true;
        int length = s.length();
        for (int i = 0;  i < length; i++) {
            if (dict.contains(s.substring(0, i+1)) &&  wordBreak1(s.substring(i+1), dict) ) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) 
            return false;
        int length = s.length();
        boolean flags[] = new boolean[length+1];
        flags[0] = true;
        
        for (int i = 1; i <= length;i++) {
            for (int j = 0; j < i; j++) {
                if (flags[j] && dict.contains(s.substring(j, i))) {
                    flags[i] = true;
                    break;
                }
            }
        }
        
        return flags[length];
    }
    
    
}
