/**
 * Password doesn’t contain a lowercase alpha character
 * @author YL
 *
 */
public class NoLowerAlphaException extends Exception{

	public NoLowerAlphaException () {
		super("The password must contain at least one lowercase alphabetic character");
	}

}
