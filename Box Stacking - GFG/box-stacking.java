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
            String[] s1 = br.readLine().trim().split(" ");
            int[] height = new int[n];
            for(int i = 0; i < n; i++){
                height[i] = Integer.parseInt(s1[i]);
            }
            String[] s2 = br.readLine().trim().split(" ");
            int[] width = new int[n];
            for(int i = 0; i < n; i++){
                width[i] = Integer.parseInt(s2[i]);
            }
            String[] s3 = br.readLine().trim().split(" ");
            int[] length = new int[n];
            for(int i = 0; i < n; i++){
                length[i] = Integer.parseInt(s3[i]);
            }
            Solution obj = new Solution();
            System.out.println(obj.maxHeight(height, width, length, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    static class Box implements Comparable<Box>{
        int h,w,l;
        
        Box(int x,int y, int z){
            h = x;
            w = y;
            l = z;
        }
        
        public int compareTo(Box b){
            return b.w - this.w; 
        }
        
    }
    
    public static int maxHeight(int[] height, int[] width, int[] length, int n)
    {
        // Code here
        
        // initialization
        Box[] Arr = new Box[n];
        for(int i=0 ; i<n ; i++){
            Arr[i] = new Box( height[i], width[i], length[i] );
        }
        
        Box[] arr = new Box[3*n];
        for(int i=0 ; i<n ; i++ ){
            
            Box cur = Arr[i];
            arr[3*i] = new Box( cur.h, Math.max( cur.w, cur.l ), Math.min( cur.w, cur.l )  ); 
            arr[3*i +1] = new Box( cur.w, Math.max( cur.h, cur.l ), Math.min( cur.h, cur.l )  ); 
            arr[3*i +2] = new Box( cur.l, Math.max( cur.w, cur.h ), Math.min( cur.w, cur.h )  ); 
            
        }
        
        // I. end
        
        Arrays.sort(arr);
        
        int[] dp = new int[3*n];
        
        for(int i=0 ; i<3*n ; i++)
            dp[i] = arr[i].h;
        
        
        
        for(int i=1 ; i<3*n ; i++){
            
            Box cur = arr[i];
            int val = 0;
            for(int j=0 ; j<i ; j++){
                
                Box prev = arr[j];
                if( prev.w > cur.w && prev.l > cur.l ){ //
                    val = Math.max(val, dp[j]);
                }
                
            }
            dp[i] = val + cur.h;
        }
        
        int max = 0;
        for(int x : dp)
            max = Math.max(max, x);
        return max;
    }
}