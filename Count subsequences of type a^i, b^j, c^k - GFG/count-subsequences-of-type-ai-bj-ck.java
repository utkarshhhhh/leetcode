// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int t = Integer.parseInt(sc.next());
		
		while(t>0)
		{
		    String s = sc.next();
		    
		    Solution T = new Solution();
		    System.out.println(T.fun(s));
		    
		    t--;
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int mod = (int)(1e9+7);
    public int fun(String s)
    {
        // Write your code here
        long a = 0, ab = 0, abc = 0;
        
        for(char c : s.toCharArray() ){
        
            if(c == 'a'){
                a = (2*a + 1)%mod;
            }else if( c=='b' ){
                ab = (2*ab + a)%mod;
            }else{
                abc = (2*abc + ab)%mod;
            }
            
        }
        return (int)abc;
    }
}