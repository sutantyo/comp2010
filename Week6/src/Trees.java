
public class Trees {
	
	public static void main(String[] args){
		BST test = new BST();
		test.insert(9);
		test.insert(7);
		test.insert(6);
		test.insert(2);
		test.insert(5);
		test.insert(8);
		test.insert(4);
		test.insert(1);
		test.insert(3);
		
		traversal(test.root);
		System.out.println();
		/*
		System.out.println(test.inorder());
		System.out.println(test.postorder());
		
		System.out.println(countNodes(test.root));
		System.out.println(findMax(test.root));
		System.out.println(sumNodes(test.root));
		printBetween(test.root,3,6);
		System.out.println();
		*/
	}
	
	public static int countNodes(Node root){
		if (root == null)
			return 0;
		return 1 + countNodes(root.left) + countNodes(root.right);
	}
	
	public static int countLeaves(Node root){
		if(root.left == null && root.right == null)
			return 1;
		else if (root.left == null)
			return countLeaves(root.right);
		else if (root.right == null)
			return countLeaves(root.left);
		else
			return countLeaves(root.left) + countLeaves(root.right);
		
	}
	
	public static void traversal(Node root){
		if (root == null)
			return;
		traversal(root.left);
		traversal(root.right);
		System.out.print(root.key + " ");
	}
	
	public static int findMax(Node root){
		if (root == null)
			return 0;
		return Math.max(root.key,Math.max(findMax(root.left),findMax(root.right)));
	}

	public static int sumNodes(Node root){
		if (root == null)
			return 0;
		return root.key + sumNodes(root.left) + sumNodes(root.right);
	}
	
	public static void printBetween(Node root, int a, int b){
		if (root == null)
			return;
		printBetween(root.left,a,b);
		if (root.key >= a && root.key <= b)
			System.out.print(root.key + " ");
		printBetween(root.right,a,b);
	}
	
	public static int findHeight(Node root){
		if (root == null)
			return 0;
		else
			return 1 + Math.max(findHeight(root.left), findHeight(root.right));
	}
	
	public static void print(Node root){
		if (root == null)
			return;
		print(root.right);
		print(root.left);
		System.out.print(root.key + " ");
		
	}

}
