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
    
    int Mon = 1;
    int Unmon = 2;
    int Cam = 3;
    int ans;
    
    private int helper(TreeNode root){
        
        if( root == null ){
            return Mon;
        }
        
        int left = helper( root.left );
        int right = helper( root.right );
        
        if( left == Unmon || right == Unmon ){
            ans++;
            return Cam;
        }else if( left == Cam || right == Cam ){
            return Mon;
        } else{
            return Unmon;
        }
        
    }
    
    
    public int minCameraCover(TreeNode root) {
        
        ans = 0;
        
        int check = helper(root);
        if(check == Unmon) ans++;
        
        return ans;
    }
}