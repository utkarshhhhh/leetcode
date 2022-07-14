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
    HashMap<Integer, Integer> map = new HashMap<>();
    int ptr = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i=0 ; i<preorder.length ; i++){
            map.put( inorder[i], i );
        }
        
        return build( preorder, 0, inorder.length-1 );
    }
    
    public TreeNode build(int[] preorder, int st, int end){
        
        if( st > end ) return null;
        
        if( st==end ){
            return new TreeNode( preorder[ptr++] );
        }
        
        int val = preorder[ptr++];
        TreeNode node = new TreeNode( val );
        int idx = map.get( val );
        
        node.left = build( preorder, st , idx-1 );
        node.right = build( preorder, idx+1, end );
        
        return node;
    }
}