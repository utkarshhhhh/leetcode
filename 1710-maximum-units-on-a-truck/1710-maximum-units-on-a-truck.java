class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        int n = boxTypes.length;
        
        Arrays.sort( boxTypes, (a,b)-> b[1]-a[1] );
        
        int sum = 0;
        for( int[] x : boxTypes ){
            
            if( truckSize >= x[0] ){
                sum += x[0]*x[1];
                truckSize -= x[0];
                
                if( truckSize == 0 ) break;
                
            }else {                
                sum += x[1]*truckSize;
                break;
            }            
        }
        return sum;
    }
}