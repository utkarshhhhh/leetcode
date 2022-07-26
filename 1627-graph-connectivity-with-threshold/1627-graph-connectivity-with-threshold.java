class Solution {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        
        parent = new int[n+1];
        rank = new int[n+1];
        
        for( int i=0 ; i<=n ; i++ ){
            parent[i] = i;
        }
        
        for(int t = threshold+1 ; t<=n ; t++){
            for( int i=1 ; t*i<=n ; i++ ){
                union(t,i*t);
            }
        }
        
        List<Boolean> ans = new ArrayList<>();
        for(int[] x : queries){
            ans.add( find(x[0]) == find(x[1]) );
        }
        return ans;
    }
    
    int[] parent, rank;
    
    int find(int x){
        if( parent[x] == x ) return x;
        return parent[x] = find( parent[x] );
    }
    
    void union(int X, int Y){
        
        int x = find( X );
        int y = find( Y );
        
        if( x==y ) return ;
        
        if( rank[x] < rank[y] ){
            parent[x] = y;
        }else if( rank[x] < rank[y] ){
            parent[y] = x;
        }else {
            parent[y] = x;
            rank[x]++;
        }
    }
    
}