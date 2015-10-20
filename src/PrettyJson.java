import java.util.*;
public class PrettyJson {
	public static void main(String[] args) {
		new PrettyJson().prettyJSON("{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}");
	}
	public ArrayList<String> prettyJSON(String a) {
		ArrayList<String> result = new ArrayList<>();
		JSON j = create(a);
		return null;
	}
	public void printJSON(JSON json) {
		List<JSONObject> allj = json.getAll();
		for (int i=0;i<allj.size();i++) {
			JSONObject jo = allj.get(i);
			System.out.println(jo.getKey());
			if (jo.isObj) {
				printJSON(jo.getJV());
			}
		}
	}
	private int counter = 0;
	public JSON create(String a) {
		JSON result = new JSON();
		while (counter < a.length()) {
			JSONObject object = new JSONObject();
			counter++;
			String key = getKey(a, ':');
			object.setKey(key);
			char c = a.charAt(counter);
			if (c == '\"') {
				counter++;
				object.setSV(getKey(a, '\"'));
			}
			else if (c == '[') {
				counter++;
				object.setValue(getArray(a));
			}
			else
			{
				object.setJV(create(a));
				object.obj(true);
			}
			result.add(object);
			if (c == '}') {
				counter++;
				break;
			}
		}
		return result;
	}
	public List<String> getArray(String a) {
		List<String> result = new ArrayList<String>();
		while (true) {
			char c = a.charAt(counter);
			if (c == ']')
				break;
			counter ++;
			result.add(getKey(a, '\"'));
			if (c != ',')
				break;
		}
		counter++;
		return result;
	}

	public String getKey(String a, char delimiter) {
		StringBuilder sb = new StringBuilder("");
		int j = 0;
		for(j =counter;j<a.length();j++) {
			char c = a.charAt(j);
			if (c == delimiter)
				break;
			sb.append(c+"");
		}
		counter = j+1;
		return sb.toString();
	}

	static class Inte{
		int a;
		public Inte(int a) {
			this.a = a;
		}
		public int getA()
		{
			return a;
		}
		public void setA(int a) {
			this.a  = a;
		}
	}

	static class JSON {
		List<JSONObject> objects = new ArrayList<>();
		public void add(JSONObject o) {
			objects.add(o);
		}
		public List<JSONObject> getAll() {
			return objects;
		}
	}

	static class JSONObject {
		String key;
		String sv;
		List<String> value;
		JSON jvalue;
		boolean isObj;

		public boolean isObj()
		{
			return this.isObj;
		}
		public void obj(boolean b) {
			this.isObj = b;
		}

		public void setJV(JSON jv) {
			this.jvalue = jv;
		}
		public void setValue(List<String> v) {
			this.value = v;
		}
		public void setSV(String v) {
			this.sv = v;
		}
		public void setKey(String v) {
			this.key = v;
		}

		public List<String> getValue(){
			return this.value;
		}	
		public String getKey(){
			return this.key;
		}
		public String getSV(){
			return this.sv;
		}	
		public JSON getJV(){
			return this.jvalue;
		}	
	}
}