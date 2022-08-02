class Solution {
    public int reachNumber(int target) {
        
        int x = 0;
        target = Math.abs(target);
        
        
        while( true ){
            int n = x*(x+1)/2;
            if( target <= n && target%2 == n%2 ){
                break;
            }
            x++;
        }
        return x;
    }
}