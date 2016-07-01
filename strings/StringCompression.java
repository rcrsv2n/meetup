package strings;

public class StringCompression
{
	public static void main (String [] args)
	{
		// default input
		String input = "BBBBBBBBBBBBNBBBBBBBBBBBBNNNBBBBBBBBBBBBBBBBBBBBBBBBNBBBBBBBBBBBBBB";

		// get input from command line
		if (args.length == 1)
		{
			input = args[0];
		}

		String compress = compress(input);

		System.out.println("   Input: [" + input + "]");
		System.out.println("compress: [" + compress + "]");
	}

	private static String compress (String input)
	{
		if (input == null)
		{
			return null;
		}

		// make sure the input has no numbers in it.
		// this will break the compression
		if (input.matches(".*\\d+.*"))
		{
			throw new IllegalArgumentException("Cannot use this compression if input contains digits.");
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0, len = input.length(); i < len; i++)
		{
			int start = i;
			char c = input.charAt(i);

			while (i + 1 < len && c == input.charAt(i + 1))
			{
				i++;
			}

			sb.append(c);

			int diff = i - start + 1;
			if (diff > 1)
			{
				sb.append(diff);
			}
		}

		String compress = sb.toString();

		// don't return the compressed string if we didn't gain anything
		return input.length() <= compress.length() ? input : compress;
	}
}
