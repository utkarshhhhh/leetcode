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
    
    long sec, main;
    public void helper( TreeNode root ){
        
        if( root == null ) return ;
        
        helper( root.left );
        helper( root.right );
        
        if( sec > root.val && root.val > main ){
            sec = root.val;
            return;
        }
        
    }
    
    public int findSecondMinimumValue(TreeNode root) {
        
        sec = Long.MAX_VALUE;
        main = root.val;
        helper( root );    
        return sec==Long.MAX_VALUE?-1: (int)sec;    
    }
}