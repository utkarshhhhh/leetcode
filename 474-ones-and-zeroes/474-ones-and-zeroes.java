class Solution {
    
    class pair{
        int zero, one;
        
        pair(int z,int o){
            zero = z;
            one = o;
        }
    }
    
    int[][][] dp ;
    public int helper(pair[] p,int idx, int m, int n){
        
        if( idx == p.length || (m == 0 && n == 0) ){
            return 0;
        }
        
        if( dp[idx][m][n] != -1 ){
            return dp[idx][m][n];
        }
        
        if( m < p[idx].zero || n < p[idx].one ){
            return dp[idx][m][n] = helper(p,idx+1,m,n);
        }
        
        int inc = helper(p,idx+1,m - p[idx].zero, n-p[idx].one) + 1;
        int not = helper(p,idx+1,m,n);
        
        return dp[idx][m][n] = Math.max( not , inc );
    }
    
    
    
    public int findMaxForm(String[] strs, int m, int n) {
        
        pair[] p = new pair[ strs.length ];
        int idx = 0;
        for(String s : strs){
            
            int z = 0, o = 0;
            for( int i=0 ;i<s.length() ; i++){
                if( s.charAt(i) == '0' ) z++;
                else o++;
            }
            p[idx++] = new pair( z,o );
            
        }
        
        dp = new int[p.length][101][101];
        
        for(int[][] d : dp){
            for(int[] pd : d)
                Arrays.fill( pd,-1 );
        }
        
        return helper( p,0,m,n );
        
        
    }
}