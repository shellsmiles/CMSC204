/**
 * Password doesn’t contain an uppercase alpha character 
 * @author YL
 *
 */
public class NoUpperAlphaException extends Exception{

	public NoUpperAlphaException () {
		super("The password must contain at least one uppercase alphabetic character");
	}
}
