class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        
        Arrays.sort( horizontalCuts );
        Arrays.sort( verticalCuts );
        
        int l = horizontalCuts[0], b = verticalCuts[0];
        
        for( int i=1 ; i<horizontalCuts.length ; i++ ){
            l = Math.max( l, horizontalCuts[i] - horizontalCuts[i-1] );
        }
        l = Math.max( l, h - horizontalCuts[ horizontalCuts.length-1 ] );
        
        for( int i=1 ; i<verticalCuts.length ; i++ ){
            b = Math.max( b, verticalCuts[i] - verticalCuts[i-1] );
        }
        b = Math.max( b, w - verticalCuts[ verticalCuts.length-1 ] );
        
        return (int) ((long)l*b%1000000007);
    }
}