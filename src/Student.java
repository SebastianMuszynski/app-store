
public class Student extends Customer {
	private static final double APP_PERCENTAGE_DISCOUNT = 25;

	public Student(String name, String address, String profession) {
		super(name, address, profession);
	}
	
	public double getAppPercentageDiscount() {
		return APP_PERCENTAGE_DISCOUNT;
	}

}
