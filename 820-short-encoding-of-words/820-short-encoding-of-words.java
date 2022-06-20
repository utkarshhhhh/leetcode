class Solution {
    public int minimumLengthEncoding(String[] words) {
        
        Set<String> hash = new HashSet<>( Arrays.asList( words ) );
        
        for( String s : words ){
            
            for(int i=1 ; i<s.length() ; i++){
                hash.remove( s.substring(i) );
            }
            
        }
        int ans = 0;
        for( String s : hash ){
            ans += s.length() + 1;
        }
        
        return ans;
    }
}