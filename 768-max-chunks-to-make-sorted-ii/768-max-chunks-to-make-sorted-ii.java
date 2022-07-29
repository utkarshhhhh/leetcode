class Solution {
    public int maxChunksToSorted(int[] arr) {
        
        int min = Integer.MAX_VALUE, n = arr.length;
        int[] minA = new int[n];
        
        for(int i=n-1 ; i>=0 ; i--){
            min = Math.min(min, arr[i]);
            minA[i] = min;
        }
        
        int ans = 1, max = Integer.MIN_VALUE; 
        for(int i=0 ; i<n-1 ; i++){
            max = Math.max(max, arr[i]);
            if( max <= minA[i+1] ) ans++;
        }
        return ans;
    }
}