/*
 * A linked list is given such that each node contains 
 * an additional random pointer which could point to 
 * any node in the list or null.

Return a deep copy of the list.
 */
public class CopyRandList {
    public class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
        
    };
    
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        RandomListNode newHead = null;
        RandomListNode ptr = head;
        RandomListNode copy = null;
        
        // double the link node 
        while (ptr != null) {
            RandomListNode next = ptr.next;
            RandomListNode newNode = new RandomListNode(ptr.label);
            ptr.next = newNode;
            newNode.next = next;
            ptr = next;
        }
        
        // copy the random pointer
        ptr = head;
        while (ptr != null) {
            copy = ptr.next;
            if (ptr.random != null)     //mark wrong
                copy.random = ptr.random.next;
            else
                copy.random = null;
            ptr = copy.next;
        }
        
        // split the list into half
        ptr = head;
        newHead = ptr.next;
        copy = newHead;
        
        while (ptr != null) {
            
            ptr.next = copy.next;
            if (copy.next != null)
                copy.next = copy.next.next;
            ptr = ptr.next;
            copy = copy.next;
            
            /*
            RandomListNode temp = ptr.next;
            ptr.next = temp.next;
            if (temp.next != null)   //mark wrong
                temp.next = temp.next.next;
            ptr = ptr.next;
            */
        }
        
        return newHead;
        
    }

}
