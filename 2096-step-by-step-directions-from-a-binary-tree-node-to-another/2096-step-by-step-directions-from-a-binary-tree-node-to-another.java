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
    
    TreeNode lca(TreeNode root, int n1,int n2){
	    if( root==null || root.val == n2 || root.val == n1 ){
		    return root;
		}
		
		TreeNode left = lca( root.left, n1, n2 );
		TreeNode right = lca( root.right, n1, n2 );
		
		return (left!=null && right!=null )? root : left==null ? right : left;
	}
    
    boolean find(TreeNode root, int x, StringBuilder ans){
        
        if( root == null ){
            return false;
        }
        
        if( root.val == x ){
            return true;
        }
        
        ans.append("L");
        boolean left = find(root.left, x, ans);
        if(left) return true;
        
        
        ans.setCharAt(ans.length()-1,'R');
        boolean right = find(root.right, x, ans);
        if(right) return true;
        ans.deleteCharAt( ans.length() - 1 );
                
        return false;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        
        TreeNode lca = lca( root, startValue, destValue );
        
        StringBuilder sb = new StringBuilder();
        StringBuilder s = new StringBuilder();
        
        find(lca, startValue, s);
        find(lca, destValue, sb);

        StringBuilder newS = new StringBuilder();

        for(int i=0 ; i<s.length() ; i++)
            newS.append("U");
        
        return newS.toString() + sb.toString();
    }
}