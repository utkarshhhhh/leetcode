/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add( original );
        q.add( cloned );
        
        
        while( !q.isEmpty() ){
            
            int size = q.size()/2;
            
            while( size-- > 0 ){
                
                TreeNode org = q.poll();
                TreeNode clone = q.poll();
                
                if( org == target ){
                    return clone;
                }
                
                if( org.left != null ){
                    q.add( org.left );
                    q.add( clone.left );
                }
                
                
                if( org.right != null ){
                    q.add( org.right );
                    q.add( clone.right );
                }
                
            }
            
        }
        
        return null;
    }
}