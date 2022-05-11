class Solution {
    public int countVowelStrings(int n) {
        
        int a = 1, e = 1, i = 1 , o = 1 , u = 1; 
        int ans = 0;
        while( n-- > 0 ){
            
            ans = a+e+i+o+u;
            a += e+i+o+u;
            e += i+o+u;
            i += o+u;
            o += u;
            // u += u;            
        }
        return ans;
    }
}