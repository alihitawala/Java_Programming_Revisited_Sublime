import java.util.*;

public class RemoveElement {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> a = new ArrayList<Integer>();
		int c = in.nextInt();
		for (int i=0;i<c;i++)
		{
			a.add(in.nextInt());
		}
		int d = in.nextInt();
		System.out.println(new RemoveElement().removeElement2(a,d));

		for (int i=0;i<a.size();i++)
		{
			System.out.print(" "+a.get(i));
			System.out.println();
		}
	}

	public int removeElement(ArrayList<Integer> a, int b) {
		int i=0,j=0;
		ArrayList<Integer> container = new ArrayList<Integer>();
		for (;i<a.size();i++)
		{
			if (a.get(i) != b) {
				container.add(a.get(i));
			}
		}
		a.clear();
		for (i=0;i<container.size();i++)
		{
			a.add(container.get(i));
		}
		return container.size();
	}

	public int removeElement2(ArrayList<Integer> a, int b) {
		int j=0;
		for (int i=0;i<a.size();i++) {
			if (a.get(i) == b) {
				j++;
				continue;
			}
			a.set(i-j, a.get(i));
		}
		for (int i=0;i<j;i++)
			a.remove(a.size()-1);
		return a.size();
	}

	public void swap(ArrayList<Integer> a, int i, int j) {
		int temp = a.get(i);
		a.set(i, a.get(j));
		a.set(j, temp);
	}
}