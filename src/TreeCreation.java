import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class Tree{
	int data;
	Tree left, right;
	
	Tree(int data){
		this.data = data;
	}
	
}
public class TreeCreation {
	static Scanner sc = null;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		Tree tree = createTree();
		inOrder(tree);
		System.out.println();
		preOrder(tree);
		System.out.println();
		postOrder(tree);
		System.out.println();
		System.out.println(noOfNode(tree));
		System.out.println(getSum(tree));
		getLeafNode(tree);
		System.out.println();
		System.out.println(getTotalLeafNode(tree));
		System.out.println("Height of the tree is : "+ getHeight(tree));
		printLevelNode(tree, 2);
	}
	static Tree createTree() {
		Tree tree = null;
		System.out.println("Enter data...");
		int data = sc.nextInt();
		if(data == -1) return null;
		tree = new Tree(data);
		System.out.println("Enter left for"+data);
		tree.left = createTree();
		System.out.println("Enter right for"+data);
		tree.right = createTree();
		return tree;
	}
	static void inOrder(Tree tree) {
		if(tree == null) return;
		inOrder(tree.left);
		System.out.print(tree.data);
		inOrder(tree.right);
	}
	static void preOrder(Tree tree) {
		if(tree == null) return;
		
		System.out.print(tree.data);
		preOrder(tree.left);
		
		preOrder(tree.right);
	}
	
	static void postOrder(Tree tree) {
		if(tree == null) return;
		
		postOrder(tree.left);
		postOrder(tree.right);
		System.out.print(tree.data);
	}
	 
	// get no of nodes from tree
	static int noOfNode(Tree tree) {
		
		if(tree == null) return 0;
//		
//		if(tree.left != null)  1+ noOfNode(tree.left);
//		if(tree.right != null) 1+ noOfNode(tree.right);
		
		return 1 + noOfNode(tree.left) + noOfNode(tree.right) ;
	} 
	// get sum of all the nodes 
	static int getSum(Tree tree) {
		if(tree == null ) return 0;

		return tree.data + getSum(tree.left) + getSum(tree.right) ;
	}
	// Get number of Leaf Nodes in Binary Tree. whose node has no children
	static void getLeafNode(Tree tree) {
		if(tree == null) {
			System.out.println("Tree is null");
		}
		if(tree.left == null && tree.right == null) {
			System.out.print(tree.data);
		}
		if(tree.left != null) {
			getLeafNode(tree.left);
		}
		if(tree.right != null) {
			getLeafNode(tree.right);
		}
		
	}
	// get total no of leaf nodes in bianry tree. whose node has no children
	static int getTotalLeafNode(Tree tree) {
		if(tree == null) return 0;
		if(tree.left == null && tree.right == null) {
			return 1;
		}
		return getTotalLeafNode(tree.left) + getTotalLeafNode(tree.right);
	}
	
	// get height of the binary tree
	static int getHeight(Tree tree) {
		if(tree == null) return -1;
		return max(getHeight(tree.left), getHeight(tree.right)) + 1;
	}
	static int max(int a, int b) {
		return a > b ? a:b;
	}
	
	//Print elements at given level in Binary Tree
	static void printLevelNode(Tree tree, int level) {
		if(tree == null) {
			System.out.println("no");
		}
		if(level == 1) {
			System.out.println(tree.data);
			
			return;
		}
		printLevelNode(tree.left, level-1);
		printLevelNode(tree.right, level-1);
		
	}
	
}

