package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.CountScore;

class CountScoreTest {

	@Test
	void testCountL() {
		CountScore c = new CountScore();
		String s = c.countL(3, 3);
		if(s == null) 
		{
			fail("countL didn't work");
		}
	}
	
	@Test
	void testCountR() {
		CountScore c = new CountScore();
		String s = c.countR(3, 3);
		if(s == null) 
		{
			fail("countR didn't work");
		}
	}
	
	@Test
	void testCountU() {
		CountScore c = new CountScore();
		String s = c.countU(3, 3);
		if(s == null) 
		{
			fail("countU didn't work");
		}
	}
	
	@Test
	void testCountD() {
		CountScore c = new CountScore();
		String s = c.countD(3, 3);
		if(s == null) 
		{
			fail("countD didn't work");
		}
	}
	
	@Test
	void testCountLU() {
		CountScore c = new CountScore();
		String s = c.countLU(3, 3);
		if(s == null) 
		{
			fail("countLU didn't work");
		}
	}
	
	@Test
	void testCountLD() {
		CountScore c = new CountScore();
		String s = c.countLD(3, 3);
		if(s == null) 
		{
			fail("countLD didn't work");
		}
	}
	
	@Test
	void testCountRU() {
		CountScore c = new CountScore();
		String s = c.countRU(3, 3);
		if(s == null) 
		{
			fail("countRU didn't work");
		}
	}
	
	@Test
	void testCountRD() {
		CountScore c = new CountScore();
		String s = c.countRD(3, 3);
		if(s == null) 
		{
			fail("countRD didn't work");
		}
	}

}
