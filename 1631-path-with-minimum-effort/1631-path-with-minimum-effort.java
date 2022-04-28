class Solution {
    
    private int[] d = { 0, 1, 0,-1, 0 };
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length , m = heights[0].length;
        int[][] effort = new int[n][m];
        for(int[] e : effort){
            Arrays.fill(e, Integer.MAX_VALUE);
        }
        effort[0][0] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> a[0]-b[0] );
        pq.offer(new int[3]); // effor , x, y
        
        while( !pq.isEmpty() ){
            
            int[] cur = pq.poll();
            
            int eff = cur[0] , x = cur[1], y = cur[2];
            
            if( x == n-1 && y == m-1 ){
                return eff;
            }
            
            for(int i=0 ; i<4 ; i++){
                
                int r = x + d[i];
                int c = y + d[i+1];
                
                if( r >= 0 && r<n && c >= 0 && c<m ){
                    
                    int nEffort = Math.max(eff , Math.abs( heights[r][c] - heights[x][y] ) );
                    
                    if( effort[r][c] > nEffort ){
                        effort[r][c] = nEffort;
                        pq.offer( new int[]{ nEffort , r , c } );
                    }   
                }   
            }   
        }
        return 0;
    }
}