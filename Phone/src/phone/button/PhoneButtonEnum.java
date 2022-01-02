package phone.button;

public enum PhoneButtonEnum {
	
	ZERO(0),
	ONE(1), 
	TWO(2),
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6),
	SEVEN(7),
	EIGHT(8),
	NINE(9),
	INIT(10),
	ASTERISK("*"),
	CROSSHATCH("#")
	;

	private final int number;
	private final String specialChar;
	
	PhoneButtonEnum(int number) {
		this.number = number;
		this.specialChar = "";
	} 
	
	PhoneButtonEnum(String specialChar) {
		this.number = 10;
		this.specialChar = specialChar;
	}	

	public int getNumber() {
		return number;
	}


	public String getSpecialChar() {
		return specialChar;
	}
}
