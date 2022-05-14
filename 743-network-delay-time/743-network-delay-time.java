class Solution {
    
    
    public List<int[]>[] createGraph(int[][] times, int n){
        
        List<int[]>[] graph = new ArrayList[n+1]; 
        
        for(int i=1 ; i<=n ;  i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] i : times){
            graph[i[0]].add( new int[]{ i[1] , i[2] } );
        }
        return graph;
    }
    
    public void dfs(List<int[]>[] graph, int s, int[] path){
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add( s );
        
        while( !q.isEmpty() ){
                int cur = q.poll();
              
                for( int[] child : graph[ cur ] ){
                        
                    int minTime = child[1] + path[cur] ;

                    if( path[child[0]] > minTime ){
                        path[child[0]] = minTime;
                        q.offer( child[0] );
                    }
                }
        }
    }
    
    public int networkDelayTime(int[][] times, int n, int k) {
        
        List<int[]>[] graph = createGraph(times , n);
        
        int[] vis = new int[n+1];
        Arrays.fill( vis, Integer.MAX_VALUE );
        vis[k] = 0;
        
        dfs( graph, k , vis);
        int ans = 0;
        for(int i=1 ; i<=n ; i++){
            ans = Math.max( vis[i] , ans );
        }
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
}