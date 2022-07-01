// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            
            int[] X = new int[N];
            int[] Y = new int[N];
            
            for(int i=0; i<N; i++)
            {
                X[i] = Integer.parseInt(S1[i]);
                Y[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.numOfPairs(X,Y,N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numOfPairs(int[] X, int[] Y, int N) {
        // code here
        
        HashMap<Integer, Integer> x = new HashMap<>();
        HashMap<Integer, Integer> y = new HashMap<>();
        HashMap<String, Integer> str = new HashMap<>();
        
        int ans = 0;
        for(int i=0 ; i<N ; i++){
        
            if( x.containsKey( X[i] ) ){
                ans += x.get( X[i] );
            }
            if( y.containsKey( Y[i] ) ){
                ans += y.get( Y[i] );
            }
         
            // sub 2*[x,y] coz once ans will inc by x second by y butnot possible ie same points
            String s = X[i] + "#" + Y[i];
            
            if( str.containsKey( s ) ){
                ans -= 2*str.get(s);
            }
            
            x.put( X[i], x.getOrDefault( X[i], 0 ) + 1 );
            y.put( Y[i], y.getOrDefault( Y[i], 0 ) + 1 );
            str.put( s, str.getOrDefault( s, 0 ) + 1 );
            
        }
        return ans;
    }
};