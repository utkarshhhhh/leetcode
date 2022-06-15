class Solution {
    
    public int lcs(String a, String b){
        
        int n = a.length(), m = b.length();
        int[][] dp = new int[n+1][m+1];
        
        for(int i=1 ; i<=n ; i++){
            for(int j=1 ; j<=m ; j++){
        
                if( a.charAt(i-1) == b.charAt(j-1) ){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max( dp[i-1][j], dp[i][j-1] );
                }
            
            }
        }
        return n+m - 2*dp[n][m];
    }
    
    public int longestStrChain(String[] words) {
        
        int n = words.length;
//         int[] dp = new int[n];
//         // int ans = 0;
        Arrays.sort(words, (a,b)->{
            return a.length()-b.length();
        });
// //         dp[0] = 1;
        
// //         for(int i=1 ; i<n ; i++){
// //             for(int j=0 ; j<i ; j++){
// //                 if( lcs( words[i], words[j] ) == 1 ){
// //                     dp[i] = Math.max(dp[j] + 1, dp[i] );
// //                 }
// //                 else
// //                     dp[i] = Math.max(1, dp[i] );
// //             }
// //         }
        
        int max = 0;
//         for(int x : dp)
//             max = Math.max(max, x);
        
//         return max;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String s : words){
            
            String prev = s;
            int cur = 0;
            for(int i=0 ; i<s.length() ; i++){
                
                prev = s.substring(0,i) + s.substring(i+1);
                cur = Math.max(cur,  map.getOrDefault(prev,0) + 1 );
                
            }
            map.put(s, cur);
            max = Math.max(cur,max);
        }
        return max;
    }
}