/*
 * Given a linked list, swap every two adjacent nodes and 
 * return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not 
modify the values in the list, only nodes itself can be changed.
 */
public class SwapInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode f = new ListNode(1);
        if (head == null)
            return head;
        f.next = head;
        ListNode cur = head;
        ListNode prev = f;
        ListNode next = head.next;
        
        while (next != null) {
            ListNode n = next.next;
            prev.next = next;
            next.next = cur;
            cur.next = n;
            prev = cur;
            cur = n;
            if (n != null) 
                next = n.next;
            else
                next = null;
                
        }
        
        return f.next;
    }
}
