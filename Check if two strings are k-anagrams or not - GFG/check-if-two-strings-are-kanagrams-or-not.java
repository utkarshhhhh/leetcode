// { Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.lang.*;
class GFG {
    public static void main(String[] args)
    {   Scanner sc = new Scanner(System.in);
    	int t=sc.nextInt();
    	while(t-->0)
    	{
    		String str1=sc.next();
    		String str2=sc.next();
    		int k=sc.nextInt();
            Solution ob = new Solution();
    		if (ob.areKAnagrams(str1, str2, k) == true)
    			System.out.println("1");
    		else
    			System.out.println("0");
    	}
    }
}// } Driver Code Ends


//User function template for JAVA

class Solution {
    boolean areKAnagrams(String s1, String s2, int k) {
        // code here
        
        if( s1.length() != s2.length() )
            return false;
        
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];
        for(int i=0 ; i<s1.length() ; i++){
            hash1[ s1.charAt(i) - 'a']++;
            hash2[ s2.charAt(i) - 'a']++;
        }
        int ans = 0;
        for(int i=0 ; i<26 ; i++){
            ans += Math.abs( hash1[i] - hash2[i] );
        }
        return ans <= 2*k;
    }
}