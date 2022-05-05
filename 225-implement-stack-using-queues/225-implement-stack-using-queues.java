class MyStack {

    Queue<Integer> main , helper;
    public MyStack() {
        main = new LinkedList<>();
        helper = new LinkedList<>();
    }
    
    public void push(int x) {
        
        helper.add(x);
        while( main.size() != 0 ){
         helper.add( main.remove() );
        }
        
        main = helper;
        helper = new LinkedList<>();
    }
    
    public int pop() {
        return main.remove();
    }
    
    public int top() {
        return main.peek();
    }
    
    public boolean empty() {
        return main.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */