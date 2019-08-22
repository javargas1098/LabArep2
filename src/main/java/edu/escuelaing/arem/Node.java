package edu.escuelaing.arem;

public class Node {
	/**
	 * @author Javier Vargas
	 * 
	 * Nodo de la linkedlist
	 *
	 */	

	double data;
	Node next;

	/**
     * Constructor
     */
	public Node(Double d) {
		data = d;
		next = null;
	}

	public double getData() {
		return data;
	}

	public void setData(double data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}



}