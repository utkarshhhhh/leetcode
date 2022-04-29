class Solution {
    
    private int[] d = { 0,1,0,-1,0 };
    
    private int dfs(int[][] grid , int r, int c){
        
        grid[r][c] = 0;
        int ans = 1;
        int n = grid.length , m = grid[0].length;
        for(int i=0 ; i<4 ; i++){
            int x = r + d[i];
            int y = c + d[i+1];
            
            if( x>=0 && x < n && y>=0 && y < m && grid[x][y] == 1){
                ans += dfs(grid , x, y);
            }
        }
        return ans;
    }
    
    
    public int maxAreaOfIsland(int[][] grid) {
        
        int n = grid.length , m = grid[0].length;
        int maxAns = 0;
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                
                if( grid[i][j] == 1 ){
                    maxAns = Math.max(maxAns , dfs(grid, i, j));
                }                
            }
        }
        return maxAns;
    }
}