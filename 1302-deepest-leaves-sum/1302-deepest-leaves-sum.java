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
    public int deepestLeavesSum(TreeNode root) {
    
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int ans = 0;
        
        while( !q.isEmpty() ){
            
            int size = q.size();
            int curAns = 0;
            while( size-- > 0 ){
                
                TreeNode cur = q.poll();
                curAns += cur.val ;
                
                if( cur.left != null ){
                    q.add(cur.left);
                }
                if( cur.right != null ){
                    q.add(cur.right);
                }
                
            }
            ans = curAns;
        }
        
        return ans;
    }
}