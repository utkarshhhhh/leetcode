/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    private Node dfs(Node node, HashMap<Integer, Node> vis){
        
        Node cur = new Node ( node.val );
        vis.put( node.val, cur );
        
        for( Node child : node.neighbors ){
            
            if( vis.containsKey( child.val ) ){
                cur.neighbors.add( vis.get( child.val ) );
            }else{        
                Node temp = dfs( child, vis );
                cur.neighbors.add( temp );
            }
            
        }
        
        return cur;
    }
    
    public Node cloneGraph(Node node) {
        
        if( node == null ) return null;
        
        HashMap<Integer, Node> vis = new HashMap<>();
        return dfs( node, vis );
    }
}