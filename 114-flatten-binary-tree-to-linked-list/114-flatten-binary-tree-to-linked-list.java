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
        TreeNode head, tail;
        pair(){}
        pair( TreeNode h, TreeNode t ){
            head = h;
            tail = t;
        }
    }
    
    
    private pair helper(TreeNode root){
        
        if( root.left != null && root.right != null ){
            pair left = helper(root.left);
            pair right = helper(root.right);

            pair node = new pair();
            node.head = root;
            node.head.left = null;
            node.head.right = left.head;
            left.tail.right = right.head;
            node.tail = right.tail;
            
            return node;
        }else if( root.left != null ){
            pair left = helper(root.left);
            
            pair node = new pair();
            node.head = root;
            node.head.left = null;
            node.head.right = left.head;
            node.tail = left.tail;

            return node;                      
        }else if( root.right != null ){
            pair right = helper(root.right);
            
            pair node = new pair();
            node.head = root;
            node.head.left = null;
            node.head.right = right.head;
            node.tail = right.tail;
            
            return node;
        }else{
            return new pair(root,root);
        }
       
    }
    
    public void flatten(TreeNode root) {
        
        if(root != null){
            helper(root);
        }        
    }
    
    
}

/*
    TreeNode prev = null;

if( root==null ){
        return;
    }

    flatten(root.right);
    flatten(root.left);
    root.left = null;
    root.right = prev;
    prev = root;
*/