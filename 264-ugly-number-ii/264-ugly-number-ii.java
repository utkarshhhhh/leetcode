class Solution {
    public int nthUglyNumber(int n) {
        
        int[] dp = new int[n+1];
        dp[1] = 1;
        int two = 1, three = 1, five = 1;
        
        for(int i=2 ; i<=n ; i++){
            
            int min = Math.min( 2*dp[two], Math.min( 3*dp[three], 5*dp[five] ) );
            dp[i] = min;
            
            if( min == 2*dp[two] ){
                two += 1;
            }
            
            if( min == 3*dp[three] ){
                three += 1;
            }
            
            if( min == 5*dp[five] ){
                five += 1;
            }
            
        }
        
        return dp[n];
    }
}