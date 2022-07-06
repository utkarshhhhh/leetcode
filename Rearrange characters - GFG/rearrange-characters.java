// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());
			while (t-- > 0) {
				String str = br.readLine();
				Solution ob= new Solution();
				String str1 = ob. rearrangeCharacters(str);
				
        		int flag=1;
        	    int[] c = new int[26];
        	    Arrays.fill(c,0);
        	    for(int i=0; i<str.length(); i++)
        	        c[str.charAt(i)-'a']+=1;
        	    int f = 0;
        	    int x = (str.length()+1)/2;
        	    for(int i=0; i<26; i++)
        	    {
        	        if(c[i]>x)
        	            f = 1;
        	    }
        	    if(f == 1)
        	    {
        	        if(str1=="-1")
        	            System.out.println(0);
            	    else
            	        System.out.println(1);
        	    }
        	    else
        	    {
            	    int[] a = new int[26];
        	        Arrays.fill(a,0);
            	    int[] b = new int[26];
        	        Arrays.fill(b,0);
            	    for(int i=0; i<str.length(); i++)
            	        a[str.charAt(i)-'a']+=1;
            	    for(int i=0; i<str1.length(); i++)
            	        b[str1.charAt(i)-'a']+=1;
            	        
            	    for(int i=0; i<26; i++)
            	        if(a[i]!=b[i])
            	            flag = 0;
            	    
            	    for(int i=0;i<str1.length();i++)
            	    {
            		    if(i>0)
            		        if(str1.charAt(i-1)==str1.charAt(i))
            			        flag=0;
            	    }
            	    if(flag==1)
            		    System.out.println(1);
            	    else
            	        System.out.println(0);
        	    }
			}
		} catch (Exception e) {

		}
	}
}// } Driver Code Ends


class Solution
{
    static class pair{
        char c;
        int n;
        pair(char a, int b){
            c = a;
            n = b;
        }
    }
	public static String rearrangeCharacters(String str) {
	
		//code here
		int n = str.length();
		int[] hash = new int[26];
		
		for(int i=0 ; i<n ; i++){
		    hash[ str.charAt(i) - 'a' ]++;
		}
		
		PriorityQueue<pair> pq = new PriorityQueue<>( (a,b)->{
		    return b.n - a.n;
		} );
		
		for( int i=0 ; i<26 ; i++ ){
		    if( hash[i] > 0 ) pq.add( new pair( (char)(i+'a'), hash[i] ) );
		}
		
// 		if( pq.poll().n > (n+1)/2 ){
// 		    return "-1";
// 		}
		
		StringBuilder sb = new StringBuilder();
		
		while( pq.size() > 1 ){
		    pair p1 = pq.poll();
		    pair p2 = pq.poll();
		    
		    sb.append( p1.c );
		    sb.append( p2.c );
		    
		    if( --p1.n > 0 ){
		        pq.offer( p1 );
		    }    
		    
		    if( --p2.n > 0 ){
		        pq.offer( p2 );
		    }    
		}
		
	    if( pq.size() == 1 ){
	        if( pq.peek().n > 1 ) return "-1";
	        sb.append( pq.peek().c );
	    }
	    
	    return sb.toString();
	}
    
}