// { Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public void topo(Character s, HashMap<Character , ArrayList<Character>> graph, Stack<Character> st, HashSet<Character> vis ){
        
        vis.add(s);
        
        for( Character nbr : graph.get( s ) ){
            if( !vis.contains(nbr) )
                topo( nbr, graph, st, vis );
        }
        
        st.push( s );
    }
    
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        
        HashMap< Character , ArrayList<Character> > graph = new HashMap<>();
        
        // for(int i=0 ; i<26 ; i++) graph.add( new ArrayList<>() );
        
        
        for(int i=0 ; i<N-1 ; i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            
            for(int j=0 ; j<Math.min( s1.length(), s2.length()) ; j++ ){
                
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);
                
                if(c1 != c2){
                  ArrayList<Character> list = graph.getOrDefault(c1, new ArrayList<>());
                  list.add( c2 );  
                  graph.put(c1, list);
                  graph.put(c2, graph.getOrDefault(c2, new ArrayList<>()) );
                  break;
                } 
            }
        }
        // graph done
        
        HashSet<Character> vis = new HashSet<>();
        Stack<Character> st = new Stack<>();
        
        for(Character s : graph.keySet() ){
            
            if( !vis.contains( s ) ){
                topo( s, graph, st, vis );
            }
        }
        
        String ans = "";
        
        while( st.size() > 0 ){
            ans += st.pop();
        }
        return ans;
    }
}