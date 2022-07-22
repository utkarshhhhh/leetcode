class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
     
        HashMap< String,PriorityQueue<String> > graph = new HashMap<>();
        
        for( List<String> l : tickets ){
            graph.putIfAbsent( l.get(0), new PriorityQueue<>() );
            graph.get(l.get(0)).add(l.get(1));
        }
        
        dfs("JFK", graph);
        Collections.reverse(ans);
        return ans;
    }
    List<String> ans = new ArrayList<>();
    
    void dfs( String s, HashMap<String, PriorityQueue<String>> g){
        
        if( !g.containsKey(s) || g.get(s).size() == 0){
            ans.add(s);
            return;
        }
        
        PriorityQueue<String> tickets = g.get(s);
        while( tickets.size() > 0 ){
            String nbr = tickets.remove();
            dfs(nbr, g);            
        }
        
        ans.add(s);
    }
    
}