/*
 * Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along 
the shortest path from the root node down to 
the nearest leaf node.
 */
public class MinDepthBinTree {
    
    public int minD(TreeNode node) {
        if (node.left == null && node.right == null)
            return 1;
        int min = 0;
        if (node.left != null)
            min = minD(node.left);
        if (node.right != null)
            if (min == 0)
                min = minD(node.right);
            else
                min = Math.min(min, minD(node.right));
        
        return min+1;
     
    }
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        return minD(root) ;
        
    }

}
