import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

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