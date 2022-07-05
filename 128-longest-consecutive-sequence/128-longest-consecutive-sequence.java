class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        
        for(int x : nums){
            
            if( map.containsKey( x ) ){
                continue;
            }else{
                
                int next = x, prev = x;
                
                if( map.containsKey( x-1 ) ){
                    prev = x - map.get(x-1);
                }
                
                if( map.containsKey( x+1 ) ){
                    next = x + map.get(x+1);
                }
                
                int len = next - prev + 1;
                
                if( prev!=x && next!=x ) map.put(x,1);
                
                map.put(next, len);
                map.put( prev, len );
                
                ans = Math.max(ans, len);
            }
            
        }
        return ans;
    }
}