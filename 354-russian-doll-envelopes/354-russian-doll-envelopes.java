class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        if(envelopes.length < 2) return envelopes.length;
        
        Arrays.sort(envelopes, (a,b)->{
            return a[0]==b[0] ? b[1]-a[1] : a[0]-b[0];
        } );
        
        int[] dp = new int[envelopes.length];
        int size = 0;
        
        for(int[] env : envelopes){
            
            int l=0, h = size;
            
            while( l < h){
                
                int mid = l + (h-l)/2;
                
                if( dp[mid] >= env[1] ){
                    h = mid;
                }else{
                    l = mid+1;
                }
                
            }
            
            dp[l] = env[1];
            if( l == size ) size++;
            
        }
        
        
        return size;
    }
    
    // class EnvelopeComparator implements Comparator<int[]> {
    //     public int compare(int[] e1, int[] e2) {
    //         return e1[0] == e2[0] ? e2[1] - e1[1] : e1[0] - e2[0];
    //     }
    // }
}