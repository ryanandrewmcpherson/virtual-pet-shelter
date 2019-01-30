package virtual.pet.shelter;

import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	private Map<String, Pet> pets = new HashMap<String, Pet>();

	public int getNumPets() {
		return getPets().size();
	}

	public Pet admitPet(Pet pet) {

		getPets().put(pet.getPetName(), pet);

		return pet;
	}

	public void adoptPet (Pet pet) throws NullPointerException{
		getPets().remove(pet.getPetName(), pet);
	}

	public Pet interactWithPet(String petName) {
		Pet toInteractWith = getPets().get(petName);
		return toInteractWith;
	}

	public Map<String,String> listPets() {
	    Map<String,String> petsListMap= new HashMap <String,String>();
	    
	    for(Map.Entry<String,Pet> pet: getPets().entrySet())
	    {
	    	System.out.printf("%-15.15s Type:" + pet.getValue().getPetType() + "\r",pet.getKey());
	    	petsListMap.put(pet.getKey(),pet.getValue().getPetType());
	    }
	    	
		return petsListMap;
	}

	public Map<String, Pet> getPets() {
		return pets;
	}

	public void setPets(Map<String, Pet> pets) {
		this.pets = pets;
	}

}
