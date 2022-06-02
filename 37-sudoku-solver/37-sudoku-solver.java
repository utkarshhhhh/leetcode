class Solution {
    
    char[][] ans = new char[9][9];
    
    public boolean valid(char[][] arr, int r, int c, char ch){
        
        for(int i=0 ; i<arr.length ; i++){
            if( arr[i][c] == ch )
                return false;
        }
        
        
        for(int j=0 ; j<arr.length ; j++){
            if( arr[r][j] == ch )
                return false;
        }
        
        r = r/3 *3;
        c = c/3 *3;
        for(int i=r ; i<r+3 ; i++ ){
            for(int j=c ; j<c+3 ; j++){
                if( arr[i][j] == ch )
                    return false;
            }
        }
        return true;
    }
    
    public void solver(char[][] board,int r, int c){
        
        if( r==9 ){
            
            for(int i=0 ; i<9 ; i++){
                for(int j=0 ; j<9 ; j++){
                    ans[i][j] = board[i][j];
                }
            }
            return;
        }
        
        int nr = r, nc = c;
        if( c==8 ){
            nr++;
            nc=0;
        }else{
            nc++;
        }
        
        if( board[r][c] != '.' ){
            solver(board,nr,nc);
        }else{
            
            for(char n='1' ; n<='9' ; n++){
                
                if( valid(board,r,c,n) ){                    
                    board[r][c] = n;
                    solver(board,nr,nc);
                    board[r][c] = '.';                    
                }                
            }            
        }
        
    }
    
    public void solveSudoku(char[][] board) {
               
        solver(board,0,0);
        for(int i=0 ; i<9 ; i++){
                for(int j=0 ; j<9 ; j++){
                    board[i][j] = ans[i][j];
                }
            }
    }
}