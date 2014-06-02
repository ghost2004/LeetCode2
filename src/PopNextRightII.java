/*
 * Follow up for problem "Populating Next Right Pointers in 
 * Each Node".

What if the given tree could be any binary tree? Would your 
previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 */
public class PopNextRightII {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        TreeLinkNode cur = root.next;
        TreeLinkNode p = null;
        while (cur != null) {
            if (cur.next.left != null) {
                p = cur.next.left;
                break;
            }
            
            if (cur.next.right != null) {
                p = cur.next.right;
                break;
            }
            cur = cur.next;
        }
        
        if (root.right != null) {
            root.right.next = p;
        }
        
        if (root.left != null) {
            root.left = root.right == null ? p: root.right;
        }
        
        connect(root.right);
        connect(root.left);
        
    }

    public void connect2(TreeLinkNode root) {

        TreeLinkNode cur = root;
        TreeLinkNode prev = null;
        TreeLinkNode nextHead = null;
        
        while (cur != null) {
            if (cur.left != null) {
                if (prev == null) {
                    prev = cur.left;
                    nextHead = cur.left;
                } else {
                    prev.next = cur.left;
                    prev = cur.left;
                }
            }
            
            if (cur.right != null) {
                if (prev == null) {
                    prev = cur.right;
                    nextHead = cur.right;
                } else {
                    prev.next = cur.right;
                    prev = cur.right;
                }
            }
            cur = cur.next; 
            if (cur == null) {
                cur = nextHead;
                prev = null;
                nextHead = null;
                        
            }
        }
    }
}
