package bitwise;

public class FlipBitsToMatch
{
	public static void main(String[] args)
	{
		int a = 29;
		int b = 15;

		System.out.println(a + " in binary = " + Integer.toBinaryString(a));
		System.out.println(b + " in binary = " + Integer.toBinaryString(b));

		int numBitsToFlip = 0;

		for (int i = 0; i < 32; i++)
		{
			int bitA = a & 1 << i;
			int bitB = b & 1 << i;

			// System.out.println(bitA + " " + bitB);

			if (bitA != bitB)
			{
				numBitsToFlip++;
			}
		}
		System.out.println("numBitsToFlip: " + numBitsToFlip);
	}
}
