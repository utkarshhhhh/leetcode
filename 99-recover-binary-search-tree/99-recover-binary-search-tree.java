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
    
    private TreeNode prev, first, second;
    public void helper(TreeNode root){
        
        if( root == null ) return;
        
        helper( root.left );
        
        if( prev != null && root.val < prev.val ){
            
            if( first == null )
                first = prev;
            
            second = root;
        }
        prev = root;
        
        helper( root.right );
        
    }
    
    public void recoverTree(TreeNode root) {
        
        prev = new TreeNode(Integer.MIN_VALUE);
        // first = null; second = null;
        helper( root );
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
        
    }
}