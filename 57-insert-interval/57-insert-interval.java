class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
    
        int n = intervals.length;
        ArrayList<int[]> ans = new ArrayList<>();
        
        int i=0;
        while( i<n && intervals[i][1] < newInterval[0] ){
            ans.add(intervals[i++]);                
        }
        
        int[] intv = newInterval;
        while( i<n && intervals[i][0] <= intv[1] ){
            intv[0] = Math.min( intv[0], intervals[i][0] );      
            intv[1] = Math.max( intv[1], intervals[i][1] ); 
            i++;
        }
        ans.add(intv);
        
        while( i<n ){
            ans.add(intervals[i++]);                
        }
        
        return ans.toArray( new int[ans.size()][2] );
    }
    
}