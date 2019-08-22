package edu.escuelaing.arem;

public class linkedList {
	/**
	 * @author Javier Vargas
	 * 
	 * Implementacion de linkedlist
	 *
	 */

	private Head head;

	/**
	 * Constructor
	 */
	public linkedList() {
		head = new Head(null, null);
	}

	/**
	 * Este metodo inserta los valores a la linkedList
	 * 
	 * @param data FLoat  
	 * Son los datos resividos por parametro
	 * 
	 * @return float Linkedlist
	 * 
	 */
	public void insert(Double data) {
		Node new_node = new Node(data);
		new_node.next = null;
		if (head.getHead() == null)
			head.setHead(new_node);
		else {
			Node last = head.getHead();
			while (last.getNext() != null) {

				last = last.getNext();
			}
			last.setNext(new_node);
		}
		head.setNext(new_node);

	}
	/**
	 * Este metodo suma los datos de la linkedList
	 * 
	 * @param Linkedlist data 
	 * Datos insertados en la linkedlist
	 * 
	 * @return int sum
	 * 
	 */
	public double sum(linkedList data) {
		double sum = 0;
		Node currNode = data.head.getHead();
		while (currNode != null) {
			sum += currNode.getData();
			currNode = currNode.getNext();
		}
		return sum;

	}

	/**
	 * Este metodo suma los datos de la linkedList con un amedia debidamente
	 * calculada y luego dichos datos se elevan al cuadrado
	 * 
	 * @param Linkedlist data , float media 
	 * 
	 * Datos insertados en la linkedlist y la
	 *                   media de dichos datos
	 * 
	 * @return int sum
	 * 
	 */
	public double sum(linkedList data, double media) {
		double sum = 0;
		Node currNode = data.head.getHead();
		while (currNode != null) {
			// System.out.println(currNode.geData());
			sum += Math.pow(currNode.getData() - media, 2);
			currNode = currNode.getNext();
		}
		return sum;

	}

}