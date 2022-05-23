class Solution {
    public int maximumDifference(int[] nums) {
        
        int min = nums[0], max = nums[0];
        int ans = 0;
        for(int i: nums){
            
            if( max < i ){
                max = i;
                ans = Math.max(max-min, ans);    
            }else if( min > i ){
                min = i;
                max = i;
            }
            
        }
        return ans==0 ? -1 : ans;
    }
}