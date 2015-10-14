public class RomanNumber {
	public static void main(String[] args) {
		RomanNumber r = new RomanNumber();
		System.out.println(r.romanNumberToInteger(args[0]));
	}

	public int romanNumberToInteger(String roman) {
		int answer = 0;
		for (int i=0;i<roman.length();i++) {
			char c = roman.charAt(i);
			if (i!=roman.length()-1) {
				char d = roman.charAt(i+1);
				if (priority(c,d) < 0) {
					answer+=valueOf(d) - valueOf(c);
					i++;
					continue;
				}
			}
			answer += valueOf(c);
		}
		return answer;
	}

	private int priority(char c, char d) {
		return valueOf(c) - valueOf(d);
	}

	private int valueOf (char c) {
		switch(c) {
			case 'I':
				return 1;
			case 'V':
				return 5;
			case 'X':
				return 10;
			case 'L':
				return 50;
			case 'C':
				return 100;
			case 'D':
				return 500;
			case 'M':
				return 1000;
			default:
				throw new RuntimeException("Symbol not supported!");
		}
	}
}