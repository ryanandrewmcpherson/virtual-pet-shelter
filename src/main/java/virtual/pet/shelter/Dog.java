package virtual.pet.shelter;

public class Dog extends Pet {

	public Dog(String petName) {
		super(petName);
		favoriteFoods.add("bone");
		favoriteFoods.add("squirrel");
		favoriteFoods.add("dog food");
		favoriteFoods.add("table scraps");
	    playing = "retrieving the frisbee!";
	    playWith = "throwing the frisbee for " + petName + " ";
	    excited = "barking, wagging his/her tail and jumping around!";
	    type = "Dog";
//		noise = "barking!";
//	    wasteLoc = "the yard!";
//	    happy = "wagging his/her tail!";  
//	    mad = "barking loudly and growling!";
	}
}
