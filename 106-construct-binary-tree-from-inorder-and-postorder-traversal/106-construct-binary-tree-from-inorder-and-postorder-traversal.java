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
    
    HashMap<Integer, Integer> map;
    int postIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        postIdx = postorder.length-1;
        
        for(int i=0 ; i<inorder.length ; i++)
            map.put( inorder[i], i );
        
        TreeNode tree = helper(0,postorder.length-1, postorder);
        return tree;
    }
    
    private TreeNode helper(int left, int right, int[] post){
        
        if(left > right) return null;
        
        int val = post[ postIdx-- ];
        TreeNode node = new TreeNode(val);
        
        int idx = map.get(val);
        // 9,3,15,20,7 post 9 -- ,15,7,20, 3
        node.right = helper( idx+1, right, post );
        node.left = helper( left, idx-1, post );
        
        
        return node;
    }
    
}