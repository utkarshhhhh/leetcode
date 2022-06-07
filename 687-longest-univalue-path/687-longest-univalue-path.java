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
    
    int ans  = 0;
    
    public int helper(TreeNode root, int val){
        
        if( root == null || root.val != val){
            return 0;
        }
        int left  = helper(root.left, val);
        int right = helper(root.right, val);
        ans = Math.max(left+right+1, ans);
        return Math.max(left,right) + 1;
    }
    
    
    public void pre(TreeNode root){
        
        if( root == null){
            return;
        }
        helper(root, root.val);
        pre(root.left);
        pre(root.right);
    }
    
    public int longestUnivaluePath(TreeNode root) {
        
        pre( root );
        return ans==0?0:ans-1;
    }
}