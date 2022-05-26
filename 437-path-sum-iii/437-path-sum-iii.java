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
    
    int count;
    public int pathSum(TreeNode root, int targetSum) {
        count = 0;
        preorder( root, targetSum );
        return count;
    }
    
    private void preorder(TreeNode root, int target){
        
        if( root==null ) return;
        
        counter(root,target, 0);
        preorder(root.left,target);
        preorder(root.right,target);
    }
    
    private void counter(TreeNode root, int t, int sum){
        
        if( root==null ) return ;
        
        if( t==sum+root.val ){
            count++;
        }
        
        counter(root.left,t,sum+root.val);
        counter(root.right,t,sum+root.val);
        
    }
    
    
}