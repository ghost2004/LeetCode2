/*
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class ReorderList {
    
    public void resort(ListNode head, ListNode preTail, ListNode tail, int length) {
        if (length <= 2)
            return;
        ListNode next = head.next;
        head.next = tail;
        tail.next = next;
        preTail.next = null;
        ListNode pre = null;
        ListNode nextHead = next;
        while (next.next != null) {
            pre = next;
            next = next.next;
        }
        resort(nextHead, pre, next, length - 2);
    }
    public void reorderListV1(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode tail = head;
        ListNode preTail = null;
        int length = 1;
        while (tail.next != null) {
            preTail = tail;
            tail = tail.next;
            length++;
        }
        resort(head, preTail, tail, length);
        
    }
    
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        
        // Split the linked list into 2 part with slow/fast pointers
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next !=null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode list2 = slow.next;
        slow.next = null;
        
        // reverse the second part
        ListNode prev = null;
        ListNode cur = list2;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        list2 = prev;
        
        // merge two linked list
        ListNode list1 = head;
        while (list1 != null && list2 != null) {
            ListNode next1 = list1.next;
            ListNode next2 = list2.next;
            list1.next = list2;
            list2.next = next1;
            list2 = next2;
            list1 = next1;
        }
               
    }
    public static void main(String[] arg) {
        int[] array1 = {2, 1}; 
        int[] array2 = {1, 2, 3, 4}; 
        int[] array3 = {1, 2, 3, 4, 5}; 
        ListNode t1 = ListNode.initFromArray(array1);
        ListNode t2 = ListNode.initFromArray(array2);
        ListNode t3 = ListNode.initFromArray(array3);
        ReorderList r = new ReorderList();
        r.reorderList(t1);
        ListNode.printListNode(t1);
        r.reorderList(t2);
        ListNode.printListNode(t2);
        r.reorderList(t3);
        ListNode.printListNode(t3);
    }
}
