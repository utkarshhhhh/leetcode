class Solution {
    public int[] productExceptSelf(int[] nums) {
     
        int x = 1;
        int[] ans = new int[nums.length];

        for(int i=0 ; i<nums.length ; i++){            
            ans[i] = x;
            x = x*nums[i];
        }
        
        x = 1;
        for(int i=nums.length-1 ; i>=0 ; i--){                        
            ans[i] = ans[i]*x;
            x = x*nums[i];
        }
        
        return ans;
    }
}