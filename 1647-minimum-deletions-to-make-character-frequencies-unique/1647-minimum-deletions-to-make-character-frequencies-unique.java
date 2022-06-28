class Solution {
    public int minDeletions(String s) {
        
        int[] hash = new int[26];
        
        for(int i=0 ; i<s.length() ; i++){
            char c = s.charAt( i );
            hash[ c-'a' ]++;        
        }
        
        Arrays.sort( hash );
        int ans = 0;
        int maxFreq = s.length();
        
        for(int i=25 ; i>=0 && hash[i] > 0 ; i--){
            
            if( maxFreq < hash[i] ){
                ans += hash[i]-maxFreq ;
                hash[i] = maxFreq;
            }    
            maxFreq = Math.max(0, hash[i]-1 );
        }
        return ans;
    }
}//  3 3 3