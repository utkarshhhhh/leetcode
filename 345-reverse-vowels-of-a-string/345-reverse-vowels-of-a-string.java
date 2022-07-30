class Solution {
    
    void swap(StringBuilder sb, int i, int j){        
        char a = sb.charAt(i), b = sb.charAt(j);
        
        sb.setCharAt(j, a);
        sb.setCharAt(i, b);        
    }
    
    public String reverseVowels(String s) {
     
        StringBuilder sb = new StringBuilder(s);
        int i=0, j=s.length()-1;
        
        HashSet<Character> set = new HashSet<>();
        
        set.add('a'); set.add('A');
        set.add('e'); set.add('E');
        set.add('i'); set.add('I');
        set.add('o'); set.add('O');
        set.add('u'); set.add('U');
        
        while( i<j ){
            
            while( i<j && !set.contains( sb.charAt(i) ) ){
                i++;
            }
            while( i<j && !set.contains( sb.charAt(j) ) ){
                j--;
            }
            
            swap(sb,i,j);
            i++; j--;
        }
        
        return sb.toString();
    }
}