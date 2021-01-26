package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.swing.JPanel;

import org.junit.jupiter.api.Test;

import game.Chess;
import game.Chessboard;

class ChessTest extends Chess implements Chessboard
{

	@Test
	void testSetJPane() {
		Chess c = new Chess();
		c.setJPane(f);
		assertSame(g, f.getGraphics());
	}
	
	@Test
	void testDrawPiece() {
		Chess c = new Chess();
		int test = c.drawPiece(8, 8);
		assertEquals(1, test);
	}
	
	@Test
	void testGetWeight() throws IOException {		
		Chess c = new Chess();
		int [][] array = c.getWeight();
		if(array==null||array.length==0||(array.length==1&&array[0].length==0)) 
		{
			fail("getWeight() didn't work");
		}
	}
	
	@Test
	void testMaxWeight() throws IOException {		
		Chess c = new Chess();
		int [] array = c.maxWeight(c.getWeight());
		if(array==null||array.length==0) 
		{
			fail("maxWeight() didn't work");
		}
	}
	
	@Test
	void testWin() {
		Chess c = new Chess();
		assertEquals(0, c.win());
	}

}
