class Solution {
    
    class Pair{
        int idx, val;
        Pair(int i,int v){
            idx = i;
            val = v;
        }
    }
    
    int[] ans;
    public List<Integer> countSmaller(int[] nums) {
        
        int n = nums.length;
        Pair[] p = new Pair[n];
        
        for(int i=0 ; i<n ; i++){
            p[i] = new Pair( i, nums[i] );
        }
        
        ans = new int[n];
        merge(p, 0, n-1);
        
        List<Integer> arr = new ArrayList<>();
        for(int x : ans) arr.add(x);
        return arr;
    }
    
    public Pair[] merge( Pair[] arr, int st, int end ){
        
        if( st == end ){
            return new Pair[]{ arr[st] };
        }
        
        int mid = (st+end)/2;
        
        Pair[] left = merge(arr, st, mid);
        Pair[] right = merge(arr, mid+1, end);
        
        return merge2(left, right);
    }
    
    public Pair[] merge2(Pair[] left, Pair[] right){
        
        int n = left.length, m = right.length;
        Pair[] arr = new Pair[n+m];
        int i=0, j=0, k=0;
        while( i<n && j<m ){
            
            if( left[i].val > right[j].val  ){
                ans[ left[i].idx ] += (m-j) ;
                arr[k++] = left[i++] ;
            }else{
                arr[k++] = right[j++] ;
            }
            
        }
        
        while( i<n ){
            arr[k++] = left[i++] ;
         }
        
        while( j<m ){
            arr[k++] = right[j++] ;
         }
        return arr;
    }
    
}