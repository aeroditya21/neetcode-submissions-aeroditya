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
    public List<Integer> rightSideView(TreeNode root) {
        List<TreeNode> levelQ = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            levelQ.add(root);
        }
        
        while(!levelQ.isEmpty()) {
            //levelQ.forEach(x -> System.out.print(x.val + ","));
            TreeNode last = levelQ.getLast();
            res.add(last.val);
            //System.out.println("Adding " + last.val + " to result!");
            int size = levelQ.size();
            for (int i=0; i<size; i++) {
                TreeNode next = levelQ.removeFirst();
                //System.out.println("Removing " + next.val);
                if (next.left != null) {
                    levelQ.add(next.left);
                }
                if (next.right != null) {
                    levelQ.add(next.right);
                }
            }
            
        }
        return res;
    }
}
