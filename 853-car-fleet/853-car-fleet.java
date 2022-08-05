class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        int n = speed.length;
        int[][] cars = new int[n][2]; 
        
        for(int i=0 ; i<n ; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        
        Arrays.sort( cars, (a,b)->{
            return b[0] - a[0];
        } );
        
        int ans = 0;
        double curTime = 0.0;
        for( int i=0 ; i<n ; i++ ){
            
            double t = (target - cars[i][0])*1.0 / cars[i][1];
            if( t > curTime ){
                ans++;
                curTime = t;
            }
            
        }
        return ans;
    }
}