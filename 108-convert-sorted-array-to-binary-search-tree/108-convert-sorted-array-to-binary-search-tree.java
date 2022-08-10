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
    
    public TreeNode build( int[] nums, int i, int j ){
        
        if( i>j ) return null;
        if( i==j ){
            return new TreeNode( nums[i] );
        }
        
        int m = (i+j)>>1;
        TreeNode cur = new TreeNode( nums[m] );
        cur.left = build( nums, i, m-1 );
        cur.right = build( nums, m+1, j );
        
        return cur;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        return build( nums, 0, nums.length-1 );
    }
}