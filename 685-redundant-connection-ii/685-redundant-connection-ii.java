class Solution {
    
    int[] par;
    public int[] findRedundantDirectedConnection(int[][] edges) {
        
        int n = edges.length;
        int[] parent = new int[n+1];
        
        for(int i=0 ; i<=n ; i++){
            parent[i] = 0;
        }
        int[] edge1 = null, edge2 = null;
        boolean twop =  false; // two parent
        for(int i[] : edges){
            
            int v = i[1], u = i[0];
            if( parent[v] == 0 ){
                parent[v] = u;
            }else{
                twop = true;
                edge1 = new int[]{ parent[v] , v };
                edge2 = i;
                break;
            }
        }
        
        par = new int[n+1]; // or use parent
        for(int i = 0; i <= edges.length; i++){
            par[i] = i;    
        }
        if( twop ){
            
            boolean cycle = false;
            for( int[] e : edges ){

                if( edge2==e ){
                    continue;
                }

                int u = e[0], v = e[1];
                int fromLead = find( u );
                
                if( fromLead == v  ){ // means cycle
                    cycle = true;
                    break;
                }else{
                    par[v] = u;
                }
            }
            
            if( cycle ){
                return edge1;          
            }else{
                return edge2;
            }
         
        }else{
            
            int[] res = null;
            for( int[] e : edges ){

                int u = e[0], v = e[1];
                int fromLead = find( u );
                
                if( fromLead == v  ){ // means cycle
                    res = e;
                    break;
                }else{
                    par[v] = fromLead;
                }
            }
            return res;
        }
        
    }
    
    int find(int x){
        if( par[x] == x ) return x;
        return par[x] = find( par[x] );
    }
    
    
}