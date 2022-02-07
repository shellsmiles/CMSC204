/**
 * Description: This program checks the PassWord valid or not.
 * CMSC204 
 * Author: YanaL
 */

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;


/**
 * class for password checking
 */
public class PasswordCheckerUtility 
{
	/**
	 * default constructor
	 */
	public PasswordCheckerUtility () 
	{
	}
	
	/**
	 * Compare equality of two passwords
	 * @param password
	 * @param passwordConfirm
	 * @throws UnmatchedException
	 */
	public static void comparePasswords​(String password, 
							String passwordConfirm) throws UnmatchedException
	{
		if ( !password.equals(passwordConfirm))
			throw new UnmatchedException(); 
	}
	
	/**
	 * Compare equality of two passwords
	 * @param password
	 * @param passwordConfirm
	 * @return true if the two passwords are the same
	 */
	public static boolean comparePasswordsWithReturn​(String password,
													 String passwordConfirm )
	{
		boolean result= false;
		if ( password.equals(passwordConfirm))
			result= true;
			
		return result;
	}
	
	/**
	 * Checks the password length requirement - The password must be at least 6 characters long
	 * @param password
	 * @return true if the length of the password is over 6
	 * @throws LengthException
	 */
	public static boolean isValidLength​(String password) 
								throws LengthException
	{
		if ( password.length() < 6)
			throw new LengthException();
		
		else
			return true;
	}
	
	/**
	 * Checks the password alpha character requirement 
	 * - Password must contain an uppercase alpha character
	 * @param password
	 * @return true if the password has at least one uppercase alpha
	 * @throws NoUpperAlphaException
	 */
	public static boolean hasUpperAlpha​(String password) 
										throws NoUpperAlphaException
	{
		int count=0;
		char each;
		for( int i=0; i< password.length(); i++)
		{
			each= password.charAt(i);
			if ( each >=65 && each <=90 )
				count++;
		}
		
		if (count>0)
			return true;
		else
			throw new NoUpperAlphaException();
	}

	/**
	 * Checks the password lowercase requirement 
	 * - Password must contain at least one lowercase alpha character
	 * @param password
	 * @return true if the password has at least one uppercase alpha
	 * @throws NoLowerAlphaException
	 */
	public static boolean hasLowerAlpha​(String password) 
			throws NoLowerAlphaException
	{
		int count=0;
		char each;
		for( int i=0; i< password.length(); i++)
		{
			each= password.charAt(i);
			if ( each >=97 && each <=122 )
				count++;
		}
		
		if (count<=0)
			throw new NoLowerAlphaException();
		else
			return true;
	
	}
	
	/**
	 * Checks the password Digit requirement 
	 * - Password must contain a numeric character
	 * @param password
	 * @return true if the password has at least one digit
	 * @throws NoDigitException
	 */
	public static boolean hasDigit​(String password) 
								throws NoDigitException
	{
		int count=0;
		char each;
		for( int i=0; i< password.length(); i++)
		{
			each= password.charAt(i);
			if ( each >=48 && each <=57 )
				count++;
		}
		
		if (count>0)
			return true;
		else
			throw new NoDigitException();
		
	}
	
	/**
	 * Checks the password SpecialCharacter requirement 
	 * - Password must contain a Special Character
	 * @param password
	 * @return true if the password has at least one special character
	 * @throws NoSpecialCharacterException
	 */
	public static boolean hasSpecialChar​(String password) 
			                  throws NoSpecialCharacterException
	{	
		/*
		int count=0;
		char each;
		for( int i=0; i< password.length(); i++)
		{
			each= password.charAt(i);
			if ( ( each >=32 && each <=47 )|| ( each >=58 && each <=64 )
					|| ( each >=91 && each <=96 ) || ( each >=123 && each <=126 ))
			{	
				count++;
			}
		}
	
		if (count>0)
			return true;
		else
			throw new NoSpecialCharacterException();
		*/
		
		// regular expression
		Pattern pattern = Pattern.compile("[^a-zA-Z0-9_]");
		Matcher matcher = pattern.matcher(password);
		
		if (matcher.find())return true;
		else 
			throw new NoSpecialCharacterException();
	}
	
