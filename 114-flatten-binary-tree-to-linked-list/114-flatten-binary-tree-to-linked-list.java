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
    
    class pair{
        TreeNode head, tail;
    }
    
    TreeNode prev = null;
    
//     private TreeNode helper(TreeNode root){
        
//         if( root==null ){
//             return null;
//         }
//         TreeNode left = flatten(root.left);
//         TreeNode right = flatten(root.right);
//         root.left = null;
//         left.right = 
//     }
    
    public void flatten(TreeNode root) {
        
        if( root==null ){
            return;
        }
        
        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = prev;
        prev = root;
    }
}