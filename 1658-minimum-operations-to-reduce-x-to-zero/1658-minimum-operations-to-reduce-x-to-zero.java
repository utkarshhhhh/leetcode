class Solution {
    
    public int bs( int[] arr, int x ){
        int i=0 , j = arr.length-1;
        
        while( i<j ){
            
            int m = (i+j)/2;
            if( arr[m] == x ){
                return m+1;
            }
            
            if( arr[m] > x ){
                j = m -1;
            }else
                i = m +1;
        }
        return -1;
    }
    
    public int minOperations(int[] nums, int x) {
        
        int n = nums.length;
        int sum = 0;
        
        for(int i=0 ; i<n ; i++){
            sum += nums[i];
        }
        // find max Length of subarray that sums to sum-x;
        int targetSum = sum - x, ans = -1;
        int cur = 0;
        
        for(int l=0 , r=0 ; r<n ; r++){
            
            cur += nums[r];
            
            while( l<=r &&  cur > targetSum ){
                cur -= nums[l++];
            }
            
            if( cur == targetSum ){
                ans = Math.max(ans, r-l+1);
            }
        }
        
        return ans==-1 ? -1 : n-ans;
    }
}