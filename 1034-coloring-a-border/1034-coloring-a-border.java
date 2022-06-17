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
        
        q.add( new Pair( r,c ) );
        
    }
    
    boolean fill(int[][] grid, int r, int c, int x){
    
        int n = grid.length, m = grid[0].length;

        boolean left = c>0 ? grid[r][c-1]==x : false ; 
        boolean right = c<m-1 ? grid[r][c+1]==x : false ; 
        boolean up = r>0 ? grid[r-1][c]==x : false ; 
        boolean down = r<n-1 ? grid[r+1][c]==x : false ; 
    
        return (left && right && up && down);
        
    }
    
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length, m = grid[0].length;
    
        boolean[][] vis = new boolean[n][m];
        
        int org = grid[row][col];
        q.add(new Pair( row,col ));
        
        Queue<Pair> ans = new LinkedList<>();
        
        while( !q.isEmpty() ){
            Pair cur = q.poll();
            int r = cur.x, c = cur.y;
            if( vis[r][c] ){
                continue;
            }
            
            vis[r][c] = true;
            // grid[r][c] = -grid[r][c];
            
            dfs( grid, r+1, c, org, vis, q );
            dfs( grid, r-1, c, org, vis, q );
            dfs( grid, r, c+1, org, vis, q );
            dfs( grid, r, c-1, org, vis, q );
            
            if( !fill( grid, r,c , org ) )
                ans.add( new Pair( r,c ) );
            
            // fill( grid,r,c, vis, color );
        }
        
        for(Pair p : ans){
            grid[p.x][p.y] = color;
        }
        
        return grid;
    }
}