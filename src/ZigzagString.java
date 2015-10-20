public class ZigzagString {
	public static void main(String[] args) {
		System.out.println(new ZigzagString().convert("PAYPALISHIRING", 3));
	}

	public String convert(String a, int b) {
		int temp = b;
		if (b == 1 || a == null || a.length() == 0|| a.length() == 1)
			return a;
		int k = temp*2 - 2;
		StringBuilder sb = new StringBuilder("");
		int l = k;
		int extent = 2;
		for(int i=0; i<b;i++) {
			for(int j=i;j<a.length();) {
				sb.append(a.charAt(j) + "");
				if (l==k || l == 0)
					l=k;
				else
					l = k - l;
				j += l;
			}
			l = k - extent;
			extent += 2;
		}
		return sb.toString();
	}
}