class Solution {
    
    private Map<String, Map<String , Double>> makeGraph(List<List<String>> equations, double[] values){
        
        Map<String, Map<String , Double>> graph = new HashMap<>();
        
        String u , v;
        for(int i=0 ; i<equations.size() ; i++){
            
            u = equations.get(i).get(0);
            v = equations.get(i).get(1);
            
            graph.putIfAbsent( u , new HashMap<>());
            graph.get(u).put( v , values[i] );
            
            graph.putIfAbsent( v , new HashMap<>());
            graph.get(v).put( u , 1/values[i] );
            
        }
        return graph;
    }
    
    private double dfs(Map<String, Map<String , Double>> graph , String src , String dest , Set<String> vis){
        
        if( !graph.containsKey(src) ){
            return -1.0;
        }
        
        if( graph.get(src).containsKey(dest) ){
            return graph.get(src).get(dest);
        }
        
        vis.add(src);
        
        for( Map.Entry<String , Double> nbr : graph.get(src).entrySet() ){
            
            if( !vis.contains( nbr.getKey() ) ){
               
                double wt = dfs(graph , nbr.getKey() , dest , vis );
                
                if( wt != -1.0 )
                    return nbr.getValue()*wt;
            }
        }
        return -1.0;
    }
    
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        Map<String, Map<String , Double>> graph = makeGraph(equations, values);
        double[] ans = new double[queries.size()];
        
        for(int i=0 ; i<queries.size() ; i++){
            ans[i] = dfs( graph , queries.get(i).get(0) , queries.get(i).get(1) , new HashSet<String>() );
        }
        
        return ans;
    }
}