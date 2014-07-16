/*
 * Given n, generate all structurally unique BST's (binary search trees) 
 * that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */

import java.util.*;
public class UniqueBSTII {
    
    public ArrayList<TreeNode> genBST(int start, int end) {
        ArrayList<TreeNode> out = new ArrayList<TreeNode>();
        
        if (start > end) {
            out.add(null);
            return out;
        }
        
        for (int i = start; i <= end; i++) {
            
            ArrayList<TreeNode> leftComb = genBST(start, i-1);
            ArrayList<TreeNode> rightComb = genBST(i+1, end);
            
            for (TreeNode left:leftComb) {
                for (TreeNode right:rightComb) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    out.add(root);
                }
            }
            
        }
        
        return out;
    }
    
    public ArrayList<TreeNode> generateTrees(int n) {
        return  genBST(1, n);
    }
}
