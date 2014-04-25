/*
 * Interview questions from Facebook
 * Find next large value in BST tree
 */
public class AAFacebookNextLargeInBST {
    
    private int searchNode(TreeNode node, int key, int candidate) {
        if (node.val == key) {
            // find the key        
            if (node.right == null)
                return candidate;

            TreeNode p = node.right;
            while (p.left != null) {
                p = p.left;
            }
            //System.out.println("pval:"+p.val);
            return Math.min(p.val, candidate);
        } else if (node.val > key) {
            candidate = Math.min(candidate, node.val);
            if (node.left == null) 
                return candidate;
            return searchNode(node.left, key, candidate);
        } else {
            // node.val < key
            if (node.right == null)
                return candidate;
            return searchNode(node.right, key, candidate);
        }
    }
    
    
    public int findNextLarge(TreeNode root, int key) {
        if (root == null)
            return Integer.MAX_VALUE;
        return searchNode(root, key, Integer.MAX_VALUE);
    }
    
    public static void main(String args[]) {
        AAFacebookNextLargeInBST s =new AAFacebookNextLargeInBST();
        TreeNode t = TreeNode.deserialize("30,20,10,#,#,25,24,23,#,#,#,27,#,#,40,35,31,#,#,37,#,#,55");
        System.out.println(s.findNextLarge(t, 10));
        System.out.println(s.findNextLarge(t, 20));
        System.out.println(s.findNextLarge(t, 25));
        System.out.println(s.findNextLarge(t, 27));
        System.out.println(s.findNextLarge(t, 30));
        System.out.println(s.findNextLarge(t, 31));
        System.out.println(s.findNextLarge(t, 35));
        System.out.println(s.findNextLarge(t, 40));
        System.out.println(s.findNextLarge(t, 55));
        
    }

}
