package common;

import java.util.Random;

public class mailCreator {

	public String createMail() {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(10000000);
		String mail1 = "johanmartin"+ randomInt +"@mailinator.com";
		return mail1;

		
	}
	
	

}
