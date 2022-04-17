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
    
    private TreeNode ans;
    public void helper(TreeNode root){
        
        if( root == null ) return;
        
        helper( root.left );
        
        ans.right = new TreeNode(root.val);
        ans = ans.right;
        
        helper( root.right );
        
    }
    
    public TreeNode increasingBST(TreeNode root) {
        
        TreeNode ANS = new TreeNode(0);
        ans = ANS;
        
        helper(root);
        return ANS.right;
    }
}