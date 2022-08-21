class Solution {
    public int[] movesToStamp(String stamp, String target) {
        
        List<Integer> list = new ArrayList<>();
        
        int n = target.length(), m = stamp.length();
        int stars = 0;
        boolean[] vis = new boolean[n-m+1];
        char[] st = stamp.toCharArray(), tar = target.toCharArray();
        
        
        while( stars < n ){
            boolean replaced = false;        
            for(int i=0 ; i<=n-m ; i++){
            
                if( !vis[i] && canReplace(tar,st,i) ){
                    stars += replace(tar,st,i);
                    replaced = true;
                    vis[i] = true;
                    list.add(i);
                    if( stars == m ) break;
                    // System.out.println(i);
                }
            }
        
            if( !replaced ) return new int[0];
        }
        
        int[] ans = new int[list.size()];
        
        for( int i=0 ; i<list.size() ; i++ ){
            ans[ ans.length-1 -i ] = list.get(i);
        }
        return ans;
    }
    
    public boolean canReplace( char[] tar, char[] st, int idx ){
        
        for(int i=0 ; i<st.length ; i++){
            if( tar[idx+i] != '*' && tar[idx+i] != st[i] ){
                return false;
            }
        }
        return true;
    }
    
    public int replace( char[] tar, char[] st, int idx ){
        
        int c = 0;
        for(int i=0 ; i<st.length ; i++){
            if( tar[idx+i] != '*' ){
                c++;
                tar[idx+i] = '*';
            }
        }
        return c;
    }
    
}