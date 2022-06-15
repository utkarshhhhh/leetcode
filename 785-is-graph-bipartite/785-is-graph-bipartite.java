class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        int[] colors = new int[n];
        
        for(int i=0 ; i<n ; i++){
            
            if( colors[i] == 0 && !dfs(graph, i,1, colors)){        
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(int[][] graph, int src, int color, int[] colors){
        
        if( colors[src] != 0 ){
            return colors[src] == color;
        }
        
        colors[src] = color;
        
        for(int child : graph[src] ){
        
            if( !dfs( graph, child, -color, colors ) ){
                return false;
            }
        }
        
        return true;
    }
}