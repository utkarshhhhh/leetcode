class Solution {
    
    class Pair{
        int x, y;
        
        Pair( int i, int j){
            x = i;
            y = j;
        }
        
    }
       
    void bfs(int[][] grid, int r, int c, int x, boolean[][] vis,Queue<Pair> q ){
        
        if( r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c] != x || vis[r][c] ){
            return ;
        }
        
        vis[r][c] = true;
        q.add( new Pair( r,c ) );
        
    }
    
    void dfs(int[][] grid, int r, int c, int x){
        
        if( r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c] != x ){
            return ;
        }
        
        grid[r][c] = -grid[r][c];
        
        dfs( grid, r+1, c, x);
        dfs( grid, r-1, c, x);
        dfs( grid, r, c+1, x);
        dfs( grid, r, c-1, x);

        fill( grid, r, c, x );
        
    }
    
    void fill(int[][] grid, int r, int c,int x){
    
        int n = grid.length, m = grid[0].length;

        boolean left = c>0 ? Math.abs(grid[r][c-1])==x : false ; 
        boolean right = c<m-1 ? Math.abs(grid[r][c+1])==x  : false ; 
        boolean up = r>0 ? Math.abs(grid[r-1][c])==x  : false ; 
        boolean down = r<n-1 ? Math.abs(grid[r+1][c])==x  : false ; 
    
        if( left && right && up && down ){
            grid[r][c] = Math.abs(grid[r][c]);
        }
        
    }
    
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        
        // Queue<Pair> q = new LinkedList<>();
        int n = grid.length, m = grid[0].length;
    
//         boolean[][] vis = new boolean[n][m];
        
        int org = grid[row][col];
//         q.add(new Pair( row,col ));
//         vis[row][col] = true;
        
        
//         while( !q.isEmpty() ){
//             Pair cur = q.poll();
//             int r = cur.x, c = cur.y;
//             if( grid[r][c] != org ){
//                 continue;
//             }
            
//             bfs( grid, r+1, c, org, vis, q );
//             bfs( grid, r-1, c, org, vis, q );
//             bfs( grid, r, c+1, org, vis, q );
//             bfs( grid, r, c-1, org, vis, q );
            
//             fill( grid,r,c, vis, color );
//         }
        
        dfs(grid, row, col, org);
        
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if( grid[i][j]<0 ) grid[i][j] = color;
            }
        }
        
        return grid;
    }
}