package decorator;

public class MainCourse implements ArabFoods {

//	private ArabFoods aFood;
//	public MainCourse(ArabFoods aFood) {
//		super();
//		this.aFood = aFood;
//	}

	@Override
	public String sharwarma(String describeSharwarma) {
		return "There are lot of verities in shawarma";
	}

	@Override
	public String gril(String describeGril) {
		return "With out mayo grill is not good";
	}

	@Override
	public String thandoori(String describeThandoori) {
		return "Veg thandoori more taseter than the non-veg";
	}

	@Override
	public String manndhi(String describeManndhi) {
		return "one single manndhi we can eat three to four members";
	}

}
