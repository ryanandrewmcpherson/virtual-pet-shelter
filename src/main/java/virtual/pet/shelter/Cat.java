package virtual.pet.shelter;

public class Cat extends Pet {

	public Cat(String petName) {
		super(petName);
		favoriteFoods.add("fish");
		favoriteFoods.add("rodent");
		favoriteFoods.add("bird");
		favoriteFoods.add("cat food");
        playing = "chasing the toy mouse!";
        playWith = "pulling a toy mouse on the end of a string!";  
        excited = "purring, meowing and weaving around his legs!";
        type = "Cat";
//        noise = "meowing!";
//        wasteLoc = "his/her litter box and buried it!";
//        happy = "purring!";  
//        mad = "hissing and growling!";
	}	
}
