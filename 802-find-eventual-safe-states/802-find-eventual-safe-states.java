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
        
        vis = new boolean[n]; ans = new boolean[n];
        
        for(int i=0 ; i<n ; i++){
            if( !vis[i] ){
                dfs( i, -1, map );
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i=0 ;i<n ; i++){
            if(ans[i]) list.add(i);
        }
        return list;
    }
    
    boolean[] vis, ans;
    
    public boolean dfs(int s, int p, HashMap<Integer, ArrayList<Integer>> graph){
        
        if( ans[s] ) return true;
    
        if( vis[s] ){
            return false;
        }
        
        vis[s] = true;
        boolean cur = true;
        
        for(int nbr : graph.get(s)){
        
            if( !dfs(nbr, s, graph) ){
                cur = false;
                // break;
            }
            
        }        
        ans[s] = cur;
        return cur;
    }
    
}