package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.Buttons;

class ButtonsTest extends Buttons
{

	@Test
	void testReset() {
		Buttons b = new Buttons();
		b.reset();
		assertEquals(1, testReset);
	}
	
	@Test
	void testButtons() {
		Buttons b = new Buttons();
		b.mousePressed(me);
		b.actionPerformed(ae);
		assertTrue(testButtons>0);
	}

}
