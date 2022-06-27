class Solution {
    public int jump(int[] nums) {
        
        int n = nums.length;
//         int[] dp = new int[nums.length];
        
//         Arrays.fill( dp,100000  );
//         dp[0] = 0;
        
//         for(int i=0 ; i<n ; i++ ){
            
//             int k = nums[i];
//             for(int jump = 1 ; jump <= k && jump+i < n ; jump++   ){
//                 dp[jump + i] = Math.min( dp[i]+1, dp[jump+i] );
//             }
            
//         }
//         return dp[n-1];
        
        int cur = 0, max = 0, nextMax = 0;
        int jump=0;
        
        while( cur != n-1 ){
            
            nextMax = Math.max( nextMax, cur + nums[cur] );
            
            if(cur == max){ 
                jump++;
                max = nextMax;
            }
            cur++;
        }
        return jump;
    }
}