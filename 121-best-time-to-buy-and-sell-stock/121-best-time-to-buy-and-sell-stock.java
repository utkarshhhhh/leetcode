class Solution {
    public int maxProfit(int[] prices) {
        
        int dpi0 = 0, dpi1 = Integer.MIN_VALUE; 
        // 0 means we dont have any stock. 1 - rev;
        
        for(int x : prices){
            
            dpi0 = Math.max( dpi0, dpi1 + x ); // sell prev bought stock
            dpi1 = Math.max( dpi1, - x );       // buy new one
            
        }
        
        return dpi0;
    }
}