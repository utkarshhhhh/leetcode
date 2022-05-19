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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        Stack<ArrayList<Integer>> st = new Stack<>();
        q.add(root);
        
        while( !q.isEmpty() ){
            
            int size = q.size();
            ArrayList<Integer> list = new ArrayList<>();
            while( size-- > 0 ){
                
                TreeNode cur = q.removeFirst();
                list.add(cur.val);
                if( cur.left != null ){
                    q.add(cur.left);
                }
                if( cur.right != null ){
                    q.add( cur.right );
                }
            }
            st.add(list);
        }
        
        while( !st.isEmpty() ){
            
            ArrayList<Integer> list = st.pop();
            ans.add(list);
        }
        
        return ans;
        
    }
}