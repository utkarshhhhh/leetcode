class Solution {
    public int search(int[] nums, int target) {
        
        int lo = 0, hi = nums.length-1;
        
        while( lo < hi ){
            
            int m = (lo+hi)>>1;
            
            if( nums[m] == target ){
                return m;
            }
            
            if( nums[m] < nums[hi] ){
                if( nums[m] <= target && nums[hi] >= target ){
                    lo = m+1;        
                }else{
                    hi = m-1;
                }
            }else{
                
                if( nums[m] >= target && nums[lo] <= target ){
                    hi = m-1;
                }else{
                    lo = m+1;
                }
                
            }
            
        }
        return nums[lo] == target ? lo : -1;
    }
}