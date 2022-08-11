class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        
        Arrays.sort(nums);
        
        int n = nums.length;
        
        int lo = nums[n-1], hi = nums[n-1] - nums[0] ;
        
        for(int i=0 ; i<n-1 ; i++){
            lo = Math.min(lo, nums[i+1] - nums[i]);
        }
        
        while( lo<hi ){
            
            int mid = (lo+hi)>>1;
            int count = 0;
            
            for( int i=0, j = i ; i<n ; i++ ){
                
                while( j<n && nums[j] - nums[i] <= mid ){
                    j++;
                }
                count += j-i -1;
            }
            
            
            if(count < k){
                lo = mid + 1;
            }else{
                hi = mid;
            }
            
        }
        return lo;
        
    }
}