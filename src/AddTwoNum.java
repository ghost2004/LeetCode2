/*
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain 
 * a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */
public class AddTwoNum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode out = new ListNode(0);
        ListNode cur = out;
        ListNode left = l1;
        ListNode right = l2;
        int carry = 0;
        int leftD, rightD, sum;
        
        while (left != null || right != null) {
            if (left != null) {
                leftD = left.val;
                left = left.next;
            } else
                leftD = 0;
            
            if (right != null) {
                rightD = right.val;
                right = right.next;
            } else
                rightD = 0;
            
            
            sum = cur.val + leftD + rightD;
            
            cur.val = sum % 10;
            carry = sum / 10;

            if (left != null || right != null || carry != 0) {
                cur.next = new ListNode(carry);
                cur = cur.next;
            }
            
        }
        
        
        return out;
    }
}
