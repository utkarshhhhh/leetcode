class Solution {
    boolean[] vis = new boolean[16];
    public boolean helper(int[] matchsticks, int cur, int tar, int idx, int k){
        
        if( k==1 ){
            return true;
        }
        
        if( idx==matchsticks.length ) return false;
        
        if( cur == tar ) return helper( matchsticks, 0, tar, 0, k-1 );
        
        if( !vis[idx] && cur+matchsticks[idx] <= tar ){
            vis[idx] = true;
            if( helper( matchsticks, cur + matchsticks[idx], tar, idx+1, k ) ) return true;
            vis[idx] = false;
        }
        
        return helper( matchsticks, cur, tar, idx+1, k );
    }
    
    public boolean makesquare(int[] matchsticks) {
       
        if( matchsticks.length < 4 ){
            return false;
        }
        
        int sum = 0;
        for(int x : matchsticks) sum += x;
        
        if( sum%4 != 0 ) return false;
        
        return helper( matchsticks, 0, sum/4, 0, 4 );
        
    }
}