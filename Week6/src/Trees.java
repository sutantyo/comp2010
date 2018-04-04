
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
		
		System.out.println(test.inorder());
		System.out.println(test.postorder());
		
		System.out.println(countNodes(test.root));
		System.out.println(findMax(test.root));
		System.out.println(sumNodes(test.root));
		printBetween(test.root,3,6);
		System.out.println();
	}
	
	public static int countNodes(Node root){
		if (root == null)
			return 0;
		return 1 + countNodes(root.left) + countNodes(root.right);
	}
	
	public static int findMax(Node root){
		if (root == null)
			return 0;
		return Math.max(root.key,Math.max(countNodes(root.left),countNodes(root.right)));
	}

	public static int sumNodes(Node root){
		if (root == null)
			return 0;
		return sumNodes(root.left) + sumNodes(root.right) + root.key; 
	}
	
	public static void printBetween(Node root, int a, int b){
		if (root == null)
			return;
		if (root.key >= a && root.key <= b)
			System.out.print(root.key + " ");
		printBetween(root.left,a,b);
		printBetween(root.right,a,b);
	}

}
