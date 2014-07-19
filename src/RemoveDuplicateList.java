/*
 * Given a sorted linked list, delete all duplicates such that each
 * element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicateList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        
        ListNode cur = head;
        ListNode rdPtr = head.next;
        
        while (rdPtr != null) {
            if (cur.val != rdPtr.val) {
                cur.next = rdPtr;
                cur = cur.next;
            } 
            rdPtr = rdPtr.next;
        }
        
        cur.next = rdPtr;
        return head;
        
    }
}
