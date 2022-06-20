class Solution {
    
    int[][][] dp ;
    
    private int helper( int[][] grid, int r, int c1, int c2 ){
        
        int m = grid[0].length;
        if( c1 < 0 || c1 == m || c2 < 0 || c2 == m ){ // out of bounds
            return 0;
        }
        
        if( dp[r][c1][c2] != 0 ){               // if already vis
            return dp[r][c1][c2];
        }
        
        int ans = 0;
        if( c1 == c2 ){
            ans = grid[r][c1];                  // pick once if both robots are at same box
        }else{ 
            ans = grid[r][c1] + grid[r][c2]; 
        }
        
        if( r == grid.length-1 ){               // if at last row then cant iterate further
            return ans;
        } 
        
        int cur = 0;
        for(int i=-1 ; i<=1 ; i++){             // make every combination of (c1-1, c1, c1+1)*(c2-1, c2, c2+1)
            int left = helper( grid, r+1, c1+i, c2-1  ); // left and right in terms of diagonals
            int down = helper( grid, r+1, c1+i, c2  ); 
            int right = helper( grid, r+1, c1+i, c2+1  ); 
            
            cur = Math.max(cur, Math.max( left, Math.max(down,right) ) );
        }
        
        return dp[r][c1][c2] = ans + cur;       // store and return
    }
    
    public int cherryPickup(int[][] grid) {
     
        int n = grid.length, m = grid[0].length;
        dp = new int[n][m][m];                  // for storing every possible box --- row, robot1 col, robot2 col
        
        int ans = helper( grid, 0, 0, m-1 );
        
        return ans;
    }
}