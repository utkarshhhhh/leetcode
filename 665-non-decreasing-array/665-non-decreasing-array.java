class Solution {
    public boolean checkPossibility(int[] nums) {
        
        int n = nums.length;
//         int[] dp = new int[n];
//         Arrays.fill(dp, 1);
        
//         for(int i=1 ; i<n ; i++){
//             for(int j=0 ; j<i ; j++){
//                 if( nums[i] >= nums[j] ){
//                     dp[i] = Math.max( dp[i], dp[j]+1 );
//                 }
//             }
//         }
        
//         int max = 0;
        
//         for(int x : dp) max = Math.max(x, max);
        
//         return max+1 >= n;
        
        int count = 0;
        for(int i=1 ; i<n ; i++){
            
            if( nums[i] < nums[i-1] ){
                
                if(count > 0) return false;
                count++;
                
                if( i-2>=0 && ( nums[i-2] > nums[i] ) ){
                    nums[i] = nums[i-1];
                }
            }
        }
        
        return true;
    }
}