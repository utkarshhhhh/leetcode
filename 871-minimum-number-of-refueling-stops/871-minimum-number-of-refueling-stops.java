class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        
        int cur = startFuel, i = 0, n = stations.length, ans = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>( Collections.reverseOrder() );
        
        while( cur<target ){
            
            while( i<n && stations[i][0] <= cur ){
                pq.add( stations[i++][1] );
            }
            
            if( pq.size() > 0 ){
                cur += pq.poll();
                ans++;
            }else{
                return -1;
            }
            
        }
        
        return ans;
    }
}