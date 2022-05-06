class Solution {
    
    private class pair{
        int c; // count
        char ch;
        
        pair(char d , int k){
            c = k;
            ch = d;
        }        
    }
    
    public String removeDuplicates(String s, int k) {
        
        Stack<pair> st = new Stack<>();
        int count = 0;
        for(int i=0 ; i<s.length() ; i++){
            char c = s.charAt(i);
            
            if( !st.isEmpty() && st.peek().ch == c ){
                pair cur = st.pop();
                cur.c++;
                
                if( cur.c != k ){
                    st.push(cur);
                }                
            }else{                
                st.push( new pair( c , 1 ) );
            }            
        }
     
        StringBuilder sb = new StringBuilder();
        
        while( !st.isEmpty() ){
            
            pair cur = st.pop();
            
            for( int i=0 ; i<cur.c ; i++)
                sb.append( cur.ch );
        }
        
        
        return sb.reverse().toString();
    }
}
// if( !st.isEmpty() && st.peek() == c ){
//                 count++;
//                 st.push(c);
                
//                 int tempCount = 0;
//                 Stack<Character> tempSt = new Stack<>();
                
//                 while( !st.isEmpty() && st.peek() == c ){
//                     tempCount++;
//                     tempSt.push(st.pop());
//                     if(tempCount == k){
//                         break;
//                     }
//                 }
                
//                 if( k > tempCount  ){
//                     while( !tempSt.isEmpty() ){
//                         st.push( tempSt.pop() );
//                     }
//                 }                                
//             }else{
//                 count = 1;
//                 st.push(c);
//             }          