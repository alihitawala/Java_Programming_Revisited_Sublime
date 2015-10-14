public class MultiplyString {
	public static void main(String[] args) {
		String test = "00";
		String test2 = "99999";
		char c = '9';
		//System.out.println(multiplyOne(test, c));
		//System.out.println(sumTwoString(test, test2));
		MultiplyString m = new MultiplyString();
		System.out.println(m.multiply(test, test2));
	}

	public String multiply(String a, String b) {
		if (a == null || a.length() == 0)
			return b;
		if (b == null || b.length() == 0)
			return a;
		while (a.length() != 0 && a.charAt(0) == '0') {
			a = a.substring(1);
		}
		while (b.length() != 0 && b.charAt(0) == '0') {
			b = b.substring(1);
		}
		if (a.length() == 0 || b.length() == 0) {
			return "0";
		}
		int i=0,j=0;
		boolean negative = false;
		if (a.charAt(0) == '-')
		{
			i++;
			negative = !negative;
			a = a.substring(1);
		}
		if (b.charAt(0) == '-')
		{
			j++;
			negative = !negative;
			b = b.substring(1);
		}
		String result = "0";
		String tens = "0";
		for (int k=0; k<b.length();k++) {
			result = sumTwoString(result, multiplyOne(a, b.charAt(k)));
			// System.out.println(result);
			if (k != b.length()-1)
				result = result+tens;
		}
		return result;
	}

	private static String sumTwoString(String a, String b) {
		int p = a.length()-1;
		int q = b.length()-1;
		int carry = 0;
		StringBuilder sb = new StringBuilder("");
		while (p>=0 && q >= 0) {
			int x = a.charAt(p--) - '0';
			int y = b.charAt(q--) - '0';
			int temp = x + y + carry;
			sb.append(String.valueOf(temp%10));
			carry = temp/10;
		}
		while (p>=0) {
			int x = a.charAt(p--) - '0';
			int temp = x +carry;
			sb.append(String.valueOf(temp%10));
			carry = temp/10;
		}
		while (q>=0) {
			int x = b.charAt(q--) - '0';
			int temp = x+carry;
			sb.append(String.valueOf(temp%10));
			carry = temp/10;
		}
		while(carry != 0) {
			int temp =  carry%10;
			sb.append(String.valueOf(temp));
			carry = carry/10;
		}
		return sb.reverse().toString();
	}

	private static String multiplyOne(String s, char ch) {
		StringBuilder sb = new StringBuilder("");
		int p = s.length()-1;
		int carry = 0;
		while (p>=0) {
			int d = s.charAt(p--) - '0';
			int c = ch-'0';
			int temp = c*d + carry;
			sb.append(String.valueOf(temp%10));
			carry = temp/10;
			//System.out.println(temp);
		}
		while (carry != 0) {
			int temp =  carry%10;
			sb.append(String.valueOf(temp));
			carry = carry/10;
		}
		return sb.reverse().toString();
	}
}