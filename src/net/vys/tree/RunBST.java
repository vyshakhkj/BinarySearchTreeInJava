package net.vys.tree;

import java.util.Scanner;

public class RunBST {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BinarySearchTree bst = new BinarySearchTree();
		System.out.println("Binary Search Tree\n");
		String response;
		char ch;
		/* Perform tree operations */
		do
		{
			System.out.println("\nBinary Search Tree Operations\n");
			System.out.println("1. Insert");
			System.out.println("2. Find");
			System.out.println("3. Delete");       
			int choice = scan.nextInt();            
			switch (choice)
			{
			case 1 : 
				System.out.println("Enter integer element to insert");
				System.out.println(bst.insert( scan.nextInt() ) ? "Value Inserted Successfully" : "Failed");

				break;                          
			case 2 : 
				System.out.println("Enter integer element to find");
				Node result = bst.find( scan.nextInt() );
				System.out.println(result != null ? "Value exist" : "Not Found");
				break;                         
			case 3 : 
				System.out.println("Enter integer element to delete");
				System.out.println(bst.delete(scan.nextInt()) ? "Value deleted" : "Value not found");

				break;                                          
			default : 
				System.out.println("Wrong Entry \n ");
				break;   
			}
			/* Display tree */
			bst.display(bst.root);
			System.out.println("\nDo you want to continue (Type y or n) \n");
			ch = scan.next().charAt(0);                        
		} while (ch == 'Y'|| ch == 'y');               
	}
}

