package virtual.pet.shelter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Pet {

	private String petName;
	protected String playing;
	protected String excited;
	protected String type;
	protected List<String> favoriteFoods = new ArrayList<String>();
	private int hunger;
	private int thirst;
	private int boredom;
	private Map<String,Integer> attributes = new HashMap<String,Integer>();
	//protected String noise;
	//protected String wasteLoc;
	//protected String happy;
	//protected String mad;
	protected String playWith;
	

	public Map<String,Integer> getAttributes() {
		return attributes;
	}

	public void setAttributes() {
		attributes.clear();
		attributes.put("Hunger",hunger);
		attributes.put("Thirst",thirst);
		attributes.put("Boredom",boredom);
	}

	public int getHunger() {
		return hunger;
	}

	public void setHunger(int hunger) {
		this.hunger = hunger;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}


	public Pet(String petName) {
		this.setPetName(petName);
		hunger = 5;
		thirst = 5; 
		boredom = 5;
		attributes.put("Hunger",hunger);
		attributes.put("Thirst",thirst);
		attributes.put("Boredom",boredom);
	
	}

	public String play() {
		System.out.println("You are " + playWith);
		System.out.println(getPetName() + " is " + playing);
		if(boredom >= 5) {
			boredom -= 5;
		}
		else {
			boredom = 0;
		}	
		if(hunger <= 7)
		{
		    hunger+=3;
		}else {
			hunger = 10;
		}
		if(thirst<=8)
		{
			thirst+=2;
		}else {
			thirst = 10;
		}
		setAttributes();	
		return getPetName() + " is " + playing;
	}

	public String actExcited() {
		System.out.println(getPetName() + " is " + excited);
		return getPetName() + " is " + excited;
	}


//	public String getPetType(String petNameEntered) {
//		System.out.println(type);
//		return type;
//	}

	public String getPetType() {
		return type;
	}


	public String eat(String food) {
		for (String favoriteFood : favoriteFoods) {
			if (food.equalsIgnoreCase(favoriteFood)) {
				System.out.println(getPetName() + " ate some " + food + "! Yum!");
				if (hunger >= 7) {
					hunger-=7;
				} else {
					hunger=0; 
				}
				if (thirst <= 7) {
					thirst+=3;
				} else {
					thirst=10;
				}
				if(boredom >= 2) {
					boredom-=2;
				}else {
					boredom=0;
				}
				setAttributes();
				return "Yum!";
			}

		}
		if (getThirst() <= 9) {
			setThirst(getThirst() + 1);
		}
		System.out.println(getPetName() + " did not like " + food + "! Yuck!");
		setAttributes();
		return "Yuck!";
	}

	public void drink() {
		if(getThirst()>=7)
		{
		 setThirst(getThirst() - 7);
		}else {
	     setThirst(0);
		}
        setAttributes();
        System.out.println(petName + " lapped up the water!");
	}

	public int getThirst() {
		return thirst;
	}

	public void setThirst(int thirst) {
		this.thirst = thirst;
	}

	public int getBoredom() {
		return boredom;
	}

	public void setBoredom(int boredom) {
		this.boredom = boredom;
	}


}
//	public String actHappy() {
//		System.out.println(getPetName() + " is " + happy);
//		return getPetName() + " is " + happy;
//	}

//	public String makeNoise() {
//		System.out.println(getPetName() + " is " + noise);
//		return getPetName() + " is " + noise;
//	}

//	public String pee() {
//		System.out.println(getPetName() + " peed in " + wasteLoc);
//		return getPetName() + " peed in " + wasteLoc;
//	}
//
//	public String poop() {
//		System.out.println(getPetName() + " pooped in " + wasteLoc);
//		return getPetName() + " pooped in " + wasteLoc;
//	}
//	public String actMad() {
//		System.out.println(getPetName() + " is " + mad);
//		return getPetName() + " is " + mad;
//	}
//	public String bite() {
//		System.out.println(getPetName() + " bit you!");
//		return getPetName() + " bit you!";
//	}
