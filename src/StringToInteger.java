/*
 * Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a 
challenge, please do not see below and ask yourself what are the 
possible input cases.

Notes: It is intended for this problem to be specified vaguely 
(ie, no given input specs). You are responsible to gather all the 
input requirements up front.

spoilers alert... click to show requirements for atoi.

Requirements for atoi:
The function first discards as many whitespace characters as necessary
 until the first non-whitespace character is found. Then, starting 
 from this character, takes an optional initial plus or minus sign 
 followed by as many numerical digits as possible, and interprets them
  as a numerical value.

The string can contain additional characters after those that form
 the integral number, which are ignored and have no effect on the 
 behavior of this function.

If the first sequence of non-whitespace characters in str is not a
 valid integral number, or if no such sequence exists because either 
 str is empty or it contains only whitespace characters, no
  conversion is performed.

If no valid conversion could be performed, a zero value is returned.
 If the correct value is out of the range of representable values, 
 INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */
public class StringToInteger {
    public int atoi(String str) {
        if (str == null || str.length() == 0)
            return 0;
        double out = 0;
        int idx = 0;
        int sign = 1;
        boolean signFlag = false;
        boolean blankFlag = true;
        
       for (idx = 0; idx < str.length(); idx++) {
            char c = str.charAt(idx);
            if (c == ' ') {
                if (blankFlag) {
                    continue;
                } else
                    return (int)out*sign;
            } else if (c == '+' || c == '-') {
                if (signFlag)
                    return (int)out*sign;
                signFlag = true;
                if (c == '-')
                    sign = -1;
                blankFlag = false;
                
            } else if ( c >= '0' && c <= '9') {
                out = out*10 + (c-'0');
                
                if (out > 2147483647 || out <= -2147483648)
                    if (sign == 1)
                        return 2147483647;
                    else 
                        return -2147483648;
                blankFlag = false;
            } else
                return (int)out*sign;
            
        }
        return (int)out*sign;
        
    }
    
    public static void main(String args[]) {
        StringToInteger n = new StringToInteger();
        System.out.println(n.atoi("2147483648"));
        System.out.println(n.atoi("-2147483647"));
        System.out.println(n.atoi("-2147483649"));
    }
}
