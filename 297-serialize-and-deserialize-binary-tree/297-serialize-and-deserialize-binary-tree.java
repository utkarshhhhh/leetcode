/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    class Pair{
        
        TreeNode node;
        int s;
        
        Pair(){}
        
        Pair( TreeNode n, int st ){
            node = n;
            s = st;
        }
        
    }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        if( root == null ) return "";
        
        StringBuilder sb = new StringBuilder();
        
        helper( root, sb );
        return sb.toString();
    }
    
    void helper( TreeNode root, StringBuilder sb ){
        
        if( root == null ){
            sb.append(". ");
            return;
        }
        
        sb.append( root.val + " " );
        
        helper( root.left, sb );
        helper( root.right, sb );
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if( data.length() == 0 ) return null;
        
        String[] dArr = data.split(" ");
        Stack<Pair> st = new Stack<>();
        TreeNode head = new TreeNode( Integer.parseInt(dArr[0]) );
        int idx = 1;
        
        st.push( new Pair( head, 0) );
        
        while( !st.isEmpty() ){
            
            Pair temp = st.peek();
            TreeNode cur = temp.node;
            
            if( temp.s == 0 ){
                
                if( dArr[idx].equals(".") ){                    
                    temp.s++;
                    idx++;
                    continue;
                }
            
                TreeNode left = new TreeNode( Integer.parseInt(dArr[idx++]) );

                cur.left = left;
                st.push( new Pair( left , 0) );
                temp.s++;
            
            }else if( temp.s == 1 ){
 
                if( dArr[idx].equals(".") ){                    
                    temp.s++;
                    idx++;
                    continue;
                }
            
                TreeNode right = new TreeNode( Integer.parseInt(dArr[idx++]) );

                cur.right = right;
                st.push( new Pair( right , 0) );
                temp.s++;
                
            }else{
                st.pop();
            }
            
        }
        return head;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));