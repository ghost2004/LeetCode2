import javax.swing.text.StyleContext.SmallAttributeSet;

/*
 * 
'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
 */
public class RegExpMatch {
    
    public boolean isMatch(String s, String p) {
        if (p.length() == 0)
            return s.length() == 0;
        
        if (p.length() == 1 || p.charAt(1) != '*') {
            // next character is not *
            if (s.length() < 1 || (p.charAt(0) != s.charAt(0) && p.charAt(0) != '.'))
                return false;
            return isMatch(s.substring(1), p.substring(1));
        }
        
        // next character is *
        if (isMatch(s, p.substring(2)))
            return true;
        
        int i = 0;
        while ( i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
            if (isMatch(s.substring(i+1), p.substring(2)))
                return true;
            i++;
        }
        
        return isMatch(s.substring(i),p.substring(2));
    }
    
    public static void main(String args[]) {
        RegExpMatch exp = new RegExpMatch();
        System.out.println(exp.isMatch("aaba", "ab*a*c*a"));
        System.out.println(exp.isMatch("b", "b.bc"));
        System.out.println(exp.isMatch("", "..ac"));
        System.out.println(exp.isMatch("aa", "a"));
        System.out.println(exp.isMatch("ab", ".*c"));
        System.out.println(exp.isMatch("a", "ab*"));
        
        
    }
}
