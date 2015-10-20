import java.util.*;

public class Merge {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		int c = in.nextInt();
		int d = in.nextInt();
		for (int i=0;i<c;i++)
		{
			a.add(in.nextInt());
		}
		for (int i=0;i<d;i++)
		{
			b.add(in.nextInt());
		}
		new Merge().merge(a,b);
		for(int i=0;i<a.size();i++) {
			System.out.print(" " + a.get(i));
		}
	}
	
	public void merge (ArrayList<Integer> a, ArrayList<Integer> b) {
		int in1= 0;
		int in2= 0;
		ArrayList<Integer> temp = new ArrayList<>(a);
		a.clear();
		int ptr = 0;
		while (in1 < temp.size() && in2 < b.size()) {
			if (temp.get(in1) < b.get(in2))
				a.add(temp.get(in1++));
			else
				a.add(b.get(in2++));
		}
		while (in1 < temp.size())
			a.add(temp.get(in1++));
		while (in2 < b.size())
			a.add(b.get(in2++));
	}
}