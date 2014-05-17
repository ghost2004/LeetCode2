/*
 * Given a string containing just the characters '(', ')',
 *  '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}"
 are all valid but "(]" and "([)]" are not.
 */
import java.util.Stack;
public class ValidParentheses {
    public boolean isValid(String s) {

        if (s == null || s.length() == 0)
            return true;
        Stack<Character>  stack= new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
            case '(':
                stack.push('(');
                break;
            case '[':
                stack.push('[');
                break;
            case '{':
                stack.push('{');
                break;
            case ')':
                if (stack.size() == 0 || stack.pop() != '(')
                    return false;
                break;
            case ']':
                if (stack.size() == 0 || stack.pop() != '[')
                    return false;
                break;
            case '}':
                if (stack.size() == 0 || stack.pop() != '{')
                    return false;
                break;
                
            }
        }
        
        return (stack.size()==0);
    }
    
    public static void main (String args[]) {
        ValidParentheses v = new ValidParentheses();
        System.out.println(v.isValid("()"));
    }
}
