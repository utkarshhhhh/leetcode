class Solution {
    public int jump(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[nums.length];
        
        Arrays.fill( dp,100000  );
        dp[0] = 0;
        
        for(int i=0 ; i<n ; i++ ){
            
            int k = nums[i];
            for(int jump = 1 ; jump <= k && jump+i < n ; jump++   ){
                dp[jump + i] = Math.min( dp[i]+1, dp[jump+i] );
            }
            
        }
        return dp[n-1];
    }
}