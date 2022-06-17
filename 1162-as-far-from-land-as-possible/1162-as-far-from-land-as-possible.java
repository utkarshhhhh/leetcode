class Solution {
    
    class Pair{
        int x,y,lvl;
        Pair(int i, int j, int k){
            x = i;
            y = j;
            lvl = k;
        }
    }
    public void init(int[][] mat, Queue<Pair> q){
        
        for(int i=0 ; i<mat.length ; i++)
            for(int j=0 ; j<mat[0].length ; j++)
                if( mat[i][j] == 1 )
                    q.add( new Pair(i,j,0) );
                
    }
    
    public void dfs( boolean[][] vis, int r, int c, int l, Queue<Pair> q ){
        
        if( r<0 || r >= vis.length || c<0 || c >= vis.length || vis[r][c] ){
            return ;
        }
        
        q.add( new Pair( r,c,l ) );
    }
    
    public int maxDistance(int[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        
        Queue<Pair> q = new ArrayDeque<>();
        init( grid, q );
        boolean[][] vis = new boolean[n][m];
        int Lvl = 0;
        int[][] arr = new int[n][m];
        
        while( !q.isEmpty() ){
            
            Pair cur = q.poll();
            int x = cur.x, y = cur.y, lvl = cur.lvl;
            
            if( vis[x][y] ){
                continue;
            }
            
            vis[x][y] = true;
            Lvl = Math.max(Lvl, lvl);
            
            dfs( vis, x+1,y,lvl+1, q );
            dfs( vis, x,y+1,lvl+1, q );
            dfs( vis, x-1,y,lvl+1, q );
            dfs( vis, x,y-1,lvl+1, q );
            
        }
        
        return Lvl==0 ? -1 : Lvl;
    }
}