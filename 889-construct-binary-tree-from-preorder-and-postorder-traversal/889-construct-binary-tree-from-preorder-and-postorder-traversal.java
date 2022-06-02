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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0 ; i<preorder.length ; i++){
            map.put( postorder[i],i );
        }
        return build( preorder, postorder, 0,preorder.length-1, 0,postorder.length-1, map );
    }
    
    private TreeNode build(int[] pre, int[] post, int pres,int pree, int posts, int poste,HashMap<Integer,Integer> map ){
        
        if( pres>pree || posts>poste ){
            return null;
        }
        
        TreeNode node = new TreeNode( pre[pres] );
        
        if( pres + 1 <= pree ){
            
            int size = map.get( pre[pres+1] ) - posts;
            
            node.left = build(pre,post, pres+1, pres+1+size , posts , posts + size, map );
            node.right = build(pre,post, pres+1+size + 1, pree , posts + size + 1 , poste-1 , map );
            
        }
        return node;
    }
    
}