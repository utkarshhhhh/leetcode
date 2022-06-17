class Solution {
    
    class Pair{
        int x, y;
        
        Pair( int i, int j){
            x = i;
            y = j;
        }
        
    }
       
    void dfs(int[][] grid, int r, int c, int x, boolean[][] vis,Queue<Pair> q ){
        
        if( r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c] != x || vis[r][c] ){
            return ;
        }
        
        vis[r][c] = true;
        q.add( new Pair( r,c ) );
        
    }
    
    void fill(int[][] grid, int r, int c, boolean[][] vis, int color){
    
        int n = grid.length, m = grid[0].length;

        boolean left = c>0 ? vis[r][c-1] : false ; 
        boolean right = c<m-1 ? vis[r][c+1] : false ; 
        boolean up = r>0 ? vis[r-1][c] : false ; 
        boolean down = r<n-1 ? vis[r+1][c] : false ; 
    
        if( !(left && right && up && down) ){
            grid[r][c] = color;
        }
        
    }
    
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length, m = grid[0].length;
    
        boolean[][] vis = new boolean[n][m];
        
        int org = grid[row][col];
        q.add(new Pair( row,col ));
        vis[row][col] = true;
        
        
        while( !q.isEmpty() ){
            Pair cur = q.poll();
            int r = cur.x, c = cur.y;
            if( grid[r][c] != org ){
                continue;
            }
            
            dfs( grid, r+1, c, org, vis, q );
            dfs( grid, r-1, c, org, vis, q );
            dfs( grid, r, c+1, org, vis, q );
            dfs( grid, r, c-1, org, vis, q );
            
            fill( grid,r,c, vis, color );
        }
        return grid;
    }
}