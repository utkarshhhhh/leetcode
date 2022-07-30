class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        
        HashMap<Integer, Integer> hash = new HashMap<>();
        int ans = 0;
        
        for(int i : time){
            
            int rem = i%60;
            
            if( hash.containsKey( (60-rem)%60 ) ){
                ans += hash.get ((60-rem)%60);
            }
            
            
            hash.put( rem, hash.getOrDefault(rem, 0)+1 );
        }
        return ans;
    }
}