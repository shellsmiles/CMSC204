/**
 * Password doesn’t contain a numeric character 
 * @author YL
 */
public class NoDigitException extends Exception{

	public NoDigitException () {
		super("The password must contain at least one digit");
	}

}
