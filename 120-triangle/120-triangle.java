class Solution {
    
    // int ans = Integer.MAX_VALUE;
    Integer[][] dp = new Integer[201][201];
    public int helper(List<List<Integer>> t, int row, int idx){
        
        if( t.size() == row +1 ){
            return t.get(row).get(idx) ;
        }
        
        if(dp[row][idx] != null ) return dp[row][idx];
        
        int left = helper( t, row+1, idx );        
        int right = helper( t, row+1, idx+1 );        
        
        return dp[row][idx] = Math.min(left,right) + t.get(row).get(idx);
    }
    
    public int minimumTotal(List<List<Integer>> triangle) {
        
        
        return helper(triangle,0,0);
        
    }
}