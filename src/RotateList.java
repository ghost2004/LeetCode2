/*
 * Given a list, rotate the list to the right by k places, 
 * where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        
        if (head == null || head.next == null)
            return head;
        
        
        ListNode tail = head;
        int length = 1;
        
        // get the length of linked list
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        
        // make a circle list
        tail.next = head;
        
        ListNode newHead = head;
        ListNode prev = null;
        int step = length - n%length;
        for (int i = 0; i < step; i++){
            prev = newHead;
            newHead = newHead.next;
        }
        // break circle here
        prev.next = null;
        return newHead;

    }
}
