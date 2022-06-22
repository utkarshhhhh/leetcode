class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
//         int[] dp = new int[ n +1 ];
        
//         dp[1] = nums[0];
        
//         for(int i=2 ; i<=n ; i++ ){
            
//             dp[i] = Math.max( dp[i-1], dp[i-2] + nums[i-1] );
            
//         }
//         return dp[n];
        
        int prev = nums[0], prevprev = 0;
        for(int i=2 ; i<=n ; i++ ){
            int cur = Math.max( prev , prevprev + nums[i-1] );
            prevprev = prev;
            prev = cur;
            // cur = temp;
            
        }
        return prev;
    }
}