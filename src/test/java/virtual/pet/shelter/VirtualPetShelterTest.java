package virtual.pet.shelter;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class VirtualPetShelterTest {

	VirtualPetShelter shelter = new VirtualPetShelter();

	@Test
	public void shouldReturnSize0WhenThereAreNoPets() {
		assertThat(shelter.getNumPets(), is(equalTo(0)));
	}

	@Test
	public void shouldReturnSize1WhenThereIs1Pet() {
		@SuppressWarnings("unused")
		Pet tweety = shelter.admitPet(new Bird("tweety"));
		assertThat(shelter.getNumPets(), is(equalTo(1)));
	}

	@Test
	public void shouldReturnSize0WhenPetIsAdopted() {
		Pet tweety = shelter.admitPet(new Bird("Tweety"));
		shelter.adoptPet(tweety);
		assertThat(shelter.getNumPets(), is(equalTo(0)));

	}
	@Test
	public void shouldListPetsInShelterAndTheirTypes()
	{
		Pet tweety = shelter.admitPet(new Bird("Tweety"));
		Pet fido = shelter.admitPet(new Dog("Fido"));
		Pet sylvester = shelter.admitPet(new Cat("Sylvester"));	
		Map<String,String> petsListMap = new HashMap<String,String>();
		petsListMap.put("Tweety",tweety.getPetType());
		petsListMap.put("Sylvester",sylvester.getPetType());
		petsListMap.put("Fido",fido.getPetType());
		
		assertThat(shelter.listPets(),is(equalTo(petsListMap)));
	}

}
