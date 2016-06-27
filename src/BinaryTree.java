
public class BinaryTree {
	BinaryTree left;
	BinaryTree right;
	int val;
	public BinaryTree(int i)
	{
		val=i;
		left=null;
		right=null;
	}
	//recursive
	int height()
	{


		int leftHeight=0,rightHeight=0;


		if(left==null)
		{
			//System.out.println("Height of node val="+left.val+" ="+0);
			//return 0;
			leftHeight=0;
		}
		else
		{
			leftHeight=1;
			leftHeight+=left.height();
		}


		if(right==null) //return 0;
			rightHeight=0;
		else
		{   rightHeight=1;
		rightHeight+=right.height();
		}
		//System.out.println("-----------------");
		//if(left!=null && right)
		System.out.println("Height of node val="+val+" MAx="+Math.max(leftHeight,rightHeight));
		//System.out.println("-----------------");
		return (Math.max(leftHeight,rightHeight));


	}

	void depth(int dep)
	{
		
		
		if(dep==0)
		System.out.println("Depth for node val= "+val +" 0");
			
		
		
		//if(right==null)
			//System.out.println("No right Child for node val= "+val);
			//return 0;
		dep++;
		
		if(left!=null) 
		{
			System.out.println("Depth for node val="+left.val +" "+dep);
		   left.depth(dep);
		
		}   
			
		
		if(right!=null) 
		{
			right.depth(dep);
			System.out.println("Depth for node val="+right.val +" "+dep);
		}	
	
		
		
		
		//return depth;	
	}


	private static BinaryTree buildTree(BinaryTree root,int i) {
		// TODO Auto-generated method stub
		if(root==null)
		{
			System.out.println("Root is Null "+i);
			return new BinaryTree(i);
		}
		else if(i<=root.val)
		{
			System.out.println("Root val="+root.val+" going left for val="+i);
			root.left=buildTree(root.left,i);
		}
		else
		{
			System.out.println("Root val="+root.val+" going right for val="+i);
			root.right=buildTree(root.right,i);
		}
		return root;
	}
	
	
	static void inorder(BinaryTree root)
	{
		//Left root Right
		if(root ==null) return;
		if(root.left!=null) 
			inorder(root.left);
		
		System.out.println(root.val);
		
		if(root.right!=null) 
			inorder(root.right);
			
	}
	
	//Depth Caluclation is pre - order traversal
	static void preorder(BinaryTree root,int d)
	{
		//root left right
		if(root ==null) 
			{
			System.out.println(root.val+" d="+d);
			return;
			}
		System.out.println(root.val+" "+d);
		d++;
		if(root.left!=null) 
		{
			
			//System.out.println(root.left.val+" d="+d);
			preorder(root.left,d);
		}
		if(root.right!=null) 
		{
			//System.out.println(root.right.val+" d="+d);
			preorder(root.right,d);
		}
	}
	
	
	//height caluclation is post order traversal
	static int postorder(BinaryTree root)
	{
		// left right root
		int leftDepth=0,rightDepth=0;
		if(root ==null) return 0;
		
		if(root.left!=null) 
			leftDepth=1+postorder(root.left);
		
		if(root.right!=null) 
			rightDepth=1+postorder(root.right);
		
		System.out.println(root.val+" "+Math.max(leftDepth, rightDepth));
	return Math.max(leftDepth, rightDepth);
	}
	public static void main(String[] args)
	{
		BinaryTree root=null;
		int elements[]= {5,6,3,2,1,7,9,4,11,8};//
	//	int elements[]= {5,3,1,4,8,7,12,10,11,9};//

		for(int i:elements)
			root=buildTree(root,i);

//		System.out.println(root.height());
//		root.depth(0);
		System.out.println("In Order");
		inorder(root);
//		System.out.println("Pre Order");
//		preorder(root,0);
//		System.out.println("Post Order");
//		postorder(root);
		//System.out.println(largest(root));
		System.out.println(secondLargest(root,null));
	}
	
	private static int largest(BinaryTree root) {
		// TODO Auto-generated method stub
		
		if(root.right!=null)
			return largest(root.right);
		else return root.val;
	}
	
	private static int secondLargest(BinaryTree cur,BinaryTree parent) {
		// TODO Auto-generated method stub
		if(cur.left==null && cur.right==null)
		{
			return parent.val;
		}
		else if (cur.right==null)
			return largest(cur.left);
		else return secondLargest(cur.right,cur) ;
	}


}
