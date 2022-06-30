class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b)-> b[1]-a[1] );
        
        int cur = startFuel, ans = 0, i =0, n = stations.length;
        
        while( cur < target ){
            
            while( i<n && stations[i][0] <= cur  ){
                pq.offer( stations[i++] );
                
            }
            
            if( !pq.isEmpty() ){
                int[] c = pq.poll();
                cur += c[1];
                ans++;
            }else return -1;        
        }
        
        return ans;
    }
}