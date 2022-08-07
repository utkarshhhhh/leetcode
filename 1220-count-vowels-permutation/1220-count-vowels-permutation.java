class Solution {
    public int countVowelPermutation(int n) {
        
        int mod = (int)1e9+7;
        long a = 1, e = 1, i = 1, o = 1, u = 1;
        
        for(int x=1 ; x<n ; x++){
            
            long ta = e, te = a+i, ti = (a+e)%mod+(o+u)%mod, to = i+u, tu = a;
            
            a = ta%mod;
            e = te%mod;
            i = ti%mod;
            o = to%mod;
            u = tu%mod;
            
        }
        return (int)( ( (a + e)%mod + (i + o)%mod + u )%mod );
    }
}