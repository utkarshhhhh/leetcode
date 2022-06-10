class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length() == 0 ) return 0;
        
        HashMap<Character, Integer> hash = new HashMap<>();
        
        int ans = 0;
        for( int i=0 , j = 0; i<s.length()  ; i++){
            
            char c = s.charAt(i);
            
            if( hash.containsKey(c) ){
                j = Math.max( hash.get(c) + 1 ,j);
            }   
            
            hash.put( c, i );            
            ans = Math.max( ans, i-j + 1 );            
        }
        return ans;
    }
}