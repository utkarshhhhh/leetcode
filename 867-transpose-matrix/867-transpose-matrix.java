class Solution {
    
    public int[][] transpose(int[][] matrix) {
        
        int n = matrix.length, m = matrix[0].length;
        int[][] trans = new int[m][n];
        for(int r=0 ; r<n ; r++){
            for(int c=0 ; c<m ; c++){
                trans[c][r] = matrix[r][c];
            }
        }
        return trans;
    }
}