class Solution {
    public int maxProduct(int[] nums) {
        // prefix suffix approach
        
//         int ans = Integer.MIN_VALUE, mul = 1;
        
//         for(int x : nums){
            
//             mul = mul*x;
//             ans = Math.max(mul, ans);
//             if( mul==0 ) mul = 1;
//         }
        
//         mul = 1;
//         for(int i=nums.length-1 ; i>=0 ; i--){
            
//             mul = mul*nums[i];
//             ans = Math.max(mul, ans);
//             if( mul==0 ) mul = 1;
//         }
//         return ans;
        
        int min = 1, max = 1, ans = Integer.MIN_VALUE;
        
        for( int x : nums ){
            
            if( x>=0 ){
                
                max = Math.max( max*x, x );
                min = Math.min( min*x, x );
                
            }else{
                int temp = max;
                max = Math.max( min*x, x );
                min = Math.min( temp*x, x );
                
            }
            ans = Math.max(ans, max);
        }
        
        return ans;
    }
}