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
    public List<Integer> rightSideView(TreeNode root) {
       
    if(root == null )
        return new ArrayList<>();
        
      List<Integer> ans = new ArrayList<>();
      Deque<TreeNode> q = new ArrayDeque<>();
      q.add(root);
      
      while( !q.isEmpty() ){
          
          int size = q.size();
          for(int i=0 ; i<size ; i++ ){
              
              TreeNode cur = q.poll();
              
              if( i==size-1){
                  ans.add(cur.val);            
              }
              
              if( cur.left != null ){
                  q.add(cur.left);
              }
              
              if( cur.right != null ){
                  q.add(cur.right);
              }
              
          }
          
      }
      return ans;
        
    }
}