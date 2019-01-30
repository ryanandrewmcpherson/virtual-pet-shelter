package virtual.pet.shelter;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class CaretakerTest {

	Caretaker jack = new Caretaker("Jack");
	VirtualPetShelter shelter = new VirtualPetShelter();
	Pet tweety = shelter.admitPet(new Bird("Tweety"));
	Pet fido = shelter.admitPet(new Dog("Fido"));
	Pet sylvester = shelter.admitPet(new Cat("Sylvester"));

	@Test
	public void hungerShouldDecreaseByUpTo7ThirstShouldIncreaseByUpTo3BoredomShouldDecreaseByUpTo2() {
		tweety.setBoredom(2);
		tweety.setHunger(7);
		tweety.setThirst(7);
		jack.feedPets(shelter);
		Map<String, Integer> attributesTest = new HashMap<String, Integer>();
		attributesTest.put("Boredom", 0);
		attributesTest.put("Hunger", 0);
		attributesTest.put("Thirst", 10);
		assertThat(tweety.getAttributes(), is(equalTo(attributesTest)));
	}

	@Test
	public void thirstShouldDecreaseByUpTo7WhenAllPetsAreWatered() {
		tweety.setBoredom(2);
		tweety.setHunger(7);
		tweety.setThirst(7);
		jack.waterPets(shelter);
		Map<String, Integer> attributesTest = new HashMap<String, Integer>();
		attributesTest.put("Boredom", 2);
		attributesTest.put("Hunger", 7);
		attributesTest.put("Thirst", 0);
		assertThat(tweety.getAttributes(), is(equalTo(attributesTest)));
	}

	@Test
	public void shouldBeAbleToCheckAllPetsWithoutChangingAttributes() {
	 assertThat(jack.checkPets(shelter),is(equalTo(shelter)));	
	}

	@Test
	public void shouldBeAbleToGetPetOutToInteractWith() {
		assertThat(jack.getPetOut(shelter, "Fido"), is(equalTo(fido)));
	}

}
