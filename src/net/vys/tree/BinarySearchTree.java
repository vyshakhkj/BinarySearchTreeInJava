package net.vys.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class BinarySearchTree {

	public static Node root = new Node(0);

	public BinarySearchTree() {
	}

	public boolean insert(int data){
		Node newNode = new Node(data);
		if (root.getData() == 0) {
			root.setData(data);
			root.setLeftNode(null);
			root.setRightNode(null);
			return true;
		}
		Node current = root;
		Node parent = null;
		while (true) {
			parent = current;
			if (current.getData() < data) {
				current = parent.getRightNode();
				if (current == null) {
					parent.setRightNode(newNode);
					return true;
				}
			} else if (current.getData() > data) {
				current = parent.getLeftNode();
				if (current == null) {
					parent.setLeftNode(newNode);
					return true;
				}
			} else {
				return false;
			}
		}
	}

	public Node find(int data) {
		if (root == null) {
			return null;
		}
		if (root.getData() == data) {
			return root;
		}
		Node current = root;
		while (current != null) {
			if (current.getData() == data) {
				return current;
			} else if (current.getData() < data) {
				current = current.getLeftNode();
			} else if (current.getData() > data) {
				current = current.getRightNode();
			}
		}
		return null;
	}

	public boolean delete(int data) {
		Node parentNode = root;
		Node currentNode = root;
		while (currentNode.getData() != data) {
			parentNode = currentNode;
			if(currentNode.getData() < data){
				currentNode = currentNode.getRightNode();
			} else {
				currentNode = currentNode.getLeftNode();
			}
			if (currentNode == null) {
				return false;
			}
		}

		if (currentNode.getLeftNode() == null && currentNode.getRightNode() == null) {
			if (currentNode == root) {
				root = null;
				return true;
			} else if (parentNode.getLeftNode() == currentNode) {
				parentNode.setLeftNode(null);
				return true;
			} else if (parentNode.getRightNode() == currentNode) {
				parentNode.setRightNode(null);
				return true;
			}
		} else if (currentNode.getLeftNode() == null) {
			if (currentNode == root) {
				root = currentNode.getRightNode();
				return true;
			} else if (parentNode.getLeftNode() == currentNode) {
				parentNode.setLeftNode(currentNode.getRightNode());
				return true;
			} else if (parentNode.getRightNode() == currentNode) {
				parentNode.setRightNode(currentNode.getRightNode());
				return true;
			}
		} else if (currentNode.getRightNode() == null) {
			if (currentNode == root) {
				root = currentNode.getLeftNode();
				return true;
			} else if (parentNode.getLeftNode() == currentNode) {
				parentNode.setLeftNode(currentNode.getLeftNode());
				return true;
			} else if (parentNode.getRightNode() == currentNode) {
				parentNode.setRightNode(currentNode.getLeftNode());
				return true;
			}
		} else if (currentNode.getLeftNode() != null && currentNode.getRightNode() != null) {
			// delete current node with both child.
			Node smallNodeOfcurrentNode = getSmallNodeOfcurrentNode(currentNode);
			if (currentNode == root) {
				root = smallNodeOfcurrentNode;
				smallNodeOfcurrentNode.setLeftNode(currentNode.getLeftNode());
				return true;
			} else if (parentNode.getLeftNode() == currentNode) {
				parentNode.setLeftNode(smallNodeOfcurrentNode);
				smallNodeOfcurrentNode.setLeftNode(currentNode.getLeftNode());
				return true;
			} else if (parentNode.getRightNode() == currentNode) {
				parentNode.setRightNode(smallNodeOfcurrentNode);
				smallNodeOfcurrentNode.setLeftNode(currentNode.getLeftNode());
				return true;
			}
		}
		return false;
	}

	private Node getSmallNodeOfcurrentNode(Node deleteNode) {
		Node smallNodeOfCurrentNode = null;
		Node parentSmallNodeOfCurrent = null;
		Node currentNode = deleteNode.getRightNode();
		while (currentNode != null) {
			parentSmallNodeOfCurrent = smallNodeOfCurrentNode;
			smallNodeOfCurrentNode = currentNode;
			currentNode = currentNode.getLeftNode();
		}
		if (smallNodeOfCurrentNode != deleteNode) {
			parentSmallNodeOfCurrent.setLeftNode(smallNodeOfCurrentNode.getRightNode());
			smallNodeOfCurrentNode.setRightNode(deleteNode.getRightNode());
		}
		return smallNodeOfCurrentNode;
	}

	/*
	 * public void display(Node root) { if (root != null) { display(root.getLeftNode()); System.out.print(" " + root.getData()); display(root.getRightNode()); }
	 * }
	 */


	public void display(Node root) {

		Queue<Node> currentLevel = new LinkedList<Node>();
		Queue<Node> nextLevel = new LinkedList<Node>();

		currentLevel.add(root);

		while (!currentLevel.isEmpty()) {
			Iterator<Node> iter = currentLevel.iterator();
			while (iter.hasNext()) {
				Node currentNode = iter.next();
				if (currentNode.getLeftNode() != null) {
					nextLevel.add(currentNode.getLeftNode());
				}
				if (currentNode.getRightNode() != null) {
					nextLevel.add(currentNode.getRightNode());
				}
				System.out.print(currentNode.getData() + " ");
			}
			System.out.println();
			currentLevel = nextLevel;
			nextLevel = new LinkedList<Node>();

		}

	}

}
