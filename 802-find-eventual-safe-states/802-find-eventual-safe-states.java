class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        int n = graph.length;
        for(int i=0 ; i<n ; i++){
            map.put(i, new ArrayList<>());
            for(int x : graph[i]){
             map.get(i).add(x);       
            }
        }
        
        vis = new int[n]; 
        // ans = new boolean[n];
        
        for(int i=0 ; i<n ; i++){
            if( vis[i]==0 ){
                dfs( i, map );
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i=0 ;i<n ; i++){
            if(vis[i]==2) list.add(i);
        }
        return list;
    }
    
    int[] vis, ans;
    
    public boolean dfs(int s, HashMap<Integer, ArrayList<Integer>> graph){
        
        if( vis[s] != 0){
            return vis[s] == 2;
        }
        
        vis[s] = 1;
        
        for(int nbr : graph.get(s)){
        
            if( !dfs(nbr,graph) ){
                // cur = false;
                // break;
                return false;
            }
            
        }        
        vis[s] = 2;
        return true;
    }
    
}