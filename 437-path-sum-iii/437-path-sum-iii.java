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
    
    int count;
    HashMap<Integer, Integer> map;
    public int pathSum(TreeNode root, int targetSum) {
        count = 0;
        map = new HashMap<>();
        map.put(0,1);
        preorder( root, 0, targetSum );
        return count;
    }
    
    private void preorder(TreeNode root,int curSum, int target){
        
        if( root==null ) return;
        
        curSum += root.val;
        
        if( map.containsKey(curSum - target) ){
            count += map.get(curSum - target);
        }
        
        map.put( curSum , map.getOrDefault(curSum,0) + 1 );
        
        preorder(root.left, curSum, target);
        preorder(root.right,curSum, target);
        
        map.put( curSum , map.get(curSum) - 1 );
    }
}