package virtual.pet.shelter;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class BirdTest {

	Pet tweety = new Bird("Tweety");

	@Test
	public void shouldFlyAroundRapidlyWhenActingExcited() {
		assertThat(tweety.actExcited(), is(equalTo("Tweety is flying around rapidly!")));
	}

	@Test
	public void shouldReturnBirdWhenPetTypeRequested() {
	
		assertThat(tweety.getPetType(), is(equalTo("Bird")));
	}

	@Test
	public void shouldBeAbleToSetAndRetrieveBoredom() {
		tweety.setBoredom(5);
		assertThat(tweety.getBoredom(), is(equalTo(5)));
	}

	@Test
	public void shouldBeAbleToSetAndRetrieveHunger() {
		tweety.setHunger(5);
		assertThat(tweety.getHunger(), is(equalTo(5)));
	}

	@Test
	public void shouldBeAbleToSetAndRetrieveThirst() {
		tweety.setThirst(5);
		assertThat(tweety.getThirst(), is(equalTo(5)));
	}

	@Test
	public void forPlayBoredomMinus5HungerPlus3ThirstPlus2WhenBoredomMoreEqual5HungerLessEqual7ThirstLessEqual8() {
		tweety.setBoredom(6);
		tweety.setHunger(6);
		tweety.setThirst(6);
		tweety.play();
		Map<String, Integer> attributesTest = new HashMap<String, Integer>();
		attributesTest.put("Boredom", 1);
		attributesTest.put("Hunger", 9);
		attributesTest.put("Thirst", 8);
		assertThat(tweety.getAttributes(), is(equalTo(attributesTest)));
	}

	@Test
	public void forPlayBoredom0Hunger10Thirst10WhenBoredomLess5HungerGreater7ThirstGreater8() {
		tweety.setBoredom(3);
		tweety.setHunger(8);
		tweety.setThirst(9);
		tweety.play();
		Map<String, Integer> attributesTest = new HashMap<String, Integer>();
		attributesTest.put("Boredom", 0);
		attributesTest.put("Hunger", 10);
		attributesTest.put("Thirst", 10);
		assertThat(tweety.getAttributes(), is(equalTo(attributesTest)));
	}

	@Test
	public void forEatFavFoodBoredomMinus2HungerMinus7ThirstPlus3WhenBoredomGreaterEqual2HungerGreaterEqual7ThirstLessEqual7() {
		tweety.setBoredom(3);
		tweety.setHunger(8);
		tweety.setThirst(6);
		tweety.eat("seeds");
		Map<String, Integer> attributesTest = new HashMap<String, Integer>();
		attributesTest.put("Boredom", 1);
		attributesTest.put("Hunger", 1);
		attributesTest.put("Thirst", 9);
		assertThat(tweety.getAttributes(), is(equalTo(attributesTest)));
	}

	@Test
	public void forEatFavFoodBoredom0Hunger0Thirst10WhenBoredomLess2HungerLess7ThirstGreater7() {
		tweety.setBoredom(1);
		tweety.setHunger(6);
		tweety.setThirst(8);
		tweety.eat("seeds");
		Map<String, Integer> attributesTest = new HashMap<String, Integer>();
		attributesTest.put("Boredom", 0);
		attributesTest.put("Hunger", 0);
		attributesTest.put("Thirst", 10);
		assertThat(tweety.getAttributes(), is(equalTo(attributesTest)));
	}

	@Test
	public void forNotEatFavFoodBoredomUnchHungerUnchThirstPlus1ifless10() {
		tweety.setBoredom(5);
		tweety.setHunger(5);
		tweety.setThirst(5);
		tweety.eat("french fries");
		Map<String, Integer> attributesTest = new HashMap<String, Integer>();
		attributesTest.put("Boredom", 5);
		attributesTest.put("Hunger", 5);
		attributesTest.put("Thirst", 6);
		assertThat(tweety.getAttributes(), is(equalTo(attributesTest)));
	}

	@Test
	public void forDrinkThirstShouldDecreaseBy7IfGreaterEqual7() {
		tweety.setBoredom(5);
		tweety.setHunger(5);
		tweety.setThirst(8);
		tweety.drink();
		Map<String, Integer> attributesTest = new HashMap<String, Integer>();
		attributesTest.put("Boredom", 5);
		attributesTest.put("Hunger", 5);
		attributesTest.put("Thirst", 1);
		assertThat(tweety.getAttributes(), is(equalTo(attributesTest)));
	}

	@Test
	public void forDrinkThirstShouldDecreaseTo0IfLess7() {
		tweety.setBoredom(5);
		tweety.setHunger(5);
		tweety.setThirst(6);
		tweety.drink();
		Map<String, Integer> attributesTest = new HashMap<String, Integer>();
		attributesTest.put("Boredom", 5);
		attributesTest.put("Hunger", 5);
		attributesTest.put("Thirst", 0);
		assertThat(tweety.getAttributes(), is(equalTo(attributesTest)));
	}
}
//
//	@Test
//	public void shouldReturnYuckWhenBirdDoesNotLikeFood() {
//		assertThat(tweety.eat("garlic"), is(equalTo("Yuck!")));
//	}
//
//	@Test
//	public void shouldReturnYumWhenBirdDoesLikeFood() {
//		assertThat(tweety.eat("seeds"), is(equalTo("Yum!")));
//	}
//
//	@Test
//	public void shouldSingWhenActingHappy() {
//		assertThat(tweety.actHappy(), is(equalTo("Tweety is singing!")));
//	}
//
//
//	@Test
//	public void shouldPuffUpFeathersAndSquawkLoudlyWhenActingMad() {
//		assertThat(tweety.actMad(), is(equalTo("Tweety is puffing up his/her feathers and squawking loudly!")));
//	}
//
//	@Test
//	public void shouldPoopInTheCageWhenPeeMethodCalledSinceBirdsDoNotPee() {
//		assertThat(tweety.pee(), is(equalTo("Tweety pooped in his/her cage!")));
//	}
//
//	@Test
//	public void shouldPoopInTheCageWhenPoopMethodCalled() {
//		assertThat(tweety.poop(), is(equalTo("Tweety pooped in his/her cage!")));
//	}
//
//	@Test
//	public void shouldChirpWhenMakingNoise() {
//		assertThat(tweety.makeNoise(), is(equalTo("Tweety is chirping!")));
//	}	
//    @Test
//	public void tweetyShouldBiteYouWhenBiting() {
//		assertThat(tweety.bite(), is(equalTo("Tweety bit you!")));
//	}