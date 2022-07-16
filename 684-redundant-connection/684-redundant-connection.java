class Solution {
    
    int[] parent, rank;
    
    public int find(int x){
        
        if(parent[x] == x) return x;
        return parent[x] = find( parent[x] );
        
    }
    
    public void union(int x, int y){
        
        if( rank[x] > rank[y] ){
            parent[y] = x;
        }else if( rank[x] < rank[y] ){
            parent[x] = y;
        }else {
            parent[x] = y;
            rank[y]++;
        }
        
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        
        int n = edges.length;
        parent = new int[n+1];
        rank = new int[n+1];
        
        for(int i=0 ; i<n ; i++){
            parent[i] = i;
        }
        
        for(int[] edge : edges){
            int x = edge[0], y = edge[1];
            
            int parx = find(x), pary = find(y);
            
            if( parx != pary ){
                union(parx, pary);
            }else{
                return edge;
            }
        }
        
        return new int[0];
    }
}