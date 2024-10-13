
import java.util.HashMap;
import java.util.Set;
import java.util.Map;
public class Main
{
	public static void main(String[] args) {
		HashMap<Integer,String> map = new HashMap<>();
		map.put(1,"Apple");
		map.put(2,"Orange");
		map.put(3, "Grape");
		
// 		String value = map.get(2);
// 		System.out.println(value);
		
		System.out.println(map.containsValue("Apple"));
		
// 		Set<Integer> keySet = map.keySet();
// 		System.out.println("keys in the hashmap");
// 		for(Integer key : keySet){
// 		    System.out.println("key: " + key + ", Value: " + map.get(key));
// 		}
		
// 		map.remove(1);
// 		System.out.println(map);

    Set<Map.Entry<Integer,String>> entrySet = map.entrySet();
		
		for(Map.Entry<Integer, String> e : entrySet){
		    Integer key = e.getKey();
		    String value = e.getValue();
		    System.out.println(key + " " +value);
		}
	}
}
