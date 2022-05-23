class Solution {
    public int maximumDifference(int[] nums) {
        
        int min = nums[0], max = nums[0];
        int ans = 0;
        for(int i: nums){
            
            min = Math.min(min,i);
            ans = Math.max(i-min, ans);    
            
        }
        return ans==0 ? -1 : ans;
    }
}