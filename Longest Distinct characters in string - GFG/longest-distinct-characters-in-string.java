// { Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String S){
        // code here
        
        HashSet<Character> set = new HashSet<>();
        int ans = 0, cur=0;
        int i=0 , j = 0;
        while( j<S.length() ){
            
            char c = S.charAt(j);
            
            while( set.contains(c)){
                set.remove( S.charAt(i++) );
            }
            
            set.add(c);
            ans = Math.max(ans, set.size() );
            j++;
        }
        return ans;
    }
}