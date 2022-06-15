class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 0;
        
        // Arrays.fill(dp,1);
        
        // for(int i=1 ; i<n ; i++){
        //     for(int j=0 ; j<i ; j++){
        //         if( nums[i] > nums[j]  ){
        //             dp[i] = Math.max(dp[j] + 1, dp[i] );
        //         }
        //     }
        //      ans = Math.max(ans, dp[i]);
        // }
        
        for(int x : nums){
            
            int l = 0, h = ans;
            
            while( l < h ){
                
                int m = l + (h-l)/2;
                if( dp[m] >= x ){
                    h = m;
                }else{
                    l = m+1;
                }    
            }
            
            dp[l] = x;
            if( l==ans ) ans++;
            
        }
        
        return ans;
    }
}