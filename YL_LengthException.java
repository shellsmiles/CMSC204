/**
 * Length of password is less than 6 characters
 * @author YL
 */
public class LengthException extends Exception{
	
	public LengthException () {
		super("The password must be at least 6 characters long");
	}
}

