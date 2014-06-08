/*
 * Given a string, determine if it is a palindrome, considering only 
 * alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good 
question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {
    
    public boolean isNotChar(char c) {
        
        if (c >= 'a' && c <='z')
            return false;
        if (c >= '0' && c <= '9')
            return false;
        return true;
        
    }
    
    public boolean isPalindrome(String s) {
        if (s == null)
            return false;
        if (s.length() == 0)
            return true;
        
        int left = 0;
        int right = s.length() - 1;
        
        s = s.toLowerCase();
        
        while (left < right) {
            while (left < right && isNotChar(s.charAt(left)))
                left++;
            while (left < right && isNotChar(s.charAt(right)))
                right--;
            
            if (s.charAt(left) !=  s.charAt(right))
                return false;
            left++;
            right--;
        }
        
        return true;
        
    }
}
