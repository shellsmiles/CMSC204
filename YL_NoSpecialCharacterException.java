/**
 * password doesn’t contain a special character
 * @author YL
 *
 */
public class NoSpecialCharacterException extends Exception{

	public NoSpecialCharacterException () {
		super("The password must contain at least one special character");
	}

}