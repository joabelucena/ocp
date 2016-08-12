package chapter3.bounds;

import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;

/**
 * 
 * Bounded wildcards are specifications for receveing generic parameters. Its syntax is:
 * 
 * <? condition Type>
 * 
 * An easy way to remember is reading as:
 * 
 * ? 			- Any Class that
 * condition	- condition
 * Type			- of Type is acceptable
 * 
 * Lower-bounded wildcard eg: <? super Object> 
 * 
 * @author root
 *
 */
public class LowerBounded {

	public static void main(String[] args) {
		
		{
			List<String> strings = new ArrayList<>();
			strings.add("tweet");
			
			List<Object> objects = new ArrayList<>(strings);
			System.out.println(strings);
			
			addSound(objects);
			addSound(strings);
			
			
			System.out.println(strings);
			
		}
		
		{
			/*
			 * Here we're saying that this reference (exceptions) can hold anything from 
			 * IOException to Object.
			 * 
			 * But we have not sure what is gonna be held until runtime so, the lower class we can
			 * safely say that can be held is IOExcpetion so, we are able to add any IOException in
			 * this list and, by saying "any IOExcetpion" we're saying any "instanceof IOException" 
			 * or in other words, anything that "is-a" IOException.
			 * 
			 */
			List<? super IOException> exceptions = new ArrayList<>();
			
			exceptions.add(new IOException());
			exceptions.add(new FileNotFoundException());
			
			/*
			 * DOES NOT COMPILE
			 */
			exceptions.add(new Exception());
		}

	}
	
	
	public static void addSound(List<? super String> list) {
		list.add("quack");
	}

}
