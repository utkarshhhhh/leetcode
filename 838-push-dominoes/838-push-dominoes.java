class Solution {
    public String pushDominoes(String dominoes) {
        
        dominoes = "L" + dominoes + "R";
        char[] arr = dominoes.toCharArray();
        
        int prev = 0;
        for(int i=1 ; i<arr.length ; i++){
            
            if( arr[i] == 'L' ){
                
                if( arr[prev] == 'L' ){
                 
                    for( int j=prev ; j<=i ; j++ ){
                        arr[j] = 'L';
                    }
                    
                }else if( arr[prev] == 'R' ){
                    
                    int l=prev , r = i;
                    
                    while( l<r ){
                        arr[l] = 'R';
                        arr[r] = 'L';
                        l++; r--;
                    }
                    
                }
                prev = i;
            }else if( arr[i] == 'R' ){
                
                if( arr[prev] == 'L' ){
                    // nothing
                }else if( arr[prev] == 'R' ){
                    
                    for( int j=prev ; j<=i ; j++ ){
                        arr[j] = 'R';
                    }
                }
                prev = i;
            }            
        }
        
        return String.valueOf(arr).substring(1,arr.length-1);   
    }
}