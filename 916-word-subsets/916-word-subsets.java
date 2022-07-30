class Solution {
    
    public boolean good(int[] arr){
        
        for( int x : arr ){
            if( x > 0 ) return false;
        }
        
        return true;
    }
    
    public List<String> wordSubsets(String[] words1, String[] words2) {
     
        int[] maxHash = new int[26];
        
        for( String s : words2 ){
            int[] hash = new int[26];
            for(int i=0 ; i<s.length() ; i++){
                int c = s.charAt(i) - 'a';
                hash[c]++;
                maxHash[c] = Math.max(hash[c] ,maxHash[c] );
            }                
        }
    
        List<String> ans = new ArrayList<>();
        
        for( String s : words1 ){
            int[] newHash = maxHash.clone();
            for(int i=0 ; i<s.length() ; i++)
                newHash[ s.charAt(i) - 'a' ]--;
            
            if( good(newHash) ) ans.add( s );
        }
    
        return ans;
    }
}