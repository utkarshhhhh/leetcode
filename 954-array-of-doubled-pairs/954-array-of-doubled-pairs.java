class Solution {
    public boolean canReorderDoubled(int[] arr) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int x : arr){
            map.put( x, map.getOrDefault(x, 0) + 1 );
        }
        
        Arrays.sort(arr);
        
        int n = arr.length;
        for(int i=0 ; i<n ; i++){
            
            if( map.get( arr[i] ) > 0 ){
                map.put(arr[i], map.get(arr[i])-1);
                
                if( arr[i] > 0 ){
                
                    if( map.containsKey( 2*arr[i] )  ){
                        if(map.get( 2*arr[i] ) > 0){
                            map.put(2*arr[i], map.get(2*arr[i])-1);                    
                        }else {
                            return false;
                        }                
                    }else return false;
                }else{
                    if( map.containsKey( arr[i]/2 ) && arr[i]%2 == 0){
                        if(map.get( arr[i]/2 ) > 0){
                            map.put(arr[i]/2, map.get(arr[i]/2)-1);                    
                        }else {
                            return false;
                        }                
                    }else return false;                    
                }
            }
            
        }
        return true;
    }
}