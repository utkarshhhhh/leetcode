class Solution {
    
    private long solve(int[] arr, int x){
        
        long ans = 0;
        
        for(int i : arr){
            ans += Math.abs( x-i );
        }
        return ans;
    }
    public int minMoves2(int[] nums) {
        
        Arrays.sort( nums );
        long ans = 0;
        int n = nums.length;
        if( n%2 == 1 ){
            return (int)solve( nums, nums[n/2] );
        }else{
            return (int) Math.max( solve(nums, nums[n/2]), solve(nums, nums[(n/2) - 1]) );
        }
        
    }
}