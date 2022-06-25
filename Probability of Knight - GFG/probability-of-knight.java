// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            String []S = s.split(" ");
            int N = Integer.parseInt(S[0]);
            int start_x = Integer.parseInt(S[1]);
            int start_y = Integer.parseInt(S[2]);
            int step = Integer.parseInt(S[3]);
            Solution ob = new Solution();
            double ans = ob.findProb(N, start_x, start_y, step);
            System.out.println(String.format("%.6f", ans));           
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    int[] dirx = { 1, 1, -1, -1, 2, 2, -2, -2 };
    int[] diry = { 2, -2, -2, 2, 1, -1, -1, 1 };
    
    boolean inside(int n, int x, int y){
        return x>=0 && x < n && y>=0 && y < n;
    }
    
    public double findProb(int N, int start_x, int start_y, int step)
    {
        // Code here
        double[][][] dp = new double[N][N][step+1];
        
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                dp[i][j][0] = 1.0;
            }
        }
        
        for(int s = 1 ; s<=step ; s++){
            
            for(int i=0 ; i<N ; i++){
                for(int j=0 ; j<N ; j++){
                
                    double ans = 0;
                    for(int d = 0 ; d<8 ; d++){
                        int x = i + dirx[d];
                        int y = j + diry[d];
                        
                        if( inside( N, x, y ) ){
                            ans += dp[x][y][s-1]/8;
                        }
                        
                    }
                    dp[i][j][s] = ans;
                }
            }
            
        }
        return dp[start_x][start_y][step];
    }
}