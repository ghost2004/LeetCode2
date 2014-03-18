/*
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {
    
    public ListNode mergeList(ListNode left, ListNode right) {
        ListNode fakeHead = new ListNode(0);
        ListNode ptr = fakeHead;
        ListNode pLeft = left;
        ListNode pRight = right;
        while (pLeft != null || pRight !=null) {
            if (pLeft == null) {
                ptr.next = pRight;
                break;
            } else if (pRight == null) {
                ptr.next = pLeft;
                break;
            }
            
            if (pLeft.val <= pRight.val) {
                ptr.next = pLeft;
                ptr = ptr.next;
                pLeft = pLeft.next;
                ptr.next = null;
            } else {
                ptr.next = pRight;
                ptr = ptr.next;
                pRight = pRight.next;
                ptr.next = null;
            }
                
        }
            
        return fakeHead.next;
    }
    
    public ListNode mergeSortList(ListNode head, int length) {
        if (length <= 1)
            return head;
        ListNode start2 = head;
        ListNode end1 = null;
        int cnt = 0;
        int left = length/2;
        while (cnt < left) {
            end1 = start2;
            start2 = start2.next;
            cnt++;
        }
        end1.next = null;
        ListNode start1 = mergeSortList(head, left);
        start2 = mergeSortList(start2, length - left);
        return mergeList(start1, start2);
        
    }
    
    public ListNode sortList(ListNode head) {
        
        if (head == null || head.next == null)
            return head;
        int length = 0;
        ListNode ptr = head;
        
        while (ptr != null) {
            length ++;
            ptr = ptr.next;
        }
        
        return mergeSortList(head, length);
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
        SortList sort = new SortList();
   
        ListNode.printListNode(sort.sortList(t1));
        ListNode.printListNode(sort.sortList(t2));
        ListNode.printListNode(sort.sortList(t3));
        ListNode.printListNode(sort.sortList(t4));
    }
    

}
