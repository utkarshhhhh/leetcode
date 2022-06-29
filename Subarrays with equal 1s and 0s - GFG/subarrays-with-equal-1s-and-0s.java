// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.lang.*;
import java.io.*;
class Driverclass
 {
	public static void main (String[] args) {
	   
	   Scanner in = new Scanner(System.in);
	   int t= in.nextInt();
	   while(t-->0){
	       
	       int n = in.nextInt();
	       int [] arr= new int[n];
	       for(int i=0;i<n;i++) {
	           arr[i] = in.nextInt();
	       }
	       System.out.println(new Solution().countSubarrWithEqualZeroAndOne(arr, n));
	   }
	 }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int arr[], int n)
    {
        // add your code here
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int ans = 0, sum=0;
        for(int i : arr){
            
            sum += i==1 ? 1 : -1;
            
            if( map.containsKey( sum ) ){
                ans += map.get( sum );
            }
            map.put( sum, map.getOrDefault( sum,0 ) + 1 );
        }
        return ans;
    }
}


