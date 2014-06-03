/*
 * Reverse a linked list from position m to n.
 *  Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
 */
public class ReverseLinkListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n)
            return head;
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode p1 = head;
        ListNode preP1 = fake;
        int step = 1;
        while (step < m) {
            preP1 = p1;
            p1 = p1.next;
            step++;
        }
        ListNode cur = p1;
        ListNode next = p1.next;
        
        
        while (step < n) {
            ListNode tmp = next.next;
            next.next = cur;
            cur = next;
            next = tmp;
            step++;
        }
        preP1.next = cur;
        p1.next = next;
        
        
        
        return fake.next;
    }
}
