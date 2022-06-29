class Solution {
    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int sum = 0, ans = 0;
        
        map.put(0,1);
        for( int x : nums ){
            
            sum += x;
            
            if( map.containsKey( sum - k ) ){
                ans += map.get( sum-k );
            }
            map.put( sum, map.getOrDefault( sum, 0 ) + 1 );
        }
        return ans;
    }
}