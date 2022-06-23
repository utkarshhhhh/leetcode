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
            Long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.noOfNumbers(N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static Long noOfNumbers(Long n) {
        // code here
        
        return n - ( n/2 + n/3 + n/5 + n/7 - ( n/6 + n/10 + n/14 + n/15 + n/21 + n/35 )
                + n/30 + n/42 + n/70 + n/105 - n/210
        );
    }
};