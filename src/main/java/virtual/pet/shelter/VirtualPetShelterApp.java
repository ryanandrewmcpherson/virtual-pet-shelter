package virtual.pet.shelter;

import java.util.Calendar;
import java.util.Map;
import java.util.Scanner;

public class VirtualPetShelterApp {

	static Scanner input = new Scanner(System.in);
	private static Owner user;
	private static Caretaker careTaker;
	private static VirtualPetShelter shelter = new VirtualPetShelter();
	static long lastTime;

	public static void main(String[] args) {

		welcomeMessage();

		System.out.println("Please enter your name:");
		String ownerName = quitFilter(input.nextLine());
		ownerName = ownerName.substring(0, 1).toUpperCase() + ownerName.substring(1).toLowerCase();
		user = new Owner(ownerName);
		nameCaretakerMessage(ownerName);
		careTaker = new Caretaker(quitFilter(input.nextLine()));
		shelter = new VirtualPetShelter();
		boolean loopCondition = true;
		lastTime = Calendar.getInstance().getTimeInMillis();

		do {
			if (shelter.getNumPets() == 0) {
				admitPetLoop();
			}
			String menuSelection = printMenu();
			switch (menuSelection) {
			case "1": {
				shelter = careTaker.feedPets(shelter);
				break;
			}
			case "2": {
				shelter = careTaker.waterPets(shelter);
				break;
			}
			case "3": {
				System.out.println(user.getName() + ", please enter the name of the pet you would like to get out!");
				String petName = quitFilter(input.nextLine());
				petName = petName.substring(0, 1).toUpperCase() + petName.substring(1).toLowerCase();
				try {
					petInteractionLoop(careTaker.getPetOut(shelter, petName));
				} catch (Exception NullPointerException) {
					System.out.println("Pet Not Found!");
					System.out.println("Pets available to interact with:");
					shelter.listPets();
				}
				break;
			}
			case "4": {
				int size = shelter.getNumPets();
				while (size == shelter.getNumPets()) {
					System.out.print("What kind of pet do you have?");
					String petToAdmit = quitFilter(input.nextLine());
					petToAdmit = petToAdmit.substring(0, 1).toUpperCase() + petToAdmit.substring(1).toLowerCase();
					admitPetSwitch(petToAdmit);
				}
				break;
			}
			case "5": {
				int size = shelter.getNumPets();
				while (size == shelter.getNumPets()) {
					System.out.print("Which pet would you like to adopt?");
					String petToAdopt = quitFilter(input.nextLine());
					petToAdopt = petToAdopt.substring(0, 1).toUpperCase() + petToAdopt.substring(1).toLowerCase();
					try {
						shelter.adoptPet(careTaker.getPetOut(shelter, petToAdopt));
					} catch (Exception NullPointerException) {
						System.out.println("Pet Not Found!");
						System.out.println("Pets available to adopt:");
						shelter.listPets();
					}
				}
				break;
			}
			default: {
				System.out.print("Invalid Selection!");
			}
			}
          tick();
		} while (loopCondition);
	}

	private static String printMenu() {
		System.out.println("\n" + careTaker.caretakerName + " has checked on the pets!");
		System.out.println("This is their status:\n");
		careTaker.checkPets(shelter);
		System.out.println("\nWhat would you like to have him do next?");
		System.out.println("1. Feed All The Pets");
		System.out.println("2. Water All The Pets");
		System.out.println("3. Get a pet out to interact with");
		System.out.println("4. Admit a pet");
		System.out.println("5. Process a pet for adoption");

		return input.nextLine();
	}

	private static void welcomeMessage() {
		System.out.println("Welcome to Virtual Pet Shelter!");
		System.out.println("This app will simulate running a virtual pet shelter!");
		System.out.println("If you wish to quit just type quit at any time!");
	}

	private static void nameCaretakerMessage(String ownerName) {
		System.out.println("\n" + ownerName + ", what is the caretakers name?");
		System.out.println("The caretakers name is:");
	}

	private static String quitFilter(String input) {
		if (input.equalsIgnoreCase("Quit")) {
			System.exit(0);
		}
		return input;
	}

