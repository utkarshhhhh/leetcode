class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length==0) return 0;
        
        HashMap<Integer, Integer> map = new HashMap<>(); 
        
        int ans = 0;
        for(int x  : nums){
            
            if( map.containsKey(x) ){
                continue;
            }else{
                
                int next = x ;
                int prev = x ;
                
                if( map.containsKey(x-1) ){
                    prev = x - map.get(x-1);
                }
                if( map.containsKey(x+1) ){
                    next = x + map.get(x+1);
                }
                
                int len = next - prev + 1;
                
                if( next!=x && prev!=x ){
                    map.put( x, 1 );    
                }
                
                map.put( next, len );
                map.put( prev, len );
                
                ans = Math.max( ans, len );
            }
            
        }
        return ans;
    }
}