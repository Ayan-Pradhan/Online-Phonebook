package service;

import java.util.Random;

public class GenerateOTP {
	public static int generate() {
		Random r = new Random(System.currentTimeMillis());
        return ((1 + r.nextInt(5)) * 100000 + r.nextInt(100000));
	}
	
}
