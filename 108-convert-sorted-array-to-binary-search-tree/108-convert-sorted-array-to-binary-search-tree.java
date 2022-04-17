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
    
    public TreeNode helper(int[] nums, int lo, int hi){
        
        if(lo > hi) return null;
        if( lo == hi ) return new TreeNode(nums[lo]);
        
        int m = (lo + hi)/2;
        
        TreeNode root = new TreeNode( nums[m] );
        root.left = helper(nums,lo,m-1);
        root.right = helper(nums,m+1,hi);
        
        
        return root;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        
        
        return helper( nums, 0, nums.length-1 );
    }
}