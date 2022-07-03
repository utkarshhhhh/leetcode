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
            
            String input[] = read.readLine().split(" ");
            String a = input[0];
            
            Solution ob = new Solution();
            if(ob.sameFreq(a)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    boolean sameFreq(String s) {
        // code here
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char c : s.toCharArray()){
            map.put( c, map.getOrDefault(c,0) + 1 );
        }
        
        // int unq = 0;
        ArrayList<Integer> set = new ArrayList<>();
        
        for( char k : map.keySet() ){
            
            if( !set.contains( map.get(k) ) ){
                // unq++;
                set.add( map.get(k) );
            }
            
        }
        
        if( set.size() > 2 ){
            return false;
        }else if( set.size() == 1 ){
            return true;
        }else{
            
            int x = set.get(0); 
            int y = set.get(1); 
            return x==1 || y==1 ? true : Math.abs(x-y) == 1;
        }
        
    }
}