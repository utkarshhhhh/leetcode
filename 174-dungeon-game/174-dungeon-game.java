class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        
        // we are  going to bottomright so ij  indicate max value it should have to reach nm
        // but in oppsite appr it shows max val to reach ij from 00
        
        // its like false hope that choose min on rn but later on find out that a bigger one is waiting for you
        int n = dungeon.length , m = dungeon[0].length;
        
        int[][] dp = new int[n][m];
        for(int i = n-1 ; i>=0 ; i--){            
            for(int j=m-1 ; j>=0 ; j--){
                
                if( i==n-1 && j==m-1 ){
                    dp[i][j] = Math.max(1, 1 - dungeon[i][j]);
                }else if( i==n-1 ){
                    dp[i][j] = Math.max(1, dp[i][j+1] - dungeon[i][j]);
                }else if( j==m-1 ){
                    dp[i][j] = Math.max(1, dp[i+1][j] - dungeon[i][j]);
                }else{
                    // if -ve automatically add its val
                    dp[i][j] = Math.max(1, Math.min( dp[i+1][j], dp[i][j+1] ) - dungeon[i][j] );
                }
                
            }
        }
        return dp[0][0];
    }
}