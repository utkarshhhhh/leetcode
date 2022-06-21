class Solution {
    
    public int helper(int[] arr, int left, int right){
        
        if( left + 1 == right ){
            return 0;
        }
        
        int ans = 0;
        for(int i=left+1 ; i<right ; i++){
            
            int cur = helper( arr, left, i ) + helper( arr, i, right ) + arr[left]*arr[i]*arr[right];
            ans = Math.max( ans, cur );
        }
        return ans;
    }
    
    public int helperMemo(int[] arr, int left, int right, int[][] dp){
        
        if( left + 1 == right ){
            return 0;
        }
        
        if( dp[left][right] != -1){
            return dp[left][right];
        }
        
        int ans = 0;
        for(int i=left+1 ; i<right ; i++){
            
            int cur = helperMemo( arr, left, i, dp ) + helperMemo( arr, i, right, dp ) + arr[left]*arr[i]*arr[right];
            ans = Math.max( ans, cur );
        }
        return dp[left][right] = ans;
    }
    
    
    public int maxCoins(int[] nums) {
        
        // init for first and last ballon so we can ignore left and right ballon
        int[] arr = new int[ nums.length + 2 ];
        
        arr[0] = 1;
        arr[arr.length-1] = 1;
        
        for(int i=0 ; i<nums.length ; i++){
            arr[i+1] = nums[i];    
        }
        // init completed
        
        
        int[][] dp = new int[arr.length][arr.length];
        for(int[] d : dp)
            Arrays.fill(d,-1);
        
        return helperMemo( arr,0,arr.length-1 , dp);
    }
}