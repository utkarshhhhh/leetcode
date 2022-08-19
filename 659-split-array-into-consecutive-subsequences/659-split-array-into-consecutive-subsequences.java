class Solution {
    public boolean isPossible(int[] nums) {
        
        int[] hash = new int[2002], check = new int[2001];
        
        for( int x : nums ){
            hash[x+1001]++;
        }
        
        for(int x : nums){
            
            x += 1001;
            if( hash[x] == 0) continue;
            
            hash[x]--;
            if( check[x-1] > 0  ){
                check[x-1]--;
                check[x]++;
                
            }else if( hash[x+1] > 0 && hash[x+2] > 0 ){
                hash[x+1]--;
                hash[x+2]--;
                check[x+2]++;
            }else{
                return false;
            }            
        }
        
        return true;
    }
}