/*
 * '?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
 */
public class WildcardMatch {
    public boolean isMatch(String s, String p) {
        if (p == null)
            return true;
        if (s == null)
            return false;
        
        int sLen = s.length();
        int pLen = p.length();
        int sIdx = 0;
        int pIdx = 0;
        int lastStar = -1;
        int starIdx = -1;
        
        while (sIdx < sLen) {
            char key;
            if (pIdx < pLen)
                key = p.charAt(pIdx);
            else
                key = '\0';
            if (s.charAt(sIdx) == key || key == '?') {
                sIdx++;
                pIdx++;
            } else if (key == '*') {
                starIdx = pIdx;
                lastStar = sIdx;
                pIdx++;   
            } else if (starIdx != -1){
                sIdx = (++lastStar);
                pIdx = starIdx+1;
                
            } else
                return false;
            
        }
        
        while (pIdx < pLen) {
            if (p.charAt(pIdx) != '*')
                return false;
            pIdx++;
        }
        
        return true;
        
    }
    
    public static void main(String[] args) {
        WildcardMatch w = new WildcardMatch();

        System.out.println(w.isMatch("aa", "a"));
        System.out.println(w.isMatch("aa", "aa"));
        System.out.println(w.isMatch("aaa", "aa"));
        System.out.println(w.isMatch("aa", "*"));
        System.out.println(w.isMatch("aa", "a*"));
        System.out.println(w.isMatch("ab", "?*"));
        System.out.println(w.isMatch("aab", "c*a*b"));
        System.out.println(w.isMatch("b", "*a*"));
        System.out.println(w.isMatch("", "*"));
        System.out.println(w.isMatch("a", ""));
        System.out.println(w.isMatch("b", "*?*?"));
        System.out.println(w.isMatch("a", "*a"));
        System.out.println(w.isMatch("ab", "*a"));
        System.out.println(w.isMatch("bbaabb", "b??a"));
    }
}
