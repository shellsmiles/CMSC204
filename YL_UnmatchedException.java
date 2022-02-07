/**
 * Check if Password and re-typed Password are identical
 * @author YL
 *
 */
public class UnmatchedException extends Exception{

	public UnmatchedException () {
		super("Passwords do not match");
	}

}