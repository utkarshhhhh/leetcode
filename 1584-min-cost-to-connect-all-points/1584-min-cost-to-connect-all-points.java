class Solution {
    
    static int max = Integer.MAX_VALUE;
    public int minCostConnectPoints(int[][] points) {
        
        int n = points.length;
        int mstCost = 0;
        int edgesUsed = 0;
        
        boolean[] vis = new boolean[n];
        int[] dist = new int[n];
        
        for(int i=1 ; i<n ; i++)
            dist[i] = max;
        
        while( edgesUsed < n ){
            
            int curMin = max, curNode = -1;
            
            for( int node = 0 ; node < n ; node++ ){
                
                if( !vis[node] && dist[node] < curMin ){
                    curMin = dist[node];
                    curNode = node;
                }
            }
            
            mstCost += curMin;
            edgesUsed++;
            vis[curNode] = true;
            
            for(int nextNode = 0 ; nextNode < n ; nextNode++ ){
                
                int w = Math.abs( points[curNode][0] - points[nextNode][0] ) + 
                        Math.abs( points[curNode][1] - points[nextNode][1] );
                
                if( !vis[nextNode] && dist[nextNode] > w )
                    dist[nextNode] = w;
            }
        }
        
        return mstCost;
        
    }
}