package decorator;

public class WithSideDish extends MainCourse {
	//private ArabFoods aFood;

	@Override
	public String sharwarma(String str) {	
		System.out.println("Normal chicken shawarma");
		System.out.println("spicy chicken shawarma");
		System.out.println("romaliyan chicken shawarma");
		System.out.println("macsican chicken shawarma");
		return str;
	}
	

	@Override
	public String gril(String describeGril) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String thandoori(String describeThandoori) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String manndhi(String describeManndhi) {
		// TODO Auto-generated method stub
		return null;
	}	
	
//public static void main(String[] args) {
//	WithSideDish ws= new WithSideDish()
//}
}
