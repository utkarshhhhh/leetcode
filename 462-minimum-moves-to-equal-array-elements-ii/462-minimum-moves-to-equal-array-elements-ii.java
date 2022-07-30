class Solution {
    public int minMoves2(int[] nums) {
        
        Arrays.sort(nums);
        
        int n = nums.length, median = 0;
        
//         if( n%2 == 0 ){
//             median = (nums[n/2] + nums[n/2 - 1])/2;
//         }else{
//             median = nums[n/2];
//         }
        
//         int ans = 0;
        
//         for( int i=0 ; i<n ; i++ ){
//             ans += Math.abs( nums[i] - median );
//         }
        
        
        int ans = 0;
        
        for( int i=0, j=n-1 ; i<j ; i++, j-- ){
            ans += Math.abs( nums[j] - nums[i] );
        }
        
        return ans;
    }
}