/*
 * Determine whether an integer is a palindrome.
 *  Do this without extra space.


Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to
 string, note the restriction of using extra space.

You could also try reversing an integer. However, 
if you have solved the problem "Reverse Integer", 
you know that the reversed integer might overflow.
 How would you handle such case?

There is a more generic way of solving this problem.
 */
public class PalindromeNum {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int y = 0;
        int a = x;
        while (a >= 10) {
            y = 10*y + a%10;
            a = a/10;
        }
        y = 10*y + a;
        return (x == y);
    }
    
    public static void main(String args[]) {
        PalindromeNum p = new PalindromeNum();
        System.out.println(p.isPalindrome(10));
    }
}
