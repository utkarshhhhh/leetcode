// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            long k = Long.parseLong(br.readLine().trim());
            
            Compute obj = new Compute();
            System.out.println(obj.maxSumWithK(a, n, k));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public long maxSumWithK(long a[], long n, long k)
    {
        int N = (int)n , K = (int)k;
        long[] dp = new long[N];
        long sum = a[0];
        
        dp[0] = sum;
        for(int i=1 ; i<N ; i++){
            sum = Math.max(a[i] , a[i] + sum);
            dp[i] = sum;
        }
        sum = 0;
        for(int i=0 ; i<K ; i++){
            sum += a[i];
        }
        
        long result = sum;
        for(int i = K ; i<N ; i++){
            
            sum += a[i] - a[i-K];
            result = Math.max( result, sum );
            result = Math.max( result, sum + dp[i-K] );
        }
        return result;
    }
}