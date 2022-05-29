class Solution {
    public int singleNumber(int[] nums) {
        
        
        /* think of it as  
        2 -> count of 2
        1 -> count of 1 
        
        if a NUM exists in 1 then put in 2 ( conunt in 2 means 2nd occurence )
        
        if a NUM  doesnt exists in 2 then put in 1 ( conunt in 1 means 1st occurence )
                 
        when it comes 3rd time then it would exists in both 1 and 2
        first it will be removed from 2 
        then if not in 2 then add it again in 1 (acctually removing it)
        
        simply 
        1st occurence - add to 1
        2nd           - add to 2
        3rd           - add to both
        
        --Do a dry run for [2,2,3,2] for better understanding--
        */
        int x1 = 0, x2 = 0;
        
        for (int i = 0; i < nums.length; i ++) {
            x2 ^= x1 & nums[i];
            x1 ^= (~x2) & nums[i];
        }
        return x1;
    }
}

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