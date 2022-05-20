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
    public int findBottomLeftValue(TreeNode root) {
        
      long ans = 0;
      Deque<TreeNode> q = new ArrayDeque<>();
      q.add(root);
      
      while( !q.isEmpty() ){
          
          int size = q.size();
          int i=0;
          while( size-- > 0 ){
              
              TreeNode cur = q.poll();
              
              if( i==0){
                  ans = cur.val;
                  i++;
              }
              
              if( cur.left != null ){
                  q.add(cur.left);
              }
              
              if( cur.right != null ){
                  q.add(cur.right);
              }
              
          }
          
      }
      return (int)ans;
    }
}