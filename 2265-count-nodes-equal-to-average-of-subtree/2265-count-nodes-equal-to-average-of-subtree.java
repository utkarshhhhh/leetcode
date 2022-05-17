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
    
    public int sum(TreeNode root){
        
        if(root == null){
            return 0;
        }
        
        return sum(root.left) + sum(root.right) + root.val;        
    }
    
    public int noOfEle(TreeNode root){
        
        if(root == null){
            return 0;
        }
        
        return noOfEle(root.left) + noOfEle(root.right) + 1;        
    }
    
    
    
    public int averageOfSubtree(TreeNode root) {
        
        if(root == null) return 0;

        int left = averageOfSubtree(root.left);
        int right = averageOfSubtree(root.right);
        
        int ans = ( sum(root)/noOfEle(root) == root.val ) ? 1 : 0;
        
        return left + right + ans;
    }
}