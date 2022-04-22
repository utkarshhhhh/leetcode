class MyHashMap {
    
    class ListNode{
        int key, val;
        ListNode next;
        ListNode(int k, int v){
            key = k;
            val = v;
        }
    }
    
    private ListNode list[];
    
    public MyHashMap() {
        list = new ListNode[100000];
    }
    
    public void put(int key, int value) {
        
        int hc = idx(key);
        
        if( list[hc] == null ) list[hc] = new ListNode( -1,-1 );
        
        ListNode cur = find(list[hc] , key);
        
        if( cur.next == null ){
            cur.next = new ListNode( key, value );
        }else{
            cur.next.val = value;
        }
        
    }
    
    public int get(int key) {
        
        int hc = idx(key);
        
        if(list[hc] == null) return -1;
        
        ListNode cur = find(list[hc] , key);
        
        return cur.next==null?-1 : cur.next.val;
    }
    
    ListNode find(ListNode bucket, int key){
        
        ListNode cur = bucket , prev = null;
        
        for( ; cur!=null && cur.key != key ; cur = cur.next  )
            prev = cur;
        
        return prev;
        
    }
    
    public void remove(int key) {
        
        int hc = idx(key);
        
        if(list[hc] == null) return;
        
        ListNode cur = find(list[hc] , key);
        if(cur.next != null)
        cur.next = cur.next.next;
        
    }
    
    private int idx(int k){
        return Integer.hashCode(k)%list.length;
    }
    
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */