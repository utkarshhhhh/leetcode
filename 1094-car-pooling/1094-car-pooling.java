class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        int[] len = new int[1001];
        
        for(int[] i : trips){
            len[i[1]] += i[0];
            len[i[2]] -= i[0];
        }
        
        int cap = 0;
        for(int i=0 ; i<1001 ; i++){
            cap += len[i];
            if( cap > capacity ) return false;
        }
        
        // for(int i=0 ; i<10 ; i++){
        //     System.out.print( len[i] + " " );
        // }
        return true;
    }
}