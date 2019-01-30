package virtual.pet.shelter;

import java.util.Map;

public class Caretaker {

	final String caretakerName;

	public Caretaker(String caretakerName) {
		this.caretakerName = caretakerName;
	}

	public VirtualPetShelter feedPets(VirtualPetShelter shelter) {
		for (Pet pet : shelter.getPets().values()) {
			if (pet.getPetType().equalsIgnoreCase("Bird")) {
				System.out.print(caretakerName + " is pouring " + pet.getPetName() + "'s seed! ");
				System.out.println(pet.getPetName() + " is excited to eat!");
				pet.actExcited();
				System.out.print(caretakerName + " set down " + pet.getPetName() + "'s bowl of seeds!");
				pet.eat("seeds");
			} else if (pet.getPetType().equalsIgnoreCase("Cat")) {
				System.out.print(caretakerName + "  is pouring " + pet.getPetName() + "'s seed! ");
				System.out.println(pet.getPetName() + " is excited to eat!");
				pet.actExcited();
				System.out.print(caretakerName + "  set down " + pet.getPetName() + "'s bowl of cat food!");
				pet.eat("cat food");
			} else if (pet.getPetType().equalsIgnoreCase("Dog")) {
				System.out.print(caretakerName + "  is pouring " + pet.getPetName() + "'s seed! ");
				System.out.println(pet.getPetName() + " is excited to eat!");
				pet.actExcited();
				System.out.print(caretakerName + "  set down " + pet.getPetName() + "'s bowl of dog food!");
				pet.eat("dog food");
			}
		}
		return shelter;
		
	}

	public VirtualPetShelter waterPets(VirtualPetShelter shelter) {
		for (Map.Entry<String, Pet> pet : shelter.getPets().entrySet()) {
			pet.getValue().drink();
		}
		return shelter;
	}

	public VirtualPetShelter checkPets(VirtualPetShelter shelter) {
		System.out.printf("%-15.15s", "\nPet Name");
		for (Map.Entry<String, Pet> pet : shelter.getPets().entrySet()) {
			System.out.printf("%-15.15s", "\n" + pet.getKey());
			for (Map.Entry<String, Integer> attribute : pet.getValue().getAttributes().entrySet()) {
				System.out.printf("%-15.15s", attribute.toString().replace("=", ":"));
			}
		}
		return shelter;
	}

	public Pet getPetOut(VirtualPetShelter vPS, String petName) throws NullPointerException {
		Pet toInteractWith = vPS.getPets().get(petName);
		return toInteractWith;
	}

}
