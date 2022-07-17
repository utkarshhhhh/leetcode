class Solution {
    
    public boolean dfs(int s, int[] vis, ArrayList<Integer>[] graph){
        
        if(vis[s] == 1) return false;
        vis[s] = 1;
        
        for(int nbr : graph[s]){
            if(vis[nbr] == 1) return false;
            
            if ( vis[nbr]==0 ) 
                if( !dfs( nbr, vis, graph ) ) return false;
        }
        
        vis[s] = 2;
        return true;
    } 
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int n = numCourses;
        ArrayList[] graph = new ArrayList[n];
        
        for(int i=0 ; i<n ; i++){
            graph[i] = new ArrayList<Integer>();
        }
        
        for( int[] p : prerequisites ){            
            graph[ p[1] ].add(p[0]);            
        }
        
        int[] vis = new int[n];
        
        for(int i=0 ; i<n ; i++){            
            if (!dfs( i,vis, graph ) )
                return false;
        }
        
        return true;
    }
}