class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort( intervals, (a,b)-> a[0]-b[0] );
        
        ArrayList<int[]> ans = new ArrayList<>();
        
        for(int[] x : intervals){
            
            if( ans.size() == 0 ) ans.add(x);
            else{
                int[] cur = ans.get( ans.size()-1 );
                
                if( x[0] <= cur[1] ){
                    // cur[0] = Math.min(cur[0], x[0]);
                    cur[1] = Math.max(cur[1], x[1]);
                }else{
                    ans.add(x);
                }                
            }
            
        }
        return ans.toArray( new int[ans.size()][2] );
    }
}