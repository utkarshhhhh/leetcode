class Solution {
    public int findMinArrowShots(int[][] points) {
        
        Arrays.sort( points , (a,b)->{
            if( a[0] > b[0] )
                return 1;
            else if( a[0] == b[0] )
                return 0;
            else 
                return -1;
                         
        } );
        
        int end = Integer.MAX_VALUE, ans = 0;
        
        for(int[] i : points){
            
            if( end < i[0] ){
                ans++;
                end = i[1];
            }else{
                end = Math.min(end, i[1]);
            }
            
        }
        
        return ans+1;
    }
}