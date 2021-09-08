import java.util.Arrays;

public class ArrayReverse 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] originalArray = new int[5];
		originalArray[0] = (int)(Math.random() * 100);
		originalArray[1] = (int)(Math.random() * 100);
		originalArray[2] = (int)(Math.random() * 100);
		originalArray[3] = (int)(Math.random() * 100);
		originalArray[4] = (int)(Math.random() * 100);
		
		int[] temporaryArray = new int[5];
		for(int i = 0; i < originalArray.length; i++)
		{
			temporaryArray[i] = originalArray[i];
		}
		
		System.out.println(Arrays.toString(originalArray));
		
		
		for(int i = temporaryArray.length - 1; i >= 0; i--)
		{
			originalArray[temporaryArray.length - 1 - i] = temporaryArray[i];
		}
		
		System.out.println(Arrays.toString(originalArray));

	}

}
