/*
 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
click to show hints.

Hints:
If you notice carefully in the flattened tree, each node's right child
 points to the next node of a pre-order traversal.
 */
public class FlattenBinaryTree {
    
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        if (root.left == null) {
            flatten(root.right);
            return;
        }
            
        TreeNode r = root.left;
        while (r.right != null) {
            r = r.right;
        }
        /*
        while (r.right != null || r.left!= null) {
            if (r.right != null)
                r = r.right;
            else
                r = r.left;
        }
        */
            
        r.right = root.right;
        
        root.right = root.left;
        root.left = null;
        flatten(root.right);
        
    }
    
    public static void main(String args[]) {
        TreeNode t = TreeNode.deserialize("1,2,3,#");
        FlattenBinaryTree f = new FlattenBinaryTree();
        
        f.flatten(t);
        System.out.println(t.serialize());
    }

}
