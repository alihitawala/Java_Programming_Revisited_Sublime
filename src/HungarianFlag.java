public class HungarianFlag {
	public static void main(String[] args) {
		int[] input = {0,0,0,0,-1,-2};
		new HungarianFlag().hungaryFlag(input);
		for (int i : input) {
			System.out.println(i);	
		}
	}

	public void hungaryFlag (int[] a) {
		int n = 0, p = a.length-1;
		for (int i=0; i <=p; ) {
			if (a[i] < 0) {
				swap(a, i, n);
				n++;
				i++;
			}
			else if (a[i] > 0) {
				swap(a, i, p);
				p--;
			}
			else
				i++;
		}
	}

	private static void swap(int[] a, int i, int j) {
		int term = a[i];
		a[i] = a[j];
		a[j] = term;
	}
}