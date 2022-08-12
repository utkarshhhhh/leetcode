class Solution {
    
    int[] dp = new int[100];
    
    public int solve(String s, int i){
        
        if( i == s.length() ) return 1;
        if( s.charAt(i) == '0' ) return 0;
        
        if( dp[i] != 0 ){
            return dp[i];
        }
        
        int ans = 0;
        
        ans += solve(s, i+1) ;
        
        if( i+1 < s.length()  ){
            
            int num = 10*(s.charAt(i)-'0') + (s.charAt(i+1) -'0');
            
            if( num<=26 ){
                ans += solve(s, i+2 );
            }
            
        }        
        return dp[i] = ans;
        
    }
    
    public int numDecodings(String s) {
        return solve(s,0);
    }
}