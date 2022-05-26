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
    
    int max;
    public int helper(TreeNode root){
        if( root == null ){ 
            return 0;
        }
        
        int left = Math.max( helper(root.left), 0);
        int right = Math.max(helper(root.right),0);
        
        int sum = left+right+root.val;
        
        if( max < sum ){
            max = sum;
        }
        
        return Math.max(left, right) + root.val;
    }
    
    public int maxPathSum(TreeNode root) {
        
        max = Integer.MIN_VALUE;
        helper( root );
        
        return max;
    }
}