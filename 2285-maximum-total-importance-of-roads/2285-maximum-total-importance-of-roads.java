class Solution {
    
    
    
    public long maximumImportance(int n, int[][] roads) {
        
        long[] graph = new long[n];
        
        
        for(int[] r : roads){        
            int x = r[0], y = r[1];
            graph[x]++;
            graph[y]++;
        }
        
        
        PriorityQueue<Long> pq = new PriorityQueue<>( (a,b)->{
            return (int)(b-a);
        } );
        
        for(int i=0 ; i<n ; i++){
            pq.add( graph[i] );
        }
        
        long max = 0L;
        
        while( !pq.isEmpty() ){
            
            long top = pq.poll();
            max += (top*n);
            n--;            
        }
        
        return max;
    }
}