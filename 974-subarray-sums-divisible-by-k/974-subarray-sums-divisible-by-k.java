class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int sum = 0;
        int ans = 0;
        
        map.put( 0, 1 );
        
        for(int i=0 ; i<nums.length ; i++){
            
            sum = (sum+nums[i])%k;
            
            if(sum < 0) sum += k; // handle -ve // for -2 fing 3 
            
            if( map.containsKey( sum ) ){
                ans+=map.get(sum);
            } 
            
            map.put( sum, map.getOrDefault( sum, 0 ) + 1 );
            
        }
        return ans;
        
    }
}