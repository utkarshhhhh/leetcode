class Solution {
    
    public int[] getLps(String s){
        
        int n = s.length(), i=1, hi = 0, lo = 0;
        int[] lps = new int[n];
        
        while( i<n ){
            
            if( hi<i ){
                hi = lo = i;
                
                while( hi<n && s.charAt(hi) == s.charAt(hi-lo) ){
                    hi++;
                }
                hi--;
                lps[i] = hi-lo+1;
            }else{
                
                int k = i-lo;
                if( lps[k] < hi - i + 1 ){
                    lps[i] = lps[k];
                }else{                    
                    lo = i;
                    
                    while( hi<n && s.charAt(hi) == s.charAt(hi-lo) ){
                        hi++;
                    }
                    hi--;
                    lps[i] = hi-lo+1;
                }                
            }
            i++;
        }
        return lps;
    }
    
    public long sumScores(String s) {
        
        int[] lps = getLps(s);
        
        long ans = 0;
        
        for(int x : lps){
            ans += x;
        }
        
        return ans + s.length();
        
    }
}