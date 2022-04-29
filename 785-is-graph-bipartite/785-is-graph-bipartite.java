class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        int[] colors = new int[n];
        
        for(int i=0 ; i<n ; i++){
            if( colors[i] == 0 && !dfs(graph,colors , 1, i ) ){
                return false;
            }
        }
        return true;
    }
    
    public boolean dfs(int[][] graph , int[] colors , int color , int vertex){
        
        if( colors[vertex] != 0 ){
            return colors[vertex] == color;
        }
        
        colors[vertex] = color;
        
        for( int nbr : graph[vertex] ){
            
            if( !dfs( graph , colors, -color , nbr ) ){
                return false;
            }   
        }
        return true;
    }
    
}