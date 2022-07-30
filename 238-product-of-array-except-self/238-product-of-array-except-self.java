class Solution {
    public int[] productExceptSelf(int[] nums) {
     
        int x = 1;
        int[] ans = new int[nums.length];
        // ans[0] = 1;
        for(int i=0 ; i<nums.length ; i++){
            
            ans[i] = x;
            x = x*nums[i];
        }
        
        x = 1;
        for(int i=nums.length-2 ; i>=0 ; i--){
            
            x = x*nums[i+1];
            ans[i] = ans[i]*x;
        }
        return ans;
    }
}