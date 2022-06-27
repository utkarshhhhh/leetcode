class Solution {
    
    HashMap<Integer, Boolean> hash = new HashMap<>();
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        int sum = 0;
        
        for(int x : nums){
            sum += x;
        }
        
        if( sum%k != 0 ){
            return false;
        }
        
        
        return helper(nums, 0, k, 1, 0, sum/k );
    }
    
    private boolean helper(int[] nums, int idx, int k, int vis, int curSum, int sum){
        
        if( k==1 ){
            return true;
        }
        
        if( sum < curSum ){
            return false;
        }
        
        if( hash.containsKey( vis ) ){
            return hash.get(vis);
        }
        
        if( curSum == sum ){
            boolean ans = helper(nums, 0, k-1, vis, 0, sum);
            hash.put( vis, ans );
            return ans;
        }
        
        
        
        for(int i = idx ; i<nums.length ; i++){
            
            int cur = 1<<i;
            if( ( (vis>>i)&1 ) != 1 ){
                
                vis ^= cur;
                if ( helper(nums, i+1, k, vis, curSum + nums[i], sum) ) return true;
                vis ^= cur;
                
            }
            
        }
        return false;
    }
}