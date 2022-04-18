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
    
    private int c;
    
    public int helper(TreeNode root, int k){
        
        if(root == null) return -1;
        int left = helper( root.left , k );
        if( left != -1) return left;
        
        c++;
        if(c == k)
            return root.val;
        
        int right = helper( root.right , k);
        if(right != -1) return right;
        
        return -1;
    }
    
    public int kthSmallest(TreeNode root, int k) {
        c = 0;
        return helper(root , k);
    }
}