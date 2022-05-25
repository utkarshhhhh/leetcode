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
    int preIdx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        map = new HashMap<>();
        preIdx = 0;
        for(int i=0 ; i<inorder.length ; i++){
            map.put(inorder[i], i);
        }
        
        TreeNode tree = build(0,preorder.length-1, preorder);
        return tree;
    }
    
    private TreeNode build(int left,int right,int[] pre){
        
        if( right < left){
            return null;
        }
        
        int val = pre[preIdx++];
        TreeNode node = new TreeNode( val );
        
        node.left = build(left, map.get( val ) -1 , pre);
        node.right = build( map.get(val) + 1 ,right,  pre);
        
        return node;
    }
}

// app 1
//         if( pl > ph || il > ih ){
//             return null;
//         }
        
//         TreeNode node = new TreeNode( pre[pl] );
        
//         int idx = map.get( pre[pl] );
//         int lhs = idx - il; // no of elem in left side
        
//         node.left = build(pl+1, pl+lhs , il, idx-1, pre);
//         node.right = build( pl+lhs+1, ph , idx+1, ih , pre);
        
//         return node;