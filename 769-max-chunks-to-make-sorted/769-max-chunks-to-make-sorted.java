class Solution {
    public int maxChunksToSorted(int[] arr) {
        /*
        app1 : max-min==j-i
        
        */
        
        int max = Integer.MIN_VALUE, count = 0;
        
        for(int i=0 ; i<arr.length ; i++){
            max = Math.max(max, arr[i]);
            
            if(max == i) count++;
            
        }
        
        return count;
    }
}