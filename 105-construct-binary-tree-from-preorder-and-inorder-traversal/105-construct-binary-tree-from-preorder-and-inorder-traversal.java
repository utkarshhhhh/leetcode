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
    
    HashMap<Integer, Integer> map ;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        map = new HashMap<>();
        
        for(int i=0 ; i<inorder.length ; i++){
            map.put(inorder[i], i);
        }
        
        TreeNode tree = build(0,preorder.length-1, 0,inorder.length-1, preorder);
        return tree;
    }
    
    private TreeNode build(int pl,int ph,int il,int ih, int[] pre){
        
        if( pl > ph || il > ih ){
            return null;
        }
        
        TreeNode node = new TreeNode( pre[pl] );
        
        int idx = map.get( pre[pl] );
        int lhs = idx - il;
        
        node.left = build(pl+1, pl+lhs , il, idx-1, pre);
        node.right = build( pl+lhs+1, ph , idx+1, ih , pre);
        
        return node;
    }
    
}