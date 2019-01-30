# Virtual Pet Shelter
	Simulates running a virtual pet shelter

## App Layout
1. user is greeted then prompted for their name - they can type quit at any time to quit
2. user is prompted to name the caretaker of the virtual pet shelter
3. admit pet loop do while not done
   1. display number of pets in the shelter
   2. list the pets in the shelter and their type
   3. add to add or done to finish adding
      1. done - continue to add step if not done - done by default
        1. if no pets prompts user to add or quit - continue to add step if not quit
        2. if there are pets it breaks the loop and continues to the main menu
      2. add
      	1. requests type of pet to add
      	2. admit pet switch
      	   1. if bird name the bird, creates the bird / break
      	   2. if cat name the cat, creates the cat / break
      	   3. if dog name the dog, creates the dog / break
      	   default pet type not supported / break 
      	3. sets done to false so loop will restart and user will be asked add or done again
      default 
        1. tells user selection is invalid
        2. sets done to false so loop will restuart and uswer wll have opportunity for valid input again
   4. Once done, user will be prompted to press enter to continue or type quit to quit
4. main loop
    1. print menu
        1. caretaker checks pets and status of pets is displayed
		1. user is prompted what would they like the caretaker to do and main menu prints
	2. user choice is saved as menu selection 
	3. main menu switch (menu selection)
	   1. have caretaker feed all pets
	   2. have caretaker water all pets
	   3. interact with a pet
	      1. interact loop while interact true (true by default)
	        1. pet status
	      	2. switch(pet)
		   	    1. feed pet
		   	        1. what type of food to feed
	                2. feed pet method
		   	    2. water pet
		   	    3. play with pet
		   	    4. main menu, interact = false;
	   	      default. "invalid selection"
	   	    3.tick
	   4. admit a pet
	   5. adopt a pet
	4. tick() = adusts pet attributes to real time   
-progam doesn't end until user types quit

## Classes
  1. VirtualPetShelterApp
  2. VirtualPetShelter
  3. Owner (user)
  4. Caretaker 
  5. Pet
  	1. Bird
  	2. Cat
  	3. Dog

## Test Classes
  1. VirtualPetShelterTest
  2. OwnerTest (user)
  3. CaretakerTest 
  4. Pet
  	1. BirdTest
  	2. CatTest
  	3. DogTest
