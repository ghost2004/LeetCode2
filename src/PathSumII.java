/*
 * Given a binary tree and a sum, find all root-to-leaf
 *  paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
 */
import java.util.*;
public class PathSumII {
    ArrayList<ArrayList<Integer>> out;
    public void pathSearch(ArrayList<Integer> path , TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                ArrayList<Integer> t = new ArrayList<Integer>(path);
                t.add(sum);
                out.add(t);
            }
            return;    
        }
        int size = path.size();
        path.add(root.val);
        if (root.left != null) {
            pathSearch(path, root.left, sum - root.val);
        }
        if (root.right != null) {
            pathSearch(path, root.right, sum - root.val);
        }
        path.remove(size);
    }
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        out = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return out;
        ArrayList<Integer> path = new ArrayList<Integer>();
        pathSearch(path, root, sum);
        return out;
    }
}
