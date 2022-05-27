class Solution {
    public int numberOfSteps(int num) {
        
        if( num == 0 ) return 0;
        
        // return (num%2==0 ? numberOfSteps(num>>1)  : numberOfSteps(num-1)) + 1;
        return Integer.toBinaryString(num).length() -1 + Integer.bitCount(num);
    }
}