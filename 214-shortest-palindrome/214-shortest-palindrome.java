class Solution {
    
    public int getLps(String s){
        
        int n = s.length(), i=1, len = 0;
        int[] lps = new int[n];
        
        while(i<n){            
            if( s.charAt(i) == s.charAt(len) ){
                lps[i++] = ++len;
            }else if( len == 0 ){
                i++;
            }else{
                len = lps[len-1];
            }            
        }        
        return lps[n-1];
    }
    
    public String rev(String s){        
        return (new StringBuilder(s)).reverse().toString();        
    }
    
    public String shortestPalindrome(String s) {
        
        String newS = s + "." + rev(s);
        int lpsLen = getLps(newS);
        
        return rev( s.substring(lpsLen) ) + s;
    }
}