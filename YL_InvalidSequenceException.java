/**
 * when password contains more than 2 of the same character in sequence Exception when the password has 2 more same character in sequence
 * @author YL
 *
 */
public class InvalidSequenceException extends Exception{

	public InvalidSequenceException () {
		super("The password cannot contain more than two of the same character in sequence");
	}

}