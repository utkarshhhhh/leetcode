class Solution {
    public boolean validUtf8(int[] data) {
      int count = 0;
        for(int i : data){
            
            if( count == 0 ){
                // 0 , 110, 1110, 11110 follwed by 10...
                if( (i>>7) == 0 ){
                    continue;
                }else if( (i>>5) == 0b110 ){
                    count = 1;
                }else if( (i>>4) == 0b1110 ){
                    count = 2;
                }else if( (i>>3) == 0b11110 ){
                    count = 3;
                }else 
                    return false;
            }else {
                
                if( (i>>6) == 0b10 ){
                    count--;
                }else 
                    return false;
                
            }
            
        }
        return count==0;  
    }
}