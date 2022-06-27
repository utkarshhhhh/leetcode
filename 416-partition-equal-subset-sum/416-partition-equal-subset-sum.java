class Solution {
    public boolean canPartition(int[] nums) {
        
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        
        if( sum%2 == 1 ) return false;
        
        int tar = sum/2 ;
        int n = nums.length;
        
        boolean[][] dp = new boolean[ tar + 1 ][ n+1 ];
        
        Arrays.fill( dp[0], true );
        
        for( int t=1 ; t<=tar ; t++  ){            
            for(int i = 1 ; i <= n ; i++){
                
                int num = nums[i-1];
                if( t-num >= 0 ){
                    dp[t][i] = dp[t-num][i-1] || dp[t][i-1];
                }else
                    dp[t][i] = dp[t][i-1];
            }       
        }
        
        return dp[tar][n];
    }
}