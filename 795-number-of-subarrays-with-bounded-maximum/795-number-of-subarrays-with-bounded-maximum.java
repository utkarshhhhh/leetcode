class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        
        int s = -1, e = -1, ans = 0;
        
        for(int i=0 ; i<nums.length ; i++){
            
            if( nums[i] >= left && nums[i] <= right ){
                e = i;
            }else if(nums[i] > right){
                s = i;
                e = i;
            }else{
                
            }
            ans += e-s;
        }
        return ans;
    }
}