import java.util.*;

public class UrlShortner {
	public static void main(String[] args) {
		UrlShortner us = new UrlShortner();
		System.out.println(us.encode(123));
		System.out.println(us.decode(us.encode(123)));
	}

	private static final String MAP = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final int BASE = MAP.length();

	public int decode(String coded) {
		if (coded == null)
			throw new RuntimeException();
		int result = 0;
		for (int i=0;i<coded.length();i++) {
			result = result*BASE + MAP.indexOf(coded.charAt(i));
		}
		return result;
	}

	public String encode(int a) {
		if (a < 0)
			throw new RuntimeException();
		StringBuilder sb = new StringBuilder("");
		while (a > 0) {
			sb.append(MAP.charAt(a % BASE));
			a = a/BASE;
		}
		return sb.reverse().toString();
	}
}