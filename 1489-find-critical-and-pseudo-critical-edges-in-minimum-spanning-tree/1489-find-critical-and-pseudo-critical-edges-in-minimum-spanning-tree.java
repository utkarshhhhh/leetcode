class Solution {
    
    class dsu{
        int[] parent, rank;
        int comp;
        dsu(int n){
            parent = new int[n];
            rank = new int[n];
            comp = n;
            
            for(int i = 0; i < n; i++){
                parent[i] = i;
                // r[i] = 0;
            }
        }
        
        int find(int x){
            if( parent[x] == x ) return x;
            return parent[x] = find( parent[x] );
        }
        
        boolean union(int X, int Y){
            
            int x = find(X);
            int y = find(Y);
            
            if( x==y ) return false;
            
            if( rank[x] < rank[y] ){
                parent[x] = y;
            }else if( rank[x] > rank[y] ){
                parent[y] = x;
            }else{
                parent[y] = x;
                rank[x]++;
            }
            
            comp--;
            return true;
        }
        
    }
    
    int mst(int n, int[][] g, int[] skip, int[] add){
        
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b)->{
            return a[2] - b[2];
        } );
        
        for(int[] x : g){            
            if( x == skip || x == add ) continue;            
            pq.add( x );            
        }
        
        dsu uf = new dsu(n);
        int ans = 0;
        
        if( add != null ){
            if( uf.union( add[0], add[1] ) ){
                ans += add[2];
            }          
        }
        
        while( pq.size() > 0 ){            
            int[] c = pq.poll();
            if( uf.union( c[0], c[1] ) ){
                ans += c[2];
            }            
        }
        
        if( uf.comp == 1 ){
            return ans;
        }
        
        return Integer.MAX_VALUE;
    }
    
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        
        int minMst = mst( n, edges, null, null );
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> critical = new ArrayList<>();
        List<Integer> pcritical = new ArrayList<>();
        
        int i=0 ;
        for( int[] e : edges ){
            
            int skipMst = mst( n, edges, e, null );
            
            if( skipMst > minMst ){
                critical.add(i);
            }else {
                
                int addMst = mst( n, edges, null, e );
                
                if( addMst == minMst ){
                    pcritical.add(i);
                }
            }
            
            i++;
        }
        ans.add(critical);
        ans.add(pcritical);
        return ans;
    }
}