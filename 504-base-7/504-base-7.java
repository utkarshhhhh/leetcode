class Solution {
    public String convertToBase7(int num) {
        
        if(num == 0) return "0";
        
        String ans = "";
        
        boolean neg = false;
        if(num < 0) {
            neg = true;
            num = -num;
        }
        
        while( num != 0 ){
            
            int mod = num%7;
            num /= 7;
            ans = mod + ans;            
        }
        return  neg? "-"+ans : ans;
    }
}