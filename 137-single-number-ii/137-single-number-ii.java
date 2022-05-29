class Solution {
    public int singleNumber(int[] nums) {
        
//         int tn0 = Integer.MAX_VALUE, tn1 = 0, tn2 = 0;

//         for(int i=0 ; i<nums.length ; i++){
                
//             int mask0 = tn0&nums[i];
//             int mask1 = tn1&nums[i];
//             int mask2 = tn2&nums[i];
            
//             tn0 = tn0&(~mask0);
//             tn1 = tn1&(~mask1);
//             tn2 = tn2&(~mask2);
            
//             tn0 |= mask2;
//             tn1 |= mask0;
//             tn2 |= mask1;
//         }
//         return tn1;
        int x1 = 0, x2 = 0, x3 = 0;
        
        for (int i = 0; i < nums.length; i ++) {
            // x3 ^= x2 & nums[i];
            x2 ^= x1 & nums[i];
            x1 ^= (~x2) & nums[i];
        }
        return x1;
    }
}