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
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] nums)
    {
        // Code here
        int n = nums.length;
        int[] inc = new int[n+1];
        int[] dec = new int[n+1];
        
        Arrays.fill(inc, 1);
        Arrays.fill(dec, 1);
        
        // inc
        for(int i=1  ; i<n ; i++){
            for(int j=0 ; j<i ; j++){
                if( nums[i] > nums[j] && inc[i] < inc[j] + 1 ){
                    inc[i] = inc[j] + 1;
                }
            }
        }
        
        // dec
        for(int i = n-2 ; i>=0 ; i--){
            for(int j = n-1 ; j>i ; j--){
                if( nums[i] > nums[j] && dec[i] < dec[j] + 1 ){
                    dec[i] = dec[j] + 1;
                }
            }
        }
        
        int max = 0;
        
        for(int i=0 ; i<n ; i++){
            max = Math.max( max, inc[i] + dec[i] -1 );
            // max = Math.max( max, dec[i] );
        }
        return max;
    }
}