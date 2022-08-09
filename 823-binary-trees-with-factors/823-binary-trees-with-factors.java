class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        
        int mod = (int)1e9+7, n = arr.length;
        Arrays.sort(arr);
        long[] dp = new long[n];
        
        Arrays.fill(dp,1);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0 ; i<n ; i++)
            map.put(arr[i], i);
        
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<i ; j++){
                
                int right = arr[i] / arr[j];
                if( arr[i] % arr[j] == 0 && map.containsKey( right )){
                    dp[i] = ( dp[i] + dp[j]*dp[map.get(right)] )%mod;
                }
                
            }
        }
        
        long ans = 0;
        for(long x : dp) ans += x;
        
        return (int)(ans%mod);
    }
}