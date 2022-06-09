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
    
    int sum = 0;
    
    private void helper(TreeNode root, int ans){
        
        if(root == null) return;
        
        ans = ans*10 + root.val;
        
        
        if( root.left == null && root.right == null ){
            sum += ans;
        }
        
        helper(root.left, ans);
        helper(root.right, ans);
        
    }
    
    public int sumNumbers(TreeNode root) {
        
        helper(root, 0);
        return sum;
    }
}