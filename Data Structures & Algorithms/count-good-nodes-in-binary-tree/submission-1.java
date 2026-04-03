/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        int res = 0;
        int max = root.val;
        int left=0, right=0;
        if (root.left != null) {
            left = goodNodes(root.left, max);
        }
        if (root.right != null) {
            right = goodNodes(root.right, max);
        }
        return 1+left+right;
    }

    int goodNodes(TreeNode root, int max) {
        int good=0;
        int left=0, right=0;
        if (root.val >= max) {
            max = root.val;
            good = 1;
        }
        if (root.left != null) {
            left = goodNodes(root.left, max);
        }
        if (root.right != null) {
            right = goodNodes(root.right, max);
        }
        return good + left + right;
    }
}

/*
         3
        3  null
      4  2
*/