	private static void admitPetLoop() {

		boolean done;

		do {
			done = true;
			System.out.println("There are currently " + shelter.getNumPets() + " pet(s) in the shelter!");
			shelter.listPets();
			System.out.println("To admit a pet, type add. Type done when finished admitting pets.");
			String addString = quitFilter(input.nextLine()).toLowerCase();
			switch (addString) {
			case "done": {
				if (shelter.getNumPets() == 0) {
					System.out.println("Please admit at least one pet! Type add to continue or quit to quit!");
					addString = quitFilter(input.nextLine());
					continue;
				}
				break;
			}
			case "add": {
				done = false;
				System.out.println("What kind of pet would you like to admit?");
				String petToAdmit = quitFilter(input.nextLine());
				petToAdmit = petToAdmit.substring(0, 1).toUpperCase() + petToAdmit.substring(1).toLowerCase();
				admitPetSwitch(petToAdmit);
				break;
			}
			default: {
				System.out.println("Invalid Input!");
				done = false;
			}
			}

		} while (!done);

		System.out.println("Press Enter to continue or type quit to quit");
		quitFilter(input.nextLine());
	}

	private static void admitPetSwitch(String petToAdmit) {

		petToAdmit.toLowerCase();

		switch (petToAdmit) {
		case "Bird": {
			System.out.println("Please name the bird! Bird's Name:");
			String birdName = quitFilter(input.nextLine());
			birdName = birdName.substring(0, 1).toUpperCase() + birdName.substring(1).toLowerCase();
			shelter.admitPet(new Bird(birdName));
			break;
		}
		case "Cat": {
			System.out.println("Please name the cat! Cat's Name:");
			String catName = quitFilter(input.nextLine());
			catName = catName.substring(0, 1).toUpperCase() + catName.substring(1).toLowerCase();
			shelter.admitPet(new Cat(catName));
			break;
		}
		case "Dog": {
			System.out.println("Please name the dog! Dog's Name:");
			String dogName = quitFilter(input.nextLine());
			dogName = dogName.substring(0, 1).toUpperCase() + dogName.substring(1).toLowerCase();
			shelter.admitPet(new Dog(dogName));
			break;
		}
		default: {
			System.out.println(petToAdmit + "s are not currently supported by Virtual Pet Shelter");
			System.out.println("Virtual Pet Shelter currently supports Cats,Dogs, and Birds");
			break;
		}
		}
	}

	private static VirtualPetShelter petInteractionLoop(Pet petToInteractWith) {
		boolean interact = true;
		do {
			System.out.println(user.getName() + ", this is " + petToInteractWith.getPetName() + "'s status:");
			System.out.printf("%-15.15s", "\n" + petToInteractWith.getPetName());
			for (Map.Entry<String, Integer> attribute : petToInteractWith.getAttributes().entrySet()) {
				System.out.printf("%-15.15s", attribute.toString().replace("=", ":"));
			}
			System.out.println("\nWhat would you like to do " + user.getName() + " ?");
			System.out.println("1. Feed " + petToInteractWith.getPetName());
			System.out.println("2. Water " + petToInteractWith.getPetName());
			System.out.println("3. Play with " + petToInteractWith.getPetName());
			System.out.println("4. Return to main menu ");
			String menuOption = quitFilter(input.nextLine());

			switch (menuOption) {
			case "1": {
				System.out.println("What would you like to feed " + petToInteractWith.getPetName() + "?");
				user.feedPet(petToInteractWith, quitFilter(input.nextLine()));
				break;
			}
			case "2": {
				user.waterPet(petToInteractWith);
				break;
			}
			case "3": {
				user.playWith(petToInteractWith);
				break;
			}
			case "4": {
				interact = false;
			}
			default: {
				System.out.println("Invalid selection!");
				break;
			}
			
			}
			tick();
		} while (interact);

		return shelter;
	}

	private static VirtualPetShelter tick() {
		long time = Calendar.getInstance().getTimeInMillis();
		for(Pet pet: shelter.getPets().values())
		{
		 for(int attributeValue :pet.getAttributes().values())
		 {
		  if(attributeValue + (int) (time - lastTime)/5000 <= 10)
		  {
		    attributeValue += (int) (time - lastTime)/5000;
		  }
		 }
		}
		lastTime = time;
		return shelter;

	}

}
