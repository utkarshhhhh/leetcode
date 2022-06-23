// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class OptimalStrategy
{
    public static void main (String[] args) {
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total number of testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //taking number of elements
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            //inserting the elements
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
                
           //calling the countMaximum() method of class solve
           System.out.println(new solve().countMaximum(arr, n)); 
        }
    }
    
    
}// } Driver Code Ends



class solve
{
    //Function to find the maximum possible amount of money we can win.
    
    static long helper(int[] arr, int i, int j, long[][] dp){
        
        if( i>=j ) return 0;
        
        if( dp[i][j] != -1 ){
            return dp[i][j];
        }
        
        long left = arr[i] +  Math.min( helper( arr, i+1, j-1, dp ) , helper( arr, i+2, j, dp ) );
        long right = arr[j] +  Math.min( helper( arr, i+1, j-1, dp ) , helper( arr, i, j-2, dp ) );
        
        return dp[i][j] = Math.max( left, right );
    }
    
    static long countMaximum(int arr[], int n)
    {
        // Your code here
        
        long[][] dp = new long[n][n];
        for(long[] d : dp )
            Arrays.fill(d, -1);
            
            
        return helper( arr, 0, n-1, dp );
    }
}
