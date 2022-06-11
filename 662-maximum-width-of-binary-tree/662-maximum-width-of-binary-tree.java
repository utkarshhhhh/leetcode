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
    
    class pair{
        long min, max;
    }
    
    HashMap<Long, pair> map = new HashMap<>();
    long maxW = 0;
    private void helper(TreeNode root, long l, long idx ){
        
        if( root == null ) return ;
        
        helper(root.left,l+1, 2*idx);
        helper(root.right,l+1, 2*idx+1);
        
        pair p = new pair();
        
        if( map.containsKey(l) ){
            p.min = map.get(l).min;
            p.max = idx;
        }else{
            p.min = p.max = idx;
        }
        
        map.put(l,p);
        maxW = Math.max( maxW, p.max-p.min + 1 );
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        
        helper(root, 1,1);
        return (int)maxW;
    }
}