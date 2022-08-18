class Solution {
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n = nums1.length, m = nums2.length;
        
        int medIdx1 = (n+m +1)/2;
        int medIdx2 = (n+m +2)/2;
        
        int med1 = findMed( nums1, nums2, medIdx1 , 0, 0 );
        int med2 = findMed( nums1, nums2, medIdx2 , 0, 0 );
        
        return (med1+med2)/2.0;
    }
    
    int findMed(int[] nums1, int[] nums2, int k, int i, int j){
        
        if( i >= nums1.length ){
            return nums2[j + k-1];
        }
        if( j >= nums2.length ){
            return nums1[i + k-1];
        }
        
        if( k==1 ){
            return Math.min( nums1[i], nums2[j] );
        }
        
        int x = Integer.MAX_VALUE;
        if( i + k/2 -1 < nums1.length ){
            x = nums1[ i + k/2 -1 ];
        }
        
        int y = Integer.MAX_VALUE;
        if( j + k/2 -1 < nums2.length ){
            y = nums2[ j + k/2 -1 ];
        }
        
        if( x < y ){
            return findMed( nums1, nums2, k - k/2 , i + k/2 , j );
        }else
            return findMed( nums1, nums2, k - k/2 , i , j + k/2 );
        
    }
}