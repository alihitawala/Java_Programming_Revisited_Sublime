import java.util.*;

public class StringClustering {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>(); 
		list.add("cab");
		list.add("cz");
		list.add("abc");
		list.add("bca");
		list.add("zc");
		ArrayList<ArrayList<String>> answer = new StringClustering().cluster(list);
		for(ArrayList<String> a : answer) {
			System.out.print("List :: ");	
			for(String s : a) {
				System.out.print(s + " ");		
			}
			System.out.println();	
		}
	}
	public ArrayList<ArrayList<String>> cluster(ArrayList<String> a) {
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		if (a == null || a.size() < 2) {
			result.add(a);
			return result;
		}
		Map<String, ArrayList<String>> map = new HashMap<>();
		for (String s : a) {
			String temp = sortString(s);
			if (map.containsKey(temp)) {
				map.get(temp).add(s);
			}
			else {
				ArrayList<String> list = new ArrayList<>();
				list.add(s);
				map.put(temp, list);
			}
		}
		Set<String> keys = map.keySet();
		for(String k : keys) {
			result.add(map.get(k));
		}
		return result;
	}

	private static String sortString(String s) {
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return String.valueOf(c);
	}
}