class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        
        int[] p = new int[n+1];
        int[] r = new int[n+1];
        
        for(int i=0 ; i<=n ; i++)
            p[i] = i;
        
        int rem = 0, e1 = 0 , e2 = 0;
        
        // connect 3
        for(int[] e : edges){
            
            if( e[0] == 3 ){                
                boolean add = union( e[1], e[2] , p , r );
                if( add ){
                    e1++; e2++;
                }else{
                    rem++;
                }
            }            
        }
        
        // connect 1
        int[] p1 = p.clone();
        int[] r1 = r.clone();
        
        for(int[] e : edges){
            
            if( e[0] == 1 ){                
                boolean add = union( e[1], e[2] , p1 , r1 );
                if( add ){
                    e1++;
                }else{
                    rem++;
                }
            }            
        }
        
        // connect 2
        int[] p2 = p.clone();
        int[] r2 = r.clone();
        
        for(int[] e : edges){
            
            if( e[0] == 2 ){                
                boolean add = union( e[1], e[2] , p2 , r2 );
                if( add ){
                    e2++;
                }else{
                    rem++;
                }
            }            
        }
        
        if( e1 != n-1 || e2 != n-1 ){
            return -1;
        }
        return rem;
    }
    
    boolean union(int X, int Y, int[] p, int[] r){
        
        int x = find(X, p);
        int y = find(Y, p);
        
        if( x==y ) return false;
        
        if( r[x] > r[y] ){
            p[y] = x;
        }else if( r[x] < r[y] ){
            p[x] = y;
        }else{
            p[x] = y;
            r[y]++;
        }
        return true;
    }
    
    int find(int x, int[] p){
        if( p[x] == x ) return x;
        return p[x] = find(p[x], p);
    }
}