	/**
	 * Checks the password Sequence requirement 
	 * - Password should not contain more than 2 of the same character in sequence
	 * @param password
	 * @return true if the password has no more than 2 same characters in sequence 
	 * @throws InvalidSequenceException
	 */
	public static boolean noSameCharInSequence (String password) 
								throws InvalidSequenceException
	{
		
		for (int i=0; i< password.length(); i++)
		{
			if (i>= 2)
			{	
				if (password.charAt(i-1)== password.charAt(i)  &&  password.charAt(i-1)== password.charAt(i-2))
					throw new InvalidSequenceException();
			}
		}
		return true;
	}
	
	/**
	 * check if the password is valid
	 * @param password
	 * @return true if valid password (follows all the following rules), 
	 * 		   returns false if an invalid password.
	 * @throws LengthException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws NoDigitException
	 * @throws NoSpecialCharacterException
	 * @throws InvalidSequenceException
	 */
	public static boolean isValidPassword​(String password)  
			throws LengthException, NoUpperAlphaException, NoLowerAlphaException, 
			NoDigitException, NoSpecialCharacterException, InvalidSequenceException
	{
		
		if ( !PasswordCheckerUtility.isValidLength​(password) )
			throw new LengthException();
		
		else if ( !PasswordCheckerUtility.hasUpperAlpha​(password) )
			throw new NoUpperAlphaException();
		
		else if ( !PasswordCheckerUtility.hasLowerAlpha​(password) )
			throw new NoLowerAlphaException();
		
		else if ( !PasswordCheckerUtility.hasDigit​(password) )
			throw new NoDigitException();
		
		else if ( !PasswordCheckerUtility.hasSpecialChar​(password)) 
			throw new NoSpecialCharacterException();
			
		else if ( !PasswordCheckerUtility.noSameCharInSequence(password))
			throw new InvalidSequenceException();
		
		return true;
		
	}
	
	/**
	 * checks if the password contains 6 to 9 characters
	 * @param password
	 * @return true if the password contains 6 to 9 characters
	 */
	public static boolean hasBetweenSixAndNineChars​ (String password)
	{
		if (password.length()>=6 && password.length()<=9)
			return true;
		else
			return false;
	}
	
	/**
	 * Checks if password is VALID and the length is NOT between 6-9 characters
	 * @param password
	 * @return true if password is VALID and the length is NOT between 6-9 characters
	 * @throws WeakPasswordException
	 */
	public static boolean isWeakPassword​(String password) 
									throws WeakPasswordException
	{
		boolean result= true;
		
		if (PasswordCheckerUtility.hasBetweenSixAndNineChars​(password))
			throw new WeakPasswordException ();
		else
			result= false;
		return result;
	}
	
	/**
	 * This method will accept an ArrayList of passwords as the parameter and return an ArrayList  
	 * with the status of any invalid passwords (weak passwords are not considered invalid).
	 * @param passwords
	 * @return only invalid passwords and their status
	 */
	public static ArrayList<String> getInvalidPasswords​(ArrayList<String> passwords) 
	{
		boolean result;
		ArrayList<String> inValidPasswords = new ArrayList<>();
		
		for (int i=0; i< passwords.size(); i++)
		{
			try
			{
				result=PasswordCheckerUtility.isValidPassword​( passwords.get(i));
			}
			catch (LengthException| NoUpperAlphaException| NoLowerAlphaException|
									NoDigitException| NoSpecialCharacterException| InvalidSequenceException e)
			{
				inValidPasswords.add(passwords.get(i)+ " -> " +e.getMessage());
			}
			catch(Exception e)
			{
				inValidPasswords.add(passwords.get(i)+ " -> " +e.getMessage()); 
			}
		}
		return inValidPasswords;
	}

}


