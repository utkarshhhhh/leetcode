class Solution {
    public int maxProduct(int[] nums) {
        // prefix suffix approach
        
        int ans = Integer.MIN_VALUE, mul = 1;
        
        for(int x : nums){
            
            mul = mul*x;
            ans = Math.max(mul, ans);
            if( mul==0 ) mul = 1;
        }
        
        mul = 1;
        for(int i=nums.length-1 ; i>=0 ; i--){
            
            mul = mul*nums[i];
            ans = Math.max(mul, ans);
            if( mul==0 ) mul = 1;
        }
        return ans;
    }
}