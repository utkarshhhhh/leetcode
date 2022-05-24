class Solution {
    public int longestValidParentheses(String s) {
     
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int max = 0;
        for(int i=0 ; i<s.length() ; i++){
            
            char c = s.charAt(i);
            if( c==')' && st.size() > 1 && s.charAt( st.peek() ) == '('){
                    int j = st.pop();
                    max = Math.max( max, i-st.peek() );
                }
            else 
                st.push(i);                
            }
        return max;    
    }
}