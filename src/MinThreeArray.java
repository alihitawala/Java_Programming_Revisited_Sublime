import java.util.*;

public class MinThreeArray {
	public int minimize(final List<Integer> a, final List<Integer> b, final List<Integer> c) {
		int i=0,j=0,k=0;
		int minResult = Integer.MAX_VALUE;
		while (i != a.size()-1 && j!=b.size()-1 || k!=c.size()-1) {
			int p = a.get(i), q = b.get(j), r = c.get(k);
			int temp = Math.min(Math.min(Math.abs(p-q), Math.abs(q-r)), Math.abs(r-p));
			if (minResult > temp)
				minResult = temp;
			if (p <= q && p <= r && i != a.size()-1)
				i++;
			else if (q <= r && j != b.size()-1)
				j++;
			else if (k != c.size()-1)
				k++;
			else if (q >= r && q <= p && j != b.size()-1)
				j++;
			else if (i != a.size()-1)
				i++;
		}
		int p = a.get(i), q = b.get(j), r = c.get(k);
		int temp = Math.min(Math.min(Math.abs(p-q), Math.abs(q-r)), Math.abs(r-p));
		if (minResult > temp)
			minResult = temp;
		return minResult;
	}
}