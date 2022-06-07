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
    
    public int helper(TreeNode root){
        
        if( root == null) {
            return 0;
        }
        
        int left  = helper(root.left);
        int right = helper(root.right);
        
        if( root.left != null ){
            left = root.left.val==root.val ? left + 1 : 0;
        }
        
        if( root.right != null ){
            right = root.right.val==root.val ? right + 1 : 0;
        }

        ans = Math.max(left+right, ans);
        
        
        return Math.max(left,right);
    }
    
    public int longestUnivaluePath(TreeNode root) {
        
        if(root == null) return 0;
        
        helper( root );
        return ans;
    }
}

/*
int ans  = 0;
    
    public int helper(TreeNode root, int val){
        
        if( root == null) {
            return 0;
        }
        
        int left  = helper(root.left, root.val);
        int right = helper(root.right, root.val);
        ans = Math.max(left+right+1, ans);
        

        if( root.val == val )
            return Math.max(left,right) + 1;
        return 0;
    }
    
    public int longestUnivaluePath(TreeNode root) {
        
        if(root == null) return 0;
        
        helper( root, 10001 );
        return ans-1;
    }
*/
