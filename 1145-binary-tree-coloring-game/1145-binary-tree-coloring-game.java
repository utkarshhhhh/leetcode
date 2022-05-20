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
    
    int leftSize , rightSize;
    
    public int size(TreeNode node, int x){
        
        if( node == null ){
            return 0;
        }
        
        int left = size(node.left, x);
        int right = size(node.right, x);
        
        if( node.val == x ){            
            leftSize = left;
            rightSize = right;            
        }
        
        return left + right + 1;
    }
    
    // block left or right or parent - maxSubtree
    
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        
        int totalSize = size( root , x );
        int parentSize = n - (leftSize + rightSize + 1);
        
        int maxSize = Math.max( parentSize , Math.max(leftSize , rightSize) );
        
        return maxSize > n-maxSize;
    }
}