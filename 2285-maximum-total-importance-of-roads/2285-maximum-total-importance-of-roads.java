class Solution {
    
    
    
    public long maximumImportance(int n, int[][] roads) {
        
        long[] graph = new long[n];
        
        
        for(int[] r : roads){        
            int x = r[0], y = r[1];
            graph[x]++;
            graph[y]++;
        }
        
        
        // PriorityQueue<Long> pq = new PriorityQueue<>( (a,b)->{
        //     return (int)(b-a);
        // } );
        
        Arrays.sort(graph);
        long max = 0;
        for(int i=0 ; i<n ; i++){
            max += graph[i]*(i+1);
        }
        
        return max;
    }
}