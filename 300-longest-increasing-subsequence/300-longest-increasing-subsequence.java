class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        int[] hash = new int[n];
        
        Arrays.fill(hash, 1);
        int ans = 1;
        for(int i=1 ; i<n ; i++){
            for(int j=0 ; j<i ; j++){
                
                if( nums[i] > nums[j] ){
                    hash[i] = Math.max( hash[i], hash[j]+1 );
                }
                
            }
            ans = Math.max(ans, hash[i]);
        }
        return ans;
    }
}