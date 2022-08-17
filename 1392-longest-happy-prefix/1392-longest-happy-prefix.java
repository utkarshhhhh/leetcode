class Solution {
    public String longestPrefix(String s) {
     
        int n = s.length();
        int[] lps = new int[n];
        
        int i=1, len = 0;
        while( i<n ){
            
            if( s.charAt(i) == s.charAt(len) ){
                lps[i] = len+1;
                i++;
                len++;                
            }else if( len == 0 ){
                lps[i] = 0;
                len = 0;
                i++;
            }else{
                len = lps[len-1];
            }
            
        }
        
        int maxLen = lps[n-1];
        
        return s.substring(0,maxLen);
    }
}