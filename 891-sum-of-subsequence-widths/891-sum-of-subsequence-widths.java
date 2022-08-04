class Solution {
    public int sumSubseqWidths(int[] nums) {
        long ans = 0;
        
        Arrays.sort(nums);
        long mod = (long)1e9+7;
        
        long mul = 1;
        for(int i=0, j=nums.length-1 ; j>=0 ; j--, i++, mul = (2*mul)%mod ){
            
            ans = (ans + mul*( nums[i] - nums[j] ) )%mod;
            
        }
        return (int)ans;
    }
}