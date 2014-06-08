/*
 * Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. 
Could you devise a constant space solution?

 */
public class RecoverBST {
    int idx;
    TreeNode p[];
    TreeNode prev;
    public void search(TreeNode node) {
        if (node == null)
            return;
        search(node.left);
        if (prev != null && prev.val > node.val ) {
            if (p[0] == null) {
                p[0] = prev;
                p[1] = node;
            } else {
                p[1] = node;
            }
        }
        prev = node;
        search(node.right);
    }
    public void recoverTree(TreeNode root) {
        p = new TreeNode[2];
        idx = 0;
        prev = null;
        search(root);
        int tmp = p[0].val;
        p[0].val = p[1].val;
        p[1].val = tmp;
        
    }
}
