class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        
        HashMap<Integer, Integer> rows = new HashMap<>();
        HashMap<Integer, Integer> cols = new HashMap<>();
        HashMap<Integer, Integer> d1 = new HashMap<>();
        HashMap<Integer, Integer> d2 = new HashMap<>();
        HashSet<Integer> lamp = new HashSet<>();
        
        for(int [] cur : lamps){
            int r = cur[0], c = cur[1];
            
            if( lamp.contains( r*n + c ) ) continue;
             
            rows.put( r, rows.getOrDefault( r, 0 ) + 1 );
            cols.put( c, cols.getOrDefault( c, 0 ) + 1 );
            d1.put( r+c, d1.getOrDefault( r+c, 0 ) + 1 );
            d2.put( r-c, d2.getOrDefault( r-c, 0 ) + 1 );
            lamp.add(  r*n + c );
        }
        
        int[] ans = new int[ queries.length ];
        
        for(int i=0 ; i<queries.length ; i++){
            
            int[] q = queries[i];
            int r = q[0], c = q[1];
            
            boolean exist = rows.getOrDefault( r, 0 ) > 0 || cols.getOrDefault( c, 0 ) > 0 || d1.getOrDefault( r+c, 0 ) > 0 || d2.getOrDefault( r-c, 0 ) > 0;
            ans[i] = exist ? 1 : 0;
            
            int[][] dir = { { -1,-1 }, { -1,0 }, { -1,1 }, { 0,-1 }, { 0,0 }, { 0,1 }, { 1,-1 }, { 1,0 }, { 1,1 } };
            
            for(int d = 0 ; d<dir.length ; d++){
                
                int rr = r + dir[d][0], cc = c + dir[d][1];
                int cell = rr*n + cc;
                
                if( rr<0 || rr>=n || cc<0 || cc>=n ) continue;
                
                if( !lamp.contains( cell ) ) continue;

                lamp.remove( cell );
                rows.put( rr, rows.getOrDefault( rr, 1 ) - 1 );
                cols.put( cc, cols.getOrDefault( cc, 1 ) - 1 );
                d1.put( rr+cc, d1.getOrDefault( rr+cc, 1 ) - 1 );
                d2.put( rr-cc, d2.getOrDefault( rr-cc, 1 ) - 1 );
            }
        }
        return ans;      
    }
}