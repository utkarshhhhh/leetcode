// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine().trim();
            Solution obj = new Solution();
            System.out.println(obj.getSubstringWithEqual012(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long getSubstringWithEqual012(String str) 
    { 
        // code here
        long ans = 0;
        HashMap<String, Integer> map = new HashMap<>();
        
        int n = str.length();
        
        int z=0, o=0, t=0;
        map.put( (z-o) + "."+ (t-o) , 1 ); // z-o . t-o
        
        for( int i=0 ; i<n ; i++ ){

            char c = str.charAt(i);
            
            z = z + (c=='0'?1:0);
            o = o + (c=='1'?1:0);
            t = t + (c=='2'?1:0);
            
            String cur = (z-o) + "."+ (t-o) ;
            if( map.containsKey( cur ) ){
                ans += map.get(cur);
            }
            map.put( cur, map.getOrDefault(cur, 0) + 1 );
        }
        return ans;
    }
} 