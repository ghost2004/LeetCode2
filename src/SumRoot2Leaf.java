/*
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path 
 * could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
 */
public class SumRoot2Leaf {
    public int sumLeaf(TreeNode node, int parent) {
        if (node == null)
            return parent;
        if (node.left == null)
            return sumLeaf(node.right, parent*10+node.val);
        if (node.right == null)
            return sumLeaf(node.left, parent*10+node.val);
        
        return sumLeaf(node.right, parent*10+node.val) + 
                sumLeaf(node.left, parent*10+node.val);
        
    }
    public int sumNumbers(TreeNode root) {
        return sumLeaf(root, 0) ;
    }

}
