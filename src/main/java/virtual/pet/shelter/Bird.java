package virtual.pet.shelter;

public class Bird extends Pet {

	public Bird(String petName) {
		super(petName);
		favoriteFoods.add("seeds");
		favoriteFoods.add("worms");
		favoriteFoods.add("bugs");
		favoriteFoods.add("pellets");
		playing = "hopping around tweeting!";
		playWith = "flattering " + petName + "!";
		excited = "flying around rapidly!";
		type = "Bird";
//		noise = "chirping!";
//		wasteLoc = "his/her cage!";
//		happy = "singing!";
//		mad = "puffing up his/her feathers and squawking loudly!";
	}
	
//	@Override
//	public String pee() {
//		System.out.println(getPetName() + " pooped in his/her cage!");
//		return getPetName() + " pooped in his/her cage!";
//	}


}
