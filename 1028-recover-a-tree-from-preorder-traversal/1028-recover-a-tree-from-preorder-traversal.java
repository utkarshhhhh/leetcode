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
    int i=0;
    public TreeNode recoverFromPreorder(String traversal) {
        return helper( traversal, 0 );
    }
    
    private TreeNode helper( String s, int depth ){
        
        int d=0; // dash
        while( i+d < s.length() && s.charAt(i+d) == '-' ){
            d++;
        }
        
        if( depth != d ) return null;
        
        int nd = 0; // non dash
        while( i+d + nd < s.length() && s.charAt(i+d+nd) != '-' ){
            nd++;
        }
        
        int val = Integer.parseInt( s.substring(i+d, i+d+nd) );
        i = i+d+nd;
        
        TreeNode node = new TreeNode(val);
        
        node.left = helper( s, depth+1 );
        node.right = helper( s, depth+1 );
        
        return node;
    }
    
    
}