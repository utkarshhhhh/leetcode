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
    
    static class pair implements Comparable<pair>{
        int col,lvl;  // lvl 
        TreeNode node;
        pair(int d,int w, TreeNode n){
            this.col = d;
            this.lvl = w;
            node = n;
        }
        
        public int compareTo(pair o){
            
            if( o.lvl == this.lvl )
                return this.node.val - o.node.val;
            else
                return this.col - o.col;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        HashMap<Integer , ArrayList<pair>> map = new HashMap<>();
        Deque<pair> q = new ArrayDeque<>();
        q.add( new pair(0 ,0, root) );
        int min = 0, max = 0;
        
        while( q.size() > 0 ){
            
            pair temp = q.poll();
            int i = temp.col;
            TreeNode cur = temp.node;
            
                map.putIfAbsent(i,new ArrayList<>());
                map.get(i).add( temp );
            
            if( cur.left != null ){
                q.add( new pair( i-1 , temp.lvl+1 , cur.left ) );
                min = Math.min(min, i-1);
            }
            
            if( cur.right != null ){
                q.add( new pair( i+1 , temp.lvl+1, cur.right ) );
                max = Math.max(max, i+1);
            }
            
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=min  ; i<=max ; i++){
            
            ArrayList<pair> arr = map.get(i);
            Collections.sort( arr );
            
            List<Integer> cur = new ArrayList<>();
            for( pair x : arr)
                cur.add( x.node.val );
            
            ans.add(cur);
        }
        
        return ans;
        
    }
}