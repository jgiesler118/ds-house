//Jovana Giesler
package dsproj4;

public class Node<E> {
	private E data;
	private Node<E> next;

	/**
	 * Constructor creates new node
	 * 
	 * @param initialData value to be used for data
	 * @param initialNext value to be used for next
	 */

	public Node(E initialData, Node<E> initialNext) {
		data = initialData;
		next = initialNext;
	}

	/**
	 * getElevatorType method to return data
	 * 
	 * @return value in data field
	 */
	public E getData() {
		return data;
	}

	/**
	 * getNext method to return next
	 * 
	 * @return value in next field
	 */

	public Node<E> getNext() {
		return next;
	}

	/**
	 * method to change data
	 * 
	 * @param newData new value of data
	 */
	public void setData(E newData) {
		data = newData;
	}

	/**
	 * method to change next
	 * 
	 * @param newNext new value of next
	 */
	public void setNext(Node<E> newNext) {
		next = newNext;
	}
}