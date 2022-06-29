class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        Arrays.sort(people, (a,b)-> a[0]==b[0] ? a[1]-b[1] : b[0]-a[0] );
        
        List<int[]> ans = new LinkedList<>();
        for( int[] a : people ){
            ans.add( a[1], a );
        }
        return ans.toArray( new int[ people.length ][] );
    }
}