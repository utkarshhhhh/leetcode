class Solution {
    public int maximumSwap(int num) {
        
        char[] arr = (num+"").toCharArray() ;
        int n = arr.length;
        int[] max = new int[n];
        
        for( int i=n-2 ; i>=0 ; i-- ){
            
            if( i==n-2 ){
                max[i] = n-1;
            }else{
                
                if( arr[i+1] > arr[ max[i+1] ] ){
                    max[i] = i+1;
                }else{
                    max[i] = max[i+1];
                }
                
            }            
        }
        
        for(int i=0 ; i<n-1 ; i++){
            
            if( arr[i] < arr[ max[i] ] ){
                
                char t = arr[i];
                arr[i] = arr[ max[i] ];
                arr[ max[i] ] = t;
                break;
            }
            
        }
        
        return Integer.parseInt ( new String(arr) );
    }
}