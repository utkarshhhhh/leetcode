class Solution {
    public int maxDistToClosest(int[] seats) {
        
        int left = -1;
        int ans = 0, i;
        for( i=0 ; i<seats.length ; i++){
            
            if( seats[i] == 1 ){                
                ans = left < 0 ? i : Math.max( ans, (i-left)/2 );
                left = i;
            }            
        }
        
        ans = Math.max( ans, (i-1 -left) );
        return ans;
    }
}