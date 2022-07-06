class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        
        int ans = 0, sum = 0;
        for(int i=0 ; i<nums.length ; i++){
            
            sum += nums[i]%2==1 ? 1 : 0;
            
            map.put(sum, map.getOrDefault(sum, 0)+1);
            
            if( map.containsKey( sum-k ) ){
                ans += map.get( sum-k );
            }
        }
        
        return ans;
    }
}