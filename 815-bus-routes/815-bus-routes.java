class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
    
        if( source == target ) return 0;
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        
        // initialization ---- virtual map
        for(int bus=0 ; bus<routes.length ; bus++ ){
            for(int station : routes[bus]){   
                HashSet<Integer> allBuses = map.getOrDefault(station, new HashSet<Integer>());
                allBuses.add(bus);
                map.put( station, allBuses );
            }            
        }
        // intial. complete
        
        int minBus = 1;
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] vis = new boolean[ map.size() ];
        for( Integer bus : map.get(source) ){
            q.add( bus );
        }
        
        while( !q.isEmpty() ){
            
            int size = q.size();
            
            for(int i=0 ; i<size ; i++){
                
                int curBus = q.poll();
                
                if( vis[curBus] ){
                    continue;
                }
                vis[curBus] = true;
                
                for(int st : routes[curBus]){
                    if( st == target ) return minBus; 
                    
                    for( int bus : map.get(st) ){
                        if( !vis[bus] )
                            q.add( bus );
                    }                    
                }
                
            }
            minBus++;   
        }
        return -1;
    }
}   