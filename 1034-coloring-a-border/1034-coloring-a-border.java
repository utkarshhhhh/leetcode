class Solution {
    
    class Pair{
        int x, y;
        
        Pair( int i, int j){
            x = i;
            y = j;
        }        
    }
    
    public void dfs( int[][] grid, int r, int c, int org ){
        
        int n = grid.length , m = grid[0].length ;
        
        if( r<0 || r>=n || c<0 || c>=m || grid[r][c] != org ){
            return ;
        }
        
        grid[r][c] = -grid[r][c];
        
        dfs( grid, r+1, c, org );
        dfs( grid, r-1, c, org );
        dfs( grid, r, c+1, org );
        dfs( grid, r, c-1, org );
        
        fillColor( grid, r, c, org );
    }
    
    public void fillColor(int[][] grid, int r, int c, int color){

        int n = grid.length , m = grid[0].length ;
        // check if ander ka h 
        boolean left = r>0 ? Math.abs(grid[r-1][c]) == color : false;
        boolean right = r<n-1 ? Math.abs(grid[r+1][c]) == color : false;
        boolean up = c>0 ? Math.abs(grid[r][c-1]) == color : false;
        boolean down = c<m-1 ? Math.abs(grid[r][c+1]) == color : false;
        
        if( (left&&right&&up&&down) ){
            grid[r][c] = color;
        }
    }
    
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
    
        int org = grid[row][col];
        
        dfs( grid, row, col, org );
        
        for(int i=0 ; i<grid.length ; i++){
            for(int j=0 ; j<grid[0].length ; j++){
                if( grid[i][j] < 0 )    grid[i][j] = color;
            }
        }
        
        return grid;
    }
}