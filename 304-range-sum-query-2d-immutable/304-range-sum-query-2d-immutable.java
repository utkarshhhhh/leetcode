class NumMatrix {

    int[][] preSum;
    public NumMatrix(int[][] matrix) {
        
        for(int i=0 ; i<matrix.length ; i++){
            for(int j=0 ; j<matrix[0].length ; j++){
                
                if( i==0 && j==0 ){
                    continue;
                }else if( i==0 ){
                    matrix[i][j] += matrix[i][j-1];
                }else if( j==0 ){
                    matrix[i][j] += matrix[i-1][j];
                }else{
                    matrix[i][j] += matrix[i-1][j] + matrix[i][j-1] - matrix[i-1][j-1];
                }                
            }
        }
        preSum = matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        
        int sum = preSum[row2][col2];
        
        if( row1 != 0 ){
            sum -= preSum[row1-1][col2];
        }
        
        if( col1 != 0 ){
            sum -= preSum[row2][col1-1];
        }
        
        if( row1 != 0 && col1 != 0 ){
            sum += preSum[row1-1][col1-1];
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */