//Jovana Giesler
package dsproj4;

public class SinglyLinkedList<E extends Comparable<E>> {
	private Node<E> head;
	private Node<E> tail;
	private int numElements;

	/**
	 * no-arg constructor for Singly Linked List
	 */
	public SinglyLinkedList() {
		head = null;
		tail = null;
		numElements = 0;
	}

	/**
	 * method to get size
	 * 
	 * @return value of size
	 */
	public int getSize() {
		return numElements;
	}

	/**
	 * method to add element
	 * 
	 * @param newElement element to be added
	 */
	public void add(E newElement) {
		boolean placed = false;
		Node<E> cursor = head, previous = null;

		if (head == null) {
			head = new Node<E>(newElement, head);
			tail = head;
		} else {
			while (cursor != null && !placed) {
				if (newElement.compareTo(cursor.getData()) <= 0) {
					if (previous == null) {
						head = new Node<E>(newElement, head);
					} else {
						previous.setNext(new Node<E>(newElement, previous.getNext()));
						if (previous == tail) {
							tail = previous.getNext();
						}

					}
					placed = true;
				} else {
					previous = cursor;
					cursor = cursor.getNext();
				}
			}
			if (!placed && previous != null) {
				previous.setNext(new Node<E>(newElement, null));
				if (previous == tail) {
					tail = previous.getNext();
				}
			}
		}
		numElements++;
	}

	/**
	 * checks if element exists in list
	 * 
	 * @param target element to be found
	 * @return true if element is present
	 */
	public boolean exists(E target) {
		boolean found = false;
		Node<E> cursor = head;
		while (cursor != null && !found) {
			if (cursor.getData().equals(target))
				found = true;
			else
				cursor = cursor.getNext();
		}
		return found;
	}

	/**
	 * counts how many times an element appears in list
	 * 
	 * @param target element to be found
	 * @return number of times element appears
	 */
	public int countOccurrences(E target) {
		int occ = 0;
		Node<E> cursor;

		for (cursor = head; cursor != null; cursor = cursor.getNext()) {
			if (cursor.getData().equals(target))
				occ++;
		}
		return occ;
	}

	/**
	 * removes an element from the list
	 * 
	 * @param target element to be removed
	 * @return true if element is successfully removed
	 */
	public boolean remove(E target) { // copied directly from ch4 slides
		Node<E> cursor = head, previous = null;
		boolean found = false;

		while (cursor != null && !found) {
			if (cursor.getData().equals(target))
				found = true;
			else {
				previous = cursor;
				cursor = cursor.getNext();
			}
		}

		if (found && cursor != null) {
			if (previous == null)
				head = head.getNext();
			else
				previous.setNext(cursor.getNext());

			if (tail == cursor)
				tail = previous;
			numElements--;
		}
		return found;
	}

	public Lister<E> iterator() {
		return new  Lister<E>(head);
	}

}
