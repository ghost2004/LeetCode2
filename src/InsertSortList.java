/*
 * Sort a linked list using insertion sort.
 */
public class InsertSortList {
    public ListNode insertionSortList(ListNode head) {
        
        if (head == null || head.next == null)
            return head;
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode cur = head;
        ListNode next = head.next;
        ListNode last = fake.next;
        
        while (next != null) {
            cur = next;
            next = next.next;
            if (cur.val >= last.val) {
                last = last.next;
            } else {
                ListNode ptr = fake.next;
                ListNode prev = fake;
                while (ptr != cur) {
                    if (cur.val < ptr.val) {
                        prev.next = cur;
                        cur.next = ptr;
                       
                        break;
                    }
                    prev = prev.next;
                    ptr = ptr.next;
                }
                last.next = next;
                
            }
        }

        return fake.next;
    }
    
    public static void main(String[] arg) {
        int[] array1 = {2, 1}; 
        int[] array2 = {3, 4, 1};
        int[] array3 = {1, 1};
        int[] array4 = {3, 2, 1};
        ListNode t1 = ListNode.initFromArray(array1);
        ListNode t2 = ListNode.initFromArray(array2);
        ListNode t3 = ListNode.initFromArray(array3);
        ListNode t4 = ListNode.initFromArray(array4);
        InsertSortList insert = new InsertSortList();
   
        ListNode.printListNode(insert.insertionSortList(t1));
        ListNode.printListNode(insert.insertionSortList(t2));
        ListNode.printListNode(insert.insertionSortList(t3));
        ListNode.printListNode(insert.insertionSortList(t4));
    }

}
