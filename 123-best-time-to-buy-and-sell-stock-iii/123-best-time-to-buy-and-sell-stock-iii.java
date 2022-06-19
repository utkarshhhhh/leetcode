class Solution {
    public int maxProfit(int[] prices) {
        
        /*
        k 0 1 2
        a
        b
        
        */
        // i idx, k ,0/1
        int dpi10 = 0, dpi11 = Integer.MIN_VALUE , dpi20 = 0, dpi21 = Integer.MIN_VALUE;
        
        for(int x : prices){

            dpi20 = Math.max( dpi20, dpi21 + x );              
            dpi21 = Math.max( dpi21, dpi10 - x );  
            dpi10 = Math.max( dpi10, dpi11 + x );  
            dpi11 = Math.max( dpi11, - x );  
            
        }
        
        return dpi20;
    }
}