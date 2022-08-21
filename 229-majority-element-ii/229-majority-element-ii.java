class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int num1 = 0, num2 = 0, c1 = 0, c2 = 0;
        
        for( int x : nums ){
            
            if( num1 == x ){
                c1++;
            }else if( num2 == x ){
                c2++;
            }else if( c1 == 0 ) {                
                c1++;
                num1 = x;
            }else if( c2 == 0 ) {                
                c2++;
                num2 = x;
            }else{
                c1--; c2--;
            }
            
        }
        
        c1 = 0; c2 = 0;
        for( int x : nums ){            
            if( num1 == x ){
                c1++;
            }else if( num2 == x ){
                c2++;
            }            
        }
        
        List<Integer> ans = new ArrayList<>();
        
        if( c1 > nums.length/3 )
            ans.add(num1);
        if( c2 > nums.length/3 )
            ans.add(num2);
        
        return ans;
    }
}