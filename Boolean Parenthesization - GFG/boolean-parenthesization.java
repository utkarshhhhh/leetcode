// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static int bf( String s, int left, int right, int isTrue ){
        
        if( left > right ){
            return 0;
        }
        
        if( left==right ){
            if( isTrue == 1 ){
                return s.charAt(left)=='T' ? 1 : 0;
            }else{
                return s.charAt(left)=='T' ? 0 : 1;
            }
        }
        
        int ans = 0;
        for(int i = left+1 ; i<right ; i += 2){
            
            int leftTrue = bf( s, left, i-1, 1 );
            int leftFalse = bf( s, left, i-1, 0 );
            int rightTrue = bf( s, i+1, right, 1 );
            int rightFalse = bf( s, i+1, right, 0 );
            
            if( s.charAt(i) == '|' ){
                // true = 3 ways 
                
                int trueWale = leftTrue*rightTrue + leftTrue*rightFalse + leftFalse*rightTrue ;
                int falseWale = leftFalse*rightFalse;
                
                if( isTrue == 1 )
                    ans += trueWale;
                else
                    ans += falseWale;
            }else if( s.charAt(i) == '^' ){
                // true = left right diff 
                
                int trueWale =  leftTrue*rightFalse + leftFalse*rightTrue ;
                int falseWale = leftFalse*rightFalse + leftTrue*rightTrue;
                
                if( isTrue == 1 )
                    ans += trueWale;
                else
                    ans += falseWale;
                
            }else{
                
                int trueWale = leftTrue*rightTrue ;
                int falseWale = leftFalse*rightFalse + leftTrue*rightFalse + leftFalse*rightTrue ;
                
                if( isTrue == 1 )
                    ans += trueWale;
                else
                    ans += falseWale;
                
            }
            
        }
        return ans;
    }
    
    static int[][][] dp;
    
    static int helperMemo( String s, int left, int right, int isTrue ){
        
        if( left > right ){
            return 0;
        }
        
        if( dp[isTrue][left][right] != -1 ){
            return dp[isTrue][left][right];
        }
        
        if( left==right ){
            if( isTrue == 1 ){
                return dp[isTrue][left][right] = s.charAt(left)=='T' ? 1 : 0;
            }else{
                return dp[isTrue][left][right] = s.charAt(left)=='T' ? 0 : 1;
            }
        }
        
        int ans = 0;
        for(int i = left+1 ; i<right ; i += 2){
            
            int leftTrue = helperMemo( s, left, i-1, 1 );
            int leftFalse = helperMemo( s, left, i-1, 0 );
            int rightTrue = helperMemo( s, i+1, right, 1 );
            int rightFalse = helperMemo( s, i+1, right, 0 );
            
            if( s.charAt(i) == '|' ){
                // true = 3 ways 
                
                int trueWale = leftTrue*rightTrue + leftTrue*rightFalse + leftFalse*rightTrue ;
                int falseWale = leftFalse*rightFalse;
                
                if( isTrue == 1 )
                    ans += trueWale;
                else
                    ans += falseWale;
            }else if( s.charAt(i) == '^' ){
                // true = left right diff 
                
                int trueWale =  leftTrue*rightFalse + leftFalse*rightTrue ;
                int falseWale = leftFalse*rightFalse + leftTrue*rightTrue;
                
                if( isTrue == 1 )
                    ans += trueWale;
                else
                    ans += falseWale;
                
            }else{
                
                int trueWale = leftTrue*rightTrue ;
                int falseWale = leftFalse*rightFalse + leftTrue*rightFalse + leftFalse*rightTrue ;
                
                if( isTrue == 1 )
                    ans += trueWale;
                else
                    ans += falseWale;
                
            }
            
        }
        return dp[isTrue][left][right] = ans%1003;
    }
    
    
    
    
    static int countWays(int N, String S){
        // code here
        
        dp = new int[2][N][N];
        
        
        for(int[] d : dp[0])
            Arrays.fill(d,-1);
        for(int[] d : dp[1])
            Arrays.fill(d,-1);
        
        return helperMemo(S, 0, N-1, 1);
    }
}