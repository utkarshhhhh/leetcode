class Solution {
    
    int[] d = {0,1,0,-1,0};
    
    public void dfs(int[][] grid, int r, int c){
        
        
        grid[r][c] = 0;
        
        for( int i=0 ; i<4 ; i++ ){
            
            int x = r + d[i];
            int y = c + d[i+1];
            
            if( x>=0 && y>=0 && x<grid.length && y < grid[0].length && grid[x][y] == 1){
                dfs(grid,x,y);            
            }    
         
        }
        
    }
    
    public int numEnclaves(int[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        for(int r=0 ; r<n ; r++){
            if(grid[r][0] == 1)
            dfs(grid,r,0);
            if(grid[r][m-1] == 1)
            dfs(grid,r,m-1);
        }
        
        for(int c=0 ; c<m ; c++){
            if(grid[0][c] == 1)
            dfs(grid,0,c);
            if(grid[n-1][c] == 1)
            dfs(grid,n-1,c);
        }
        
        int ans = 0;
        for(int r=0 ; r<n ; r++){
            for(int c=0 ; c<m ; c++){
                ans += grid[r][c];
            }
        }
        return ans;
    }
}