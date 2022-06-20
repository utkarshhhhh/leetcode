class Solution {
    
    int[][][][] dp;
    
    public int helper( int[][] grid, int r1, int c1, int r2, int c2  ){
        
        int n = grid.length;
        if( r1 >= n || c1 >= n || r2 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1 ){
            return Integer.MIN_VALUE;
        }
        
        if( dp[r1][c1][r2][c2] != 0 )
            return dp[r1][c1][r2][c2];
            
        if( r1 == n-1 && c1 == n-1  ){
            return grid[r1][c1];
        }
        
        if( r2 == n-1 && c2 == n-1  ){
            return grid[r2][c2];
        }
        
        int ans = 0;
        if( r1 == r2 && c1 == c2 ){
            ans = grid[r1][c1];
        }else{
            ans = grid[r1][c1] + grid[r2][c2] ;
        }
        // right and down
        int dd = helper( grid, r1+1, c1, r2+1, c2 );
        int dr = helper( grid, r1+1, c1, r2, c2+1 );
        int rr = helper( grid, r1, c1+1, r2, c2+1 );
        int rd = helper( grid, r1, c1+1, r2+1, c2 );
        
        int rmax = Math.max( rr ,rd );
        int dmax = Math.max( dd , dr );
        
        ans += Math.max( dmax, rmax );
        return dp[r1][c1][r2][c2] = ans;
    }
    
    public int cherryPickup(int[][] grid) {
        
        int n = grid.length;
        dp = new int[n][n][n][n];
        
        int ans = helper(grid,0,0,0,0);
        return Math.max(0, ans);
    }
}