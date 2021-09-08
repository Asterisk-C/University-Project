import java.util.Arrays;
/*
首先定义一个5X8的二维数组，然后使用随机数填充满
借助Arrays的方法对二维数组进行排序
参考思路：
先把二维数组使用System.arraycopy进行数组复制到一个一维数组
然后使用sort进行排序
最后再复制回到二维数组，并返回最大值的下标
 */
public class TwoDimensionalArray 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[][] twoDArray = new int[5][8];
		int max = 0;
		int x = 0;
		int y = 0;
		System.out.println("Original Array: ");
		for(int i = 0; i < 5; i++)
		{		
			for(int j = 0; j < 8; j++)
			{
				twoDArray[i][j] = (int) (Math.random() * 100);
				System.out.print(twoDArray[i][j] + " ");
				if(twoDArray[i][j] > max)
				{
					max = twoDArray[i][j];
					x = i;
					y = j;
				}
					
			}
			System.out.println();
		}
		System.out.println("Index of max: " + "[" + x + "]" + "[" + y + "]");
		
		
		int[] oneDArray = new int[5 * 8];
		//cope twoDA to oneDA
		for(int i = 0; i < twoDArray.length; i++)
		{
			System.arraycopy(twoDArray[i], 0, oneDArray, i * twoDArray[i].length, twoDArray[i].length);
		}
		//sort
		Arrays.sort(oneDArray);
		System.out.print(Arrays.toString(oneDArray));
		
		//cope oneDA to twoDA
		for(int i = 0; i < twoDArray.length; i++)
		{
			System.arraycopy(oneDArray, i * twoDArray[i].length, twoDArray[i], 0, twoDArray[i].length);
		}
		
		//print sorted twoDArray
		System.out.println();
		System.out.println("Sorted Array: ");
		for(int[] i : twoDArray)
		{
			System.out.println(Arrays.toString(i));
		}
		
	}

}
