class Solution {
    
    
    private int[] d = { 0,1,0,-1,0 };
    public void dfs(char[][] grid , int r, int c){
        
        grid[r][c] = '0';
        int n = grid.length , m = grid[0].length;
        
        for(int i=0 ; i<4 ; i++){
            int x = r + d[i];
            int y = c + d[i+1];
            if( x >=0 && x < n && y >=0 && y < m && grid[x][y] == '1' ){
                dfs(grid,x,y);
            }
        }
        
    }
    
    
    public int numIslands(char[][] grid) {
    
        int count = 0;
        int n = grid.length , m = grid[0].length;
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                
                if( grid[i][j] == '1' ){                
                    dfs( grid, i, j );                        
                    count++;
                }                
            }
        }        
        return count;
    }
}