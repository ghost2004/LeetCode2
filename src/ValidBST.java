/*
 * Given a binary tree, determine if it is a valid binary 
 * search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys 
less than the node's key.
The right subtree of a node contains only nodes with keys 
greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */
public class ValidBST {
    public boolean validBST(TreeNode node, int pMin, int pMax) {
        if (node == null)
            return true;
        if (node.val <= pMin || node.val >= pMax)
            return false;
        return (validBST(node.left, pMin, node.val) && validBST(node.right, node.val, pMax));
        
        
    }
    public boolean isValidBST(TreeNode root) {
        
        return validBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
    }
}
