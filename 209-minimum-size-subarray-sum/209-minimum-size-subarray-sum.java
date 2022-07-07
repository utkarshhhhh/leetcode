class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int len = 1000000;
        int sum = 0, n = nums.length;
        int st = 0;
        for(int i=0 ; i<n ; i++){
            sum += nums[i];
            
            while( st<=i && sum >= target ){
                
                len = Math.min(len, i-st + 1);
                sum -= nums[st++];
            }
        }
        return len==1000000 ? 0 : len;
    }
}