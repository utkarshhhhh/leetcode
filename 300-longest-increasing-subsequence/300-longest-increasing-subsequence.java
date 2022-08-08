class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        int[] arr = new int[n];
    
        int ans = 0;
        for(int i=0 ; i<n ; i++){
            
            int lo = 0, hi = ans;
            
            while( lo < hi ){
                int mid = (hi+lo)/2;
                if( arr[mid] >= nums[i] ){
                    hi = mid;
                }else{
                    lo = mid+1;
                }
            }
            
            arr[lo] = nums[i];
            if(lo == ans) ans++;
        }
        return ans;
    }
}