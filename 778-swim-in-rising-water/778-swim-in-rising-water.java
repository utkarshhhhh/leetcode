class Solution {
    
    static class Pair implements Comparable<Pair> {
        int x, y, lvl;
        
        Pair( int i, int j, int k ){
            x = i;
            y = j;
            lvl = k;
        }
        
        public int compareTo(Pair p){
            return this.lvl - p.lvl;
        }
        
    }
    
    private void bfs(boolean[][] vis, int r, int c,Queue<Pair> q, int[][] grid){
        
        if( r<0 || r>=vis.length || c<0 || c>=vis[0].length || vis[r][c] )
            return ;
        
        q.add( new Pair( r,c,grid[r][c] ) );
    }
    
    public int swimInWater(int[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        
        boolean[][] vis = new boolean[n][m];   
        Queue<Pair> q = new PriorityQueue<>();
        int maxLvl = 0;
        
        q.add( new Pair( 0,0,grid[0][0] ) );
        
        while( q.size() != 0 ){
            
            Pair cur = q.poll();
            
            int r = cur.x, c = cur.y, lvl = cur.lvl;
            
            if( vis[r][c] ){
                continue;
            }
            vis[r][c] = true;
            maxLvl = Math.max( maxLvl, lvl );
            if( r == n-1 && c == m-1 ){
                return maxLvl;
            }
            
            bfs( vis,r+1,c, q, grid );
            bfs( vis,r-1,c, q, grid );
            bfs( vis,r,c+1, q, grid );
            bfs( vis,r,c-1, q, grid );
            
        }
        return maxLvl;
    }
}