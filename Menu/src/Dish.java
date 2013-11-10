// The amount 1 dish serves (howManyServedByDish)
// The steps you take to prepare a dish [createProcedure()]
// (Display) Take in from the day class the number of people attending(done) then divide that by the amount served by a single dish (done) to
// calc the number of dishes needed, and apply that to the ingredients(Done)
import java.util.ArrayList;

public class Dish {
	final int RESTRAINT = 20;
	final int INGREDIENT_RESTRAINT = 15;
	private String myDishName;
	private ArrayList<Ingredient> myIngredients;
	private ArrayList<String> mySteps;
	private int myNumServed;

	public Dish() {
		myDishName = nameDish();
		myNumServed = howManyServedByDish();
		myIngredients = addIngredients();
		mySteps = createProcedure();
	}

	public String getName() {
		return myDishName;
	}

	public int getNumberServed() {
		return myNumServed;
	}

	private int howManyServedByDish() {
		int numServed;
		Input take = new Input();
		/*
		 * Scanner reader = new Scanner(System.in);
		 * System.out.println("How many does this dish serve?"); numServed =
		 * reader.nextInt();
		 */

		numServed = take.getInt("How many does this dish serve?");
		return numServed;
	}

	private String nameDish() {
		String name;
		Input take = new Input();

		name = take.getString("What is the name of your dish?");

		return name;
	}

	private ArrayList<String> createProcedure() {
		String directions;
		int i = 1;
		boolean another = true;
		ArrayList<String> procedure = new ArrayList<String>();

		Input take = new Input();
		// Scanner reader = new Scanner(System.in);
		take.showInformation("Here, I ask that you describe the steps for making your dish.");
		while (another) {
			// System.out.println("Please describe Step " + i + ".");
			directions = take.getString("Please describe Step " + i + ".");

			procedure.add(directions);
			i++;
			another = another();
		}
		return procedure;
	}

	public void choices() {
		Input take = new Input();
		int response = take.shoppingOrProcedure();

		if (response == 0) {
			procedure();
		} else {
			shoppingList();
		}
	}

	public boolean shoppingList() {
		int numSteps = myIngredients.size();
		ArrayList<String> listofstrings = new ArrayList<String>();
		double howMuchOf;
		String title, name, units;
		title = ("Ingredients for " + myDishName + ":");
		Output give = new Output();
		for (int i = 0; i < numSteps; i++) {
			String message;
			Ingredient thyme = myIngredients.get(i);

			int scaler = (int) (((double) (RESTRAINT) / (double) (myNumServed)) + .99);

			howMuchOf = (thyme.amountPerServing() * scaler);
			name = thyme.nameOfIngredient();
			units = thyme.measuredIn();
			message = (howMuchOf + " " + units + " of " + name);

			listofstrings.add(message);
		}
		
		give.printStringArray(listofstrings, title);
		return true;
	}
	
	public boolean procedure() {
		Output give = new Output();
		String message = "";
		for (int i = 0; i < mySteps.size(); i++) {
			message = message + ("Step " + (i + 1) + ": " + mySteps.get(i) + "\n");
		}
		give.printProcedure(myDishName, message);
		return true;
	}

	private ArrayList<Ingredient> addIngredients() {
		// variables I need
		double howMuchPerServing;
		String nameOfIngredient, howItsMeasured;
		boolean another;
		Input take = new Input();

		ArrayList<Ingredient> procedure = new ArrayList<Ingredient>();

		// Get user input
			nameOfIngredient = take
					.getString("What is the name of your first ingredient?");

			howItsMeasured = take.getString("What do you measure in?");

			howMuchPerServing = take.getDouble("How many " + howItsMeasured
					+ " do you need per serving?");

			Ingredient food = new Ingredient(nameOfIngredient,
					howMuchPerServing, howItsMeasured);
			procedure.add(food);

			another = another();
			while (another) {
				nameOfIngredient = take
						.getString("What is the name of your ingredient?");

				howItsMeasured = take.getString("What do you measure in?");

				howMuchPerServing = take.getDouble("How many " + howItsMeasured
						+ " do you need?");

				Ingredient moreFood = new Ingredient(nameOfIngredient,
						howMuchPerServing, howItsMeasured);
				procedure.add(moreFood);
				another = another();
		}
		return procedure;
	}

	private boolean another() {
		Input take = new Input();
		boolean isYes = take.getBoolean("Another?");
		return isYes;
	}
}
