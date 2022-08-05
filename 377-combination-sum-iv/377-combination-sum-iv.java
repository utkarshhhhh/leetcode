class Solution {
    public int combinationSum4(int[] nums, int target) {
        
        int n = nums.length;
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int j=1 ; j<=target ; j++){
            for(int i=1 ; i<=n ; i++){
            
                if( j-nums[i-1] >=0 ){
                    // System.out.println( dp[ j-nums[i-1] ] );
                    dp[j] += dp[ j-nums[i-1] ];
                }
                
            }
        }
        return dp[target];
    }
}