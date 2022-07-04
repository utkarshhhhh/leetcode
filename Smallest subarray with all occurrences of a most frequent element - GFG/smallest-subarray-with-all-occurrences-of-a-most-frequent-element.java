// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java


class Solution{
    
  
    ArrayList<Integer> smallestSubsegment(int a[], int n)
    {
        // Complete the function
        
        int start = 0, last = 0, fr = 0;
        
        HashMap<Integer, Integer> st = new HashMap<>();
        HashMap<Integer, Integer> end = new HashMap<>();
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        for( int i=0 ; i<n ; i++ ){
            if( !st.containsKey(a[i]) ) st.put( a[i], i );
            end.put( a[i], i );
            freq.put( a[i], freq.getOrDefault( a[i], 0 )+1 );
        }
        
        for( int key : a ){
            
            int fre = freq.get(key);
            if( fre > fr ){
                start = st.get(key);
                last = end.get(key);
                fr = freq.get(key);
            }else if( fre == fr ){
                
                if( end.get(key) - st.get(key) < last-start){
                    last = end.get(key);
                    start = st.get(key);
                }
                
            }
            
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=start ; i<=last ; i++){
            ans.add(a[i]);
        }
        return ans;
    }
  
    
}


// { Driver Code Starts.

// Driver class
class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String[] element = line1.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    ArrayList<Integer> res = new ArrayList<Integer>();
		    res = obj.smallestSubsegment(arr, sizeOfArray);
		    for(int i:res)
		        System.out.print(i + " ");
		    System.out.println();
		}
	}
}


            

  // } Driver Code Ends