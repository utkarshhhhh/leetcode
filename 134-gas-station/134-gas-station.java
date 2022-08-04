class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int sum = 0, cur = 0, idx = 0;
        
        for(int i=0 ; i<gas.length ; i++ ){
            
            sum += gas[i] - cost[i];
            cur += gas[i] - cost[i];
            
            if( cur < 0 ){
                cur = 0;
                idx = i+1;
            }
            
        }
        
        return sum>=0 ? idx : -1;
    }
}