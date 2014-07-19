/*
 * Given a sorted linked list, delete all nodes that have 
 * duplicate numbers, leaving only distinct numbers from 
 * the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
 */
public class RemoveDuplicateListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode prev = fake;
        ListNode cur = head;
        ListNode rdPtr = head.next;
        
        while (rdPtr != null) {
            while (rdPtr != null && rdPtr.val == cur.val)
                rdPtr = rdPtr.next;
            if (cur.next != rdPtr) {
                prev.next = rdPtr;
            } else {
                prev = cur;
            }
            
            if (rdPtr != null ) {
               
                cur = rdPtr;
                rdPtr = rdPtr.next;
                
            }
        }
        
        return fake.next;
        
    }
    
    
    public static void main(String args[]) {
        int a1[] = {1, 2, 2};
        int a2[] = {1, 1, 2, 2};
        ListNode t1 = ListNode.initFromArray(a1);
        ListNode t2 = ListNode.initFromArray(a2);
        RemoveDuplicateListII r = new RemoveDuplicateListII();
        ListNode.printListNode(r.deleteDuplicates(t1));
        ListNode.printListNode(r.deleteDuplicates(t2));
    }
}
