class NumArray {
    
    class Node{
        int val;
        Node left, right;
        int start,end;
        
    }
    Node root;
    public NumArray(int[] nums) {        
        root = construct( nums, 0, nums.length-1 );        
    }
    
    Node construct(int[] arr, int i, int j){
        
        if( i==j ){
            Node base = new Node();
            base.val = arr[i];
            base.start = base.end = i;
            return base;
        }
        
        Node cur = new Node();
        int m = (i+j)>>1;
        cur.start = i;
        cur.end = j;
        cur.left = construct(arr, i, m);
        cur.right = construct(arr, m+1, j);
        
        cur.val = cur.left==null ? 0 : cur.left.val;
        cur.val += cur.right==null ? 0 : cur.right.val;
        return cur;
    }
    
    void update(Node node, int idx, int val){
        
        if( node.start == node.end ){
            node.val = val;
            return;
        }
        
        int m = (node.start + node.end)>>1;
        
        if( m >= idx ){
            update(node.left, idx, val);
        }else{
            update(node.right, idx, val);
        }
        
        node.val = node.left==null ? 0 : node.left.val;
        node.val += node.right==null ? 0 : node.right.val;
        
        return;
    }
    
    public void update(int index, int val) {
        update( root, index, val );
    }
    
    int getSum(Node root, int left, int right){
        
        if( root == null || root.start > right || root.end < left ){
            return 0;
        }else if(root.end <= right && root.start >= left ){
            return root.val;
        }else{
            return getSum(root.left, left, right) + getSum(root.right, left, right);
        }
        
    }
    
    public int sumRange(int left, int right) {
        return getSum(root, left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */