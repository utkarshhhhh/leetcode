// { Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node left, right;
    
    Node(int item)
    {
        data = item;
        left = right = null;
    }    
        public void setLeft(Node left) 
    {
        this.left = left;
    }
  
    public void setRight(Node right) 
    {
        this.right = right;
    }
        
    
}


class ConstructBT
{
    Node root;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    
	    while(t-- > 0)
	    {
	        int n = sc.nextInt();
	        
	        int inord[] = new int[n];
	        int level[] = new int[n];
	        for(int i = 0; i < n; i++)
	            inord[i] = sc.nextInt();
	            
	        for(int i = 0; i < n; i++)
	             level[i] = sc.nextInt();
	             
	        GfG g = new GfG();
	        Node node =  g.buildTree(inord, level);
	        printPreOrder(node);
	        System.out.println();
	        
	        
	    }
    }
    
   static void printPreOrder(Node node)
   {
       if(node == null)
          return;
          
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
   }
}
// } Driver Code Ends


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Complete the function below*/
class GfG
{
    HashMap<Integer,Integer> map = new HashMap<>();
    
    Node buildTree(int inord[], int level[])
    {
        //your code here
        
        for(int i=0 ; i<level.length ; i++)
            map.put(level[i], i);
        
        return helper(inord,0,level.length-1);
    }
    
    Node helper( int[] inorder, int left, int right ){
        
        if(left > right) return null;
        
        int minIdx = left;
        for(int i=left+1 ; i<=right ; i++){
            if( map.get(  inorder[i] ) < map.get(inorder[minIdx] ) ){
                minIdx = i;
            }
        }
        
        Node node = new Node( inorder[minIdx] );
        
        node.left = helper(inorder, left , minIdx-1 );
        node.right = helper(inorder, minIdx+1, right );
        
        return node;
    }
    
   
}


