package checkCoupon_Challenge;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class CheckCoupon_main {

	public static void main(String[] args) {
		// Should give true
		System.out.println(checkCoupon("123", "123", "July 9, 2015", "July 9, 2015"));
		// Should give false
		System.out.println(checkCoupon("123", "123", "July 9, 2015", "July 2, 2015"));
		// Should give false
		System.out.println(checkCoupon("527", "325", "July 9, 2015", "July 10, 2015"));
	}

	public static boolean checkCoupon(String enteredCode, String correctCode, String currentDate, String expirationDate){
		   
		boolean isValid = false;
		
		if (enteredCode.equalsIgnoreCase(correctCode)) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
			LocalDate curDate = LocalDate.parse(currentDate, formatter);
			LocalDate expDate = LocalDate.parse(expirationDate, formatter);
			
			if (!expDate.isBefore(curDate)) {
				isValid = true;
			}
		}
		
		return isValid;
	}
}
