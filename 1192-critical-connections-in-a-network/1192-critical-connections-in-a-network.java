class Solution {
    int[] disc , low; // discovered
    int time;
    List<List<Integer>> ANS;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        List<Integer>[] graph  = new ArrayList[n];
        
        for(int i=0 ;  i<n ; i++){
            graph[i] = new ArrayList<Integer>();
        }
        for(List<Integer> i : connections){
            int s = i.get(0) , d = i.get(1);
            graph[s].add(d);
            graph[d].add(s);
        }
        
        time = 0;
        disc = new int[n] ; low = new int[n];
        ANS = new ArrayList<>();
        
        dfs( graph , 0, -1 );
        return ANS;
    }
    
    public void dfs(List<Integer>[] graph, int s, int par){
        
        if( disc[s] > 0 ) return ;
        
        disc[s] = ++time;
        low[s] = time;
        
        for(int nbr : graph[s]){
            
            if( nbr == par ){
                continue;
            }
            
            if(disc[nbr] == 0) 
                dfs(graph , nbr, s);
            
            low[s] = Math.min( low[s] , low[nbr] );            
        }
        
        if( s!=0 && disc[par] < low[s] ){
            ANS.add( Arrays.asList(par,s) );
        }
        
        
    }
    
}