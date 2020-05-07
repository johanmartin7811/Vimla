package common;

import java.util.Random;

public class userNameCreator {

	public String createRandomUserName() {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100000);
		String username1 = "johanmartin"+ randomInt ;
		return username1;

		
	}

}
