public class Ingredient {
	private String myName; 
	private double myAmountPerServing;
	private String myMeasuredIn;
	public Ingredient(String name, double amountPerServing, String measuredIn){
		myName = name; 
		myAmountPerServing = amountPerServing;
		myMeasuredIn = measuredIn;//the units of measurement
	}
	
	public double amountPerServing(){
		return myAmountPerServing;
	}
	
	public String nameOfIngredient(){
		return myName;
	}
	
	public String measuredIn(){
		return myMeasuredIn;
	}
}
