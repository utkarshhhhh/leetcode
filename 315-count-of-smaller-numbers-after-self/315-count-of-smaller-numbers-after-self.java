class Solution {
    public List<Integer> countSmaller(int[] nums) {
    LinkedList<Integer> result = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for(int i = nums.length-1; i >= 0; i--) {
            int idx = binarySearch(list, nums[i]);
            result.addFirst(idx);
            list.add(idx, nums[i]);
        }
        return result;
    }
    
	//Returns index of the first number that is equal to or bigger than num
    public int binarySearch(List<Integer> list, int num) {
        int left = 0;
        int right = list.size()-1;
        int mid;
        while(left < right) {
            mid = left + (right-left)/2;
            if(list.get(mid) < num) {
                left = mid+1;
            }
            else {
                right = mid;
            }
        }
        if(!list.isEmpty() && list.get(left) < num) {
            return left+1;
        }
        return left;
    }
}