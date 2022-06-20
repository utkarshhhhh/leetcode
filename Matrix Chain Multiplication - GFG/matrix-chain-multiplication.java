// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static int helper(int[] arr, int[][] dp, int left, int right){
        
        if( left + 1 == right ){
            return 0;
        }
        
        if( dp[left][right] != -1 ){
            return dp[left][right];
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i=left+1 ; i<right ; i++){
            
            int temp = helper( arr,dp,left,i ) + helper( arr,dp,i, right ) + arr[left]*arr[i]*arr[right];
            
            ans = Math.min( ans, temp );
        }
        
        return dp[left][right] = ans;
    }
    
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        int[][] dp =  new int[N][N];
        
        for(int[] d : dp)
            Arrays.fill( d, -1 );
        
        return helper(arr,dp, 0, N-1);
    }
}