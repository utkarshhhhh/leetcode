class Solution {
    
    class Cell{
        int x,y, height ;
        
        Cell(int r, int c, int h){
            x = r; y = c; height = h;
        }
    }
    
    public int trapRainWater(int[][] heightMap) {
        
        PriorityQueue<Cell> pq = new PriorityQueue<>( (a,b)-> a.height - b.height );
        
        int n = heightMap.length, m = heightMap[0].length;
        boolean[][] vis = new boolean[n][m];
        
        // init
        for( int r=0 ; r<n ; r++ ){
            pq.offer( new Cell( r,0, heightMap[r][0] ) );
            pq.offer( new Cell( r,m-1, heightMap[r][m-1] ) );
            vis[r][0] = true;
            vis[r][m-1] = true;
        }
        
        for( int c=0 ; c<m ; c++ ){
            pq.offer( new Cell( 0,c, heightMap[0][c] ) );
            pq.offer( new Cell( n-1,c, heightMap[n-1][c] ) );
            vis[0][c] = true;
            vis[n-1][c] = true;
        }
        // init
        
        int[] dir = { 0, 1, 0, -1, 0 };
        
        int ans = 0;
        
        
        while( pq.size() > 0 ){
            
            Cell cur = pq.poll();
            int r = cur.x, c = cur.y;
            for(int i=0 ; i<4 ; i++){
                
                int rr = r + dir[i], cc = c + dir[i+1];
                
                if( rr>=0 && rr<n && cc >=0 && cc < m && !vis[rr][cc] ){
                    
                    vis[rr][cc] = true;
                    ans += Math.max( 0, cur.height - heightMap[rr][cc] );
                    pq.offer( new Cell( rr, cc, Math.max( cur.height, heightMap[rr][cc] ) ) );
                }                
            }            
        }        
        return ans;
    }
}