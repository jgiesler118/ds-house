//Jovana Giesler
package dsproj4;

public class Location implements Comparable<Location> {
	private String description;
	private SinglyLinkedList<Location> neighbors = new SinglyLinkedList<Location>();

	/**
	 * Constructor creates new location
	 * 
	 * @param initDescription description of location
	 */
	public Location(String initDescription) {
		description = initDescription;
	}

	/**
	 * getDescription method to return description
	 * 
	 * @return value in description field
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * isNeighbor method to see if other location is a neighbor
	 * 
	 * @param otherLocation location to look for in neighbor list
	 * @return true if neighbor found
	 */
	public boolean isNeighbor(Location otherLocation) {
		return neighbors.equals(otherLocation);
	}

	/**
	 * compareTo method to compare location by description
	 * 
	 * @return 0 if equal, -1 if less than, 1 if greater than
	 */
	public int compareTo(Location otherLocation) {
		return description.compareTo(otherLocation.getDescription());
	}

	/**
	 * equals method determines if two locations are equal
	 */
	public boolean equals(Object otherLocation) {
		if (description == ((Location) otherLocation).getDescription()) {
			return true;
		} else
			return false;

	}

	/**
	 * addNeighbor method adds Location to neighbor list
	 * 
	 * @param neighbor new Location to add
	 */
	public void addNeighbor(Location neighbor) {
		neighbors.add(neighbor);
	}

	/**
	 * toString method makes Location printable
	 */
	public String toString() {
		return (description + "\n" + neighbors.toString());
	}

	/**
	 * numNeighbors returns number of neighbors
	 * 
	 * @return number of neighbors
	 */
	public int numNeighbors() {
		return neighbors.getSize();
	}

	/**
	 * 
	 * @return Lister of neighbors
	 */
	public Lister<Location> neighbors() {
		return neighbors.iterator();
	}

	public SinglyLinkedList<Location> getNeighbors() {
		return neighbors;
	}
}
