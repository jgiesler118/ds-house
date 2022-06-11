//Jovana Giesler
package dsproj4;

import java.util.Scanner;

public class House {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		Location kitchen = new Location("Kitchen");
		Location pantry = new Location("Pantry");
		Location diningRoom = new Location("Dining Room");
		Location backFoyer = new Location("Back Foyer");
		Location frontFoyer = new Location("Front Foyer");
		Location library = new Location("Library");
		Location livingRoom = new Location("Living Room");
		Location stairs = new Location("Stairs");
		Location upstairsHallway = new Location("Upstairs Hallway");
		Location bathroom = new Location("Bathroom");
		Location bedroom = new Location("Bedroom");
		Location office = new Location("Office");
		Location mBathroom = new Location("Master Bathroom");
		Location mBedroom = new Location("Master Bedroom");

		kitchen.addNeighbor(pantry);
		pantry.addNeighbor(kitchen);

		pantry.addNeighbor(diningRoom);
		diningRoom.addNeighbor(pantry);

		diningRoom.addNeighbor(frontFoyer);
		frontFoyer.addNeighbor(diningRoom);

		kitchen.addNeighbor(backFoyer);
		backFoyer.addNeighbor(kitchen);

		backFoyer.addNeighbor(frontFoyer);
		frontFoyer.addNeighbor(backFoyer);

		frontFoyer.addNeighbor(livingRoom);
		livingRoom.addNeighbor(frontFoyer);

		backFoyer.addNeighbor(library);
		library.addNeighbor(backFoyer);

		// connect and build second floor
		frontFoyer.addNeighbor(stairs);
		stairs.addNeighbor(frontFoyer);

		stairs.addNeighbor(upstairsHallway);
		upstairsHallway.addNeighbor(stairs);

		stairs.addNeighbor(bathroom);
		bathroom.addNeighbor(stairs);

		bathroom.addNeighbor(bedroom);
		bedroom.addNeighbor(bathroom);

		bedroom.addNeighbor(upstairsHallway);
		upstairsHallway.addNeighbor(bedroom);

		office.addNeighbor(upstairsHallway);
		upstairsHallway.addNeighbor(office);

		mBathroom.addNeighbor(mBedroom);
		mBedroom.addNeighbor(mBathroom);

		mBedroom.addNeighbor(upstairsHallway);
		upstairsHallway.addNeighbor(mBedroom);

		// System.out.println(displayLinkedListDescription(upstairsHallway.getNeighbors()));

		Location currentVertex = frontFoyer;
		int userChoice;

		do {
			System.out.println("You are currently in: " + currentVertex.getDescription());
			System.out.println("\nNeighbors of " + currentVertex.getDescription() + " are: ");
			System.out.println(displayLinkedListDescription(currentVertex.getNeighbors()));
			System.out.println("Where would you like to go? (-1 to exit): ");

			userChoice = input.nextInt();

			while (userChoice < -1 || userChoice > maxChoice(currentVertex.getNeighbors())) {
				System.out.println("That value is out of bounds. Please enter a number between 1 and "
						+ (maxChoice(currentVertex.getNeighbors()) - 1) + ".");
				userChoice = input.nextInt();
			}

			Location newLocation = null;

			Lister<Location> locationLister = (Lister<Location>) currentVertex.getNeighbors().iterator();
			int counter = 1;
			while (counter <= userChoice) {
				Location displayLocation = locationLister.next();
				newLocation = displayLocation;

				counter++;
			}

			if (userChoice == -1) {
				System.out.println("Goodbye!");
			}

			currentVertex = newLocation;

		} while (userChoice != -1);

	}

	public static String displayLinkedListDescription(SinglyLinkedList<Location> listToDisplay) {
		String returnResult = "";

		Lister<Location> locationLister = (Lister<Location>) listToDisplay.iterator();
		int counter = 1;
		while (locationLister.hasNext()) {
			Location displayLocation = locationLister.next();
			System.out.print(counter + " - " + displayLocation.getDescription());
			if (locationLister.hasNext()) {
				System.out.print(", ");
			}
			counter++;
		}

		return returnResult;

	}

	public static int maxChoice(SinglyLinkedList<Location> listToDisplay) {

		Lister<Location> locationLister = (Lister<Location>) listToDisplay.iterator();
		int counter = 1;
		while (locationLister.hasNext()) {
			Location displayLocation = locationLister.next();
			counter++;
		}

		return counter;

	}
}
