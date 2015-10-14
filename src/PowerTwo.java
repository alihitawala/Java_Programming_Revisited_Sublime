public class PowerTwo {
	public static void main(String[] args) {
		System.out.println(new PowerTwo().power(args[0]));
	}

	public int power(String a) {
		if (a ==null || a.length() == 0 || a.charAt(0) == '-')
			return 0;
		while (a.length() != 0 && a.charAt(0) == '0') {
			a=a.substring(1);
		}
		if (a.length() == 0)
			return 0;
		if (a.length() == 1 && (a.charAt(0) == '1' || a.charAt(0) == '0'))
			return 0;
		while (a.length() != 1 || a.charAt(0) != '1') {
			try {
				a = half(a);
				System.out.println(a);
			}
			catch(Exception r) {
				return 0;
			}
		}
		return 1;
	}

	private static String half(String a) {
		StringBuilder result = new StringBuilder("");
		int num = 0;
		for (int i=0;i<a.length();i++) {
			int c = a.charAt(i) - '0';
			if (num != 0) {
				num *=10 + c;
				result.append(String.valueOf(num/2));
				if (num % 2 != 0)
					num = 1;
				else 
					num =0;
			}
			else {
				if (c == 0)
					result.append("0");
				else if (c == 1) {
					if (num == 0 && result.length() > 0)
						result.append("0");
					num = 1;
				}
				else {
					num = c%2 == 0 ? 0:1;
					result.append(String.valueOf(c/2));
				}
			}
		}
		if (num != 0)
			throw new RuntimeException("Not exactly divisible by 2!!");
		return result.toString();
	}
}