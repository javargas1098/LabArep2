package edu.escuelaing.arem;
public class Head {
	/**
	 * @author Javier Vargas
	 * 
	 * Cabeza y cola del nodo
	 *
	 */
	 Node head;
	 Node next;
	 /**
	 * Constructor
	 */
	public Head(Node first, Node last) {
		head = first;
		next = last;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}


}