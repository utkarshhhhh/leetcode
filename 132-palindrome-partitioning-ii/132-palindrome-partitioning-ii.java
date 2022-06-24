class Solution {
    
    boolean pal(String s, int i, int j){
        
        // int i = 0 , j = ;
        while( i<j ){
            if( s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
    
    private int helper(String s, int l, int r, int[][] dp, boolean[][] pal){
        
        
        if( dp[l][r] != -1 ){
            return dp[l][r];
        }
        
        // if( pal(s,l,r) ) return dp[l][r] = 0;
        if( pal[l][r] ) return dp[l][r] = 0;
        
        
        int min = 5000;
        for( int i = l ; i<r ; i++ ){
            // int ans = helper( s, l , i-1, dp, pal ) + helper( s, i+1 , r, dp , pal) + 1;
            if( pal[l][i] ){
                int ans = helper( s, i+1, r, dp, pal ) + 1;
                min = Math.min(min, ans);
            }
            
        }
        
        return dp[l][r] = min;
    }
    
    
    public int minCut(String s) {
     
        int n = s.length();
        // int[][] dp = new int[n][n];
        
        // for(int[] d : dp){
        //     Arrays.fill(d, -1);
        // }
        
        boolean[][] pal = new boolean[n][n];
        
        for(int left = n-1; left>=0 ; left--){
            pal[left][left] = true;
            for( int right = left+1 ; right<n ; right++ ){
                pal[left][right] = s.charAt(left)==s.charAt(right) && ( left+1==right || pal[left+1][right-1] );
            }            
        }
        
        // return helper(s, 0, s.length()-1, dp, pal);
        
        
//         for (int i = 0, j = 1; j < s.length(); i++, j++)
// 	    	dp[i][j] = (s.charAt(i) == s.charAt(j)) ? 0 : 1;
    
        int[] dp = new int[n];
        
        for(int r = 1 ; r<n ; r++){
            
            if( pal[0][r] ) continue;
            
            int min = 5000;
            for( int l = r ; l>=1 ; l-- ){                
                if( pal[l][r] ){                    
                    min = Math.min( min, 1 + dp[l-1] );                    
                }                
            }
            dp[r] = min;
        }
        
        return dp[n-1];
    }
}



/*
n3
 
int n = s.length();
        int[][] dp = new int[n][n];
        
        // for(int[] d : dp){
        //     Arrays.fill(d, -1);
        // }
        
        boolean[][] pal = new boolean[n][n];
        
        for(int left = n-1; left>=0 ; left--){
            pal[left][left] = true;
            // dp[left][left] = 1;
            for( int right = left+1 ; right<n ; right++ ){
                pal[left][right] = s.charAt(left)==s.charAt(right) && ( left+1==right || pal[left+1][right-1] );
            }            
        }
        
        // return helper(s, 0, s.length()-1, dp, pal);
        
        
        for (int i = 0, j = 1; j < s.length(); i++, j++)
	    	dp[i][j] = (s.charAt(i) == s.charAt(j)) ? 0 : 1;
    
        
        for(int gap = 2 ; gap<n ; gap++){
            for(int left = 0, right = gap; right<n ; left++, right++){
            
                if(pal[left][right]){
                    // dp[i][right] = 0;
                    continue;
                }
                
                int min = 5000;
                for( int i = left ; i<right ; i++ ){
                
                 min =  Math.min( dp[left][i] + dp[i+1][right] + 1 , min );
                }
                dp[left][right] = min;
            }            
        }
        
        return dp[0][n-1];
    

*/