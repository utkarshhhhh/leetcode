class Solution {
    public int minDifference(int[] nums) {
        
        Arrays.sort(nums);
        
        if( nums.length <= 4 ){
            return 0;
        }
        
        int n = nums.length;
        return Math.min ( Math.min( nums[n-1] - nums[3], nums[n-2] - nums[2] ), Math.min( nums[n-3] - nums[1], nums[n-4] - nums[0] ) );
        
    }
}