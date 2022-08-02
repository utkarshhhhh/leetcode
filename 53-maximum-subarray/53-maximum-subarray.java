class Solution {
    public int maxSubArray(int[] nums) {
        
        int max = -1000000, cur = 0;
        
        for(int x : nums){
            cur = Math.max(cur+x, x);
            max = Math.max(max,cur);            
        }
        return max;
    }
}