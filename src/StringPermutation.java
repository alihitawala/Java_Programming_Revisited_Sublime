import java.util.*;
public class StringPermutation {
	public static void main(String[] args) {
		System.out.println(new StringPermutation().allPermutation("abc"));
	}

	public ArrayList<String> allPermutation(String s) {
		ArrayList<String> result = new ArrayList<String>();
		_recursive(result,s, "");
		return result;
	}

	private void _recursive(ArrayList<String> result, String remaining,
	 String formed) {
		if (remaining.length() == 0)
		{
			result.add(formed);
			return;
		}
		for (int i=0;i<remaining.length();i++) {
			//abc acb bca
			String first = remaining.substring(0,i) ;
			String second = remaining.substring(i+1);
			_recursive(result, first+second, formed + remaining.charAt(i));
		}
	}
}