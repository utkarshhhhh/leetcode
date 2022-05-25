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
    private int height (TreeNode root){
        int l=0;
        TreeNode left = root;
        
        while( left != null ){
            l++;
            left = left.left;
        }
        
        
        int r=0;
        TreeNode right = root;
        
        while( right != null ){
            r++;
            right = right.right;
        }
        return l==r ? l : -1;
    }
    
    public int countNodes(TreeNode root) {
        
        if(root == null) return 0;
        
        int h = height( root );
        
        if( h!=-1 ){
            return (1<<h) -1;
        }
        
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}