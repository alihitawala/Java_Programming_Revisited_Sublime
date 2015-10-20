import java.util.*;

public class Building {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> a = new ArrayList<Integer>();
		int c = in.nextInt();
		for (int i=0;i<c;i++)
		{
			a.add(in.nextInt());
		}
		System.out.println(new Building().maxArea2(a));
	}
	public int maxArea(ArrayList<Integer> a) {
		int max = 0;
		for (int i=0;i<a.size();i++) {
			for(int j=i;j<a.size();j++) {
				int x = a.get(i);
				int y = a.get(j);
				int tmax = Math.min(x,y);
				if (max < tmax*(j-i))
					max = tmax*(j-i);
			}
		}
		return max;
	}
	public int maxArea2(ArrayList<Integer> a) {
		int max = 0;
		for (int i=0, j=a.size()-1;i<j;) {
			int area = (j-i) * Math.min(a.get(i), a.get(j));
			if (a.get(i) < a.get(j))
				i++;
			else
				j--;
			if (area > max)
				max = area;
		}
		return max;
	}
}