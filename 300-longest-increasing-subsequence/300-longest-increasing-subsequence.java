class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 0;
        
        dp[0] = 1;
        
        for(int i=1 ; i<n ; i++){
            for(int j=0 ; j<i ; j++){
                if( nums[i] > nums[j]  ){
                    dp[i] = Math.max(dp[j] + 1, dp[i] );
                }
                else
                    dp[i] = Math.max(1, dp[i] );
            }
        }
        
        int max = 0;
        for(int x : dp)
            max = Math.max(max, x);
        
        return max;
        
    }
}