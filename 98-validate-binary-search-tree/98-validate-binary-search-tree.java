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
    
    
    private long prev;
    public boolean inorder(TreeNode root){
        if(root == null) return true ;
        
        boolean left = inorder(root.left);
        if( !left ) return false;
        
        if( root.val <= prev )
            return false;
        prev = root.val;
        
        boolean right = inorder(root.right);
        if( !right ) return false;
        
        return true;
    }
    
    public boolean isValidBST(TreeNode root) {
        
        prev = Long.MIN_VALUE;
        return inorder(root);
    }
}