class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 1;
        
        Arrays.fill(dp,1);
        
        for(int i=1 ; i<n ; i++){
            for(int j=0 ; j<i ; j++){
                if( nums[i] > nums[j]  ){
                    dp[i] = Math.max(dp[j] + 1, dp[i] );
                }
            }
             ans = Math.max(ans, dp[i]);
        }
        
        return ans;
    }
}