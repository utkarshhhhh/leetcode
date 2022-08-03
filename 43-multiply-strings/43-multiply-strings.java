class Solution {
    
    private StringBuilder mul1 (String st, int n){
        
        int c = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i=0 ; i<st.length() ; i++){
            
            int sum = c + (st.charAt(i)-'0')*n;
            sb.append( sum%10 );
            c = sum/10;
            
        }
        if( c>0 ) sb.append(c);
        return sb.reverse();
    }
    
    private StringBuilder add(StringBuilder s1, StringBuilder s2){
        
        int i=0 , j=0, n = s1.length(), m = s2.length(), c = 0;
        
        StringBuilder sb = new StringBuilder();
        
        // s1 = s1.reverse();
        s2 = s2.reverse();
        
        // System.out.println( "Add" + s1.toString() + "  " + s2.toString() );

        
        while( i<n || j<m ){
            
            int sum = i<n ? s1.charAt(i++)-'0' : 0 ;
                sum += j<m ? s2.charAt(j++)-'0' : 0 ;
            sum += c;
            
            sb.append( sum%10 );
            c = sum/10;
            
        }
        if( c>0 ) sb.append(c);
        
        return sb;
        
    }
    
    public String multiply(String num1, String num2) {
     
        StringBuilder s1 = new StringBuilder(num1);
        // StringBuilder s2 = new StringBuilder(num2);
        
        num1 = s1.reverse().toString();
        
        StringBuilder ans = new StringBuilder();
        StringBuilder zero = new StringBuilder();
        for( int i=num2.length()-1 ; i>=0 ; i-- ){
            
            StringBuilder mul = mul1( num1, num2.charAt(i)-'0' );
            mul.append(zero);
            ans = add( ans, mul );
            
            // System.out.println( ans.toString() + "  " + mul.toString() );
            
            zero.append('0');
            
        }
        
        ans = ans.reverse();
        while( ans.length() > 0 && ans.charAt(0) == '0' ){
            ans.deleteCharAt(0);
        }
        
        return ans.length() == 0 ? "0" : ans.toString();
        
    }
}