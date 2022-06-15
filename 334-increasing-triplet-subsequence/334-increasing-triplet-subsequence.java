class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        Integer sm = Integer.MAX_VALUE, lg = Integer.MAX_VALUE;
        
//         for(int i : nums){
            
//             if( x == null || x >= i ){
//                 if( x == null ) x = i;
//                 else x = Math.min(x,i);
//             }else if( y == null || y >= i ){
//                 if( y == null ) y = i;
//                 else y = Math.min(y,i);
//             }else if( z == null || z >= i ){
//                 if( z == null ) z = i;
//                 else z = Math.min(z,i);
//             }
            
//         }
//         return x != null && y != null && z != null;
        
        for(int i : nums){
            
            if( sm >= i ){
                sm = i;
            }else if( lg >= i ){
                lg = i;
            }else
                return true;
            
        }
        return false;
    }
}