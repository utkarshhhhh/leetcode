// { Driver Code Starts
import java.util.*;
class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			//System.out.println(str.length());
			Solution ob  = new Solution();
			System.out.println(ob.countPS(str));
		t--;
		}
	}
}// } Driver Code Ends


/*You are required to complete below method */

class Solution
{
    long countPS(String str)
    {
        // Your code here
        int n = str.length();
        int mod = (int)(1e9+7);
        long[][] dp = new long[n][n];
        for(int left = n-1 ; left >=0  ; left--){
            
            dp[left][left] = 1;
            for( int right = left+1 ; right<n ; right++ ){
                
                if( str.charAt(left) == str.charAt(right) ){
                    // count leftright -> 1 + left+1,right-1
                    // left+1,right left,right-1 - left+1,right-1
                    
                    dp[left][right] = (1 + dp[left+1][right] + dp[left][right-1])%mod;
                }else{
                    dp[left][right] = (dp[left+1][right] + dp[left][right-1] - dp[left+1][right-1] + mod)%mod;
                }
                
            }
            
        }
        return dp[0][n-1];
    }
}