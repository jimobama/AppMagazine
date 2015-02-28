/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appmagazine;
import java.util.HashSet;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
/**
 *
 * @author 21187498
 */
public class Validator {
    
    
    static boolean isMatch(String pattern, String value)
    {
        boolean isokay=false;
       												// matched the give
															// value with
		Pattern p = Pattern.compile(pattern); // This method compile the pattern
												// to the understand of Java
		Matcher m = p.matcher(value.trim()); // this object create a matcher
												// that will match the value
												// give
		if (m.matches()) 
                {
                    isokay=true;
                }
		
        return isokay;
    }
    
    
    static int uniqueNumber()
    {
        Random rand = new Random();
        int n=   rand.nextInt(500);
        int n2=   rand.nextInt(500);
        int number = (rand.nextInt(n) % n2) + 500;
        return number;        
    }
}
