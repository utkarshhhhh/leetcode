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
    
    int ans = 0;
    
    final int cam = 1;
    final int MON = 2;
    final int UnMON = 3;
    
    public int helper(TreeNode root){
        
        if( root == null )
            return MON;
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        if( left==UnMON || right==UnMON ){
            ans++;
            return cam;
        }else if( left==cam || right==cam ){
            return MON;
        }else{
            return UnMON;
        }
    }
    
    public int minCameraCover(TreeNode root) {
        
        int status = helper(root);
        
        if( status == UnMON ){
            return 1+ans;
        }
        
        return ans;
    }
}