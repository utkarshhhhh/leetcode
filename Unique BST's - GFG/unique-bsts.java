// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;


 // } Driver Code Ends
//User function Template for Java

class Solution
{
    //Function to return the total number of possible unique BST.
    static int maxx = (int)(1e9+7);
    static int numTrees(int N)
    {
        // Your code goes here
        long[] dp = new long[N+1];
        dp[0] = 1; // changed it acrdng to our ans
        dp[1] = 1;
        
        for(int n=2 ; n<=N ; n++){
            
            // calc-ing catalan no
            for(int i=0, j = n-1 ; i<n ; i++, j--){
                dp[n] = (dp[n] + (dp[i]*dp[j])%maxx )%maxx;
            }
            
        }
        return (int)dp[N];
    }
}


// { Driver Code Starts.

class GFG
{
    public static void main(String args[])
    {
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //taking n
            int n =sc.nextInt();
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling method numTrees() of 
            //class Solution
            System.out.println(ob.numTrees(n));
        }
    }
}
  // } Driver Code Ends