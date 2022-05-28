class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(-1,0);
        int xor = 0;
        for(int i=0 ; i<arr.length ; i++){
            xor = xor^arr[i];
            map.put( i, xor );
        }
        
        int[] ans = new int[queries.length];
        int[] ar;
        for(int i=0 ; i<queries.length ; i++){
            ar = queries[i];
            int l = ar[0], r = ar[1];
            
            ans[i] = l>0 ? map.get(l-1)^map.get(r) : map.get(r);
            
        }
        return ans;
    }
}