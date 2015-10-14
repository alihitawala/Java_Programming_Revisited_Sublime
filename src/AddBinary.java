public class AddBinary{
	public static void main(String[] args) {
		System.out.println(new AddBinary().addBinary(args[0], args[1]));
	}


	public String addBinary(String a, String b) {
		if (a ==null || a.length() == 0)
			return b;
		if (b ==null || b.length() == 0)
			return a;
		while (a.length() != 0 && a.charAt(0) == '0')
			a = a.substring(1);
		while (b.length() != 0 && b.charAt(0) == '0')
			b = b.substring(1);
		if (a ==null || a.length() == 0)
			return b;
		if (b ==null || b.length() == 0)
			return a;
		return addStrings(a, b);
	}

	private static String addStrings(String a, String b) {
		StringBuilder sb = new StringBuilder("");
		int i = a.length()-1, j = b.length()-1;
		int carry = 0;
		while (i >= 0 ||  j >=0 || carry) {
			int sum = carry;
			if (i>=0)
				sum += a.charAt(i--) - '0';
			if (j>=0)
				sum += b.charAt(j--) - '0';
			sb.append(String.valueOf(sum%2));
			carry = sum/2;
		}
		return sb.reverse().toString();
	}
}