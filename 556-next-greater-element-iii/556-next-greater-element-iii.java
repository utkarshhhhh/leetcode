class Solution {
    public int nextGreaterElement(int n) {
        
        char[] arr = (n+"").toCharArray();
        
        int i = arr.length-1;
        // 436541
        // 5432
        while( i>0 ){
            if( arr[i] <= arr[i-1] ){
                i--;
            }else break;
        }
        if( i==0 ) return -1;
        
        int j = arr.length-1;
        
        while( j>i ){
            if( arr[j] <= arr[i-1] ){
                j--;
            }else break;
        }
        
        swap( arr, i-1,j );
        
        j = arr.length-1;
        while(i<j){
            swap( arr, i, j );
            i++; j--;
        }
        
        long ans = Long.parseLong( String.valueOf(arr) );
        return ans>Integer.MAX_VALUE ? -1 : (int)ans;
    }
    
    void swap(char[] arr, int i, int j){
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
    
}