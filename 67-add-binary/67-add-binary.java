class Solution {
    public String addBinary(String a, String b) {
        
        StringBuilder ans = new StringBuilder();
        
        int i = a.length()-1, j = b.length()-1;
        int c = 0;
        while(i>=0 || j>=0){
            
            int x = i>-1 ? a.charAt(i--)-'0' : 0;
            int y = j>-1 ? b.charAt(j--)-'0' : 0;
            
            int anss = (c + x + y)%2;            
            c = (c + x + y)/2;
            
            ans.append(anss);
            
        }
        
        if( c>0 )
            ans.append(c);
        
        return ans.reverse().toString();
        
    }
}