/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    
    Stack< Iterator<NestedInteger> > st;
    Integer next;
    public NestedIterator(List<NestedInteger> nestedList) {
        
        st = new Stack<>();
        st.push( nestedList.iterator() );
        advance();
    }
    
    public void advance(){
        
        next = null;
        while(!st.isEmpty()){
            Iterator<NestedInteger> it = st.peek();
            if( !it.hasNext() ){
                st.pop();
            }else{
                NestedInteger ni = it.next();
                if( ni.isInteger() ){
                    next = ni.getInteger();
                    return;
                }
                st.push( ni.getList().iterator() );   
            }        
        }
    }

    @Override
    public Integer next() {
        Integer x = next;
        advance();
        return x;
    }

    @Override
    public boolean hasNext() {
        return !st.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */