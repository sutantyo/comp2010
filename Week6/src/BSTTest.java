import static org.junit.Assert.*;

import org.junit.Test;

public class BSTTest {

	@Test
	public void TestEmptyBST() {
		BST test = new BST();
		Node p=	test.search(1);
		assertNull(p);  	
	}
	    
	@Test 
	public  void TestInsert() {
		BST test = new BST();
		test.insert(2);
		test.insert(3);
		test.insert(4);
		Node p=	test.search(2);
		assertEquals(2, p.key);
		p = test.search(4);
		assertEquals(4, p.key);
		p = test.search(5);
		assertNull(p);
	}
	
	@Test
	public   void TestDelete() {   	
		BST test = new BST();
		test.insert(5);
		test.insert(6);
		test.insert(7);
		
		Node p=	test.search(7);
		assertEquals(7, p.key);
		test.deleteByCopying(7);
		p=	test.search(7);
		assertNull(p);   	
	}
	
	@Test
	public  void TestInorder() {
		BST test = new BST();
		test.root= null;
		test.insert(2);
		test.insert(3);
		test.insert(4);
		test.insert(1);
		test.insert(6);
		test.insert(5);
		
		String A= test.inorder();
		assertEquals("123456", A);   	
	 }
	
	@Test
	public  void TestPreorder() {
		
		BST test = new BST();
		test.root= null;
		test.insert(2);
		test.insert(3);
		test.insert(4);
		test.insert(1);
		test.insert(6);
		test.insert(5);    	
		String A= test.preorder();
		assertEquals("213465", A);   	
	 }
	
	@Test 
	public void TestInStack() {
		BST test = new BST();
		test.root= null;
		test.insert(2);
		test.insert(3);
		test.insert(4);
		test.insert(1);
		test.insert(6);
		test.insert(5); 
		
		Stack s= new Stack();
		test.inStack(test.root, s);
		assertEquals(6, s.pop());
		assertEquals(5, s.pop());
		assertEquals(4, s.pop());
		assertEquals(3, s.pop());
		assertEquals(2, s.pop());
		assertEquals(1, s.pop());    	
	}
}
