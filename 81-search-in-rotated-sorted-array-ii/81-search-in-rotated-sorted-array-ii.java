class Solution {
    public boolean search(int[] nums, int target) {
        
        int lo = 0, hi = nums.length-1;
        
        while( lo <= hi ){
            
            int m = (lo+hi)>>1;
            
            if( nums[m] == target ) return true;
            
            if( nums[m] < nums[hi] ){
                if( nums[m] <= target && nums[hi] >= target ){
                    lo = m+1;
                }else{
                    hi = m-1;
                }
            }else if( nums[hi] < nums[m] ){
                if( nums[lo] <= target && nums[m] >= target ){
                    hi = m-1;
                }else{
                    lo = m+1;
                }
            }else{
                hi--;
            }
            
        }
        return false;
    }
}