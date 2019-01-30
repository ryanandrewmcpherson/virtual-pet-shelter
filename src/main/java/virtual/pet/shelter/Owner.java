package virtual.pet.shelter;

public class Owner {

	private String userName;

	public Owner(String userName) {

		this.userName = userName;

	}

	public Pet feedPet(Pet pet, String food) {

		pet.eat(food);
		
		if(pet.favoriteFoods.contains(food))
		{
		 return pet;
		}
		else
		{
	     String favoriteFoodsString = pet.favoriteFoods.toString().substring(1,pet.favoriteFoods.toString().length() -1);
		 System.out.println(pet.getPetName() + " likes " + favoriteFoodsString);	
		 return pet;
		}
	}

	public void waterPet(Pet pet) {
		System.out.println("You watered " + "pet!");
		pet.drink();
	}

	public void playWith(Pet pet) {
		
        pet.play();
		
	}

	public String getName() {
		
		return userName;
	}

}
