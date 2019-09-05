package chapter4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;

public class HastSetAndTree {

	public static class Node {
		public int value;
		public Node next;

		public Node(int val) {
			value = val;
		}
	}
	
	public static void main(String[] args) {
		HashSet<Integer> hashSet1 = new HashSet<>();
		hashSet1.add(3);
		System.out.println(hashSet1.contains(3));
		hashSet1.remove(3);
		System.out.println(hashSet1.contains(3));
		System.out.println("-------1---------");
		
		HashSet<Node> hashSet2 = new HashSet<>();
		Node nodeA = new Node(1);
		Node nodeB = new Node(1);
		
		hashSet2.add(nodeA);
		System.out.println(hashSet2.contains(nodeA));
		System.out.println(hashSet2.contains(nodeB));
		hashSet2.add(nodeB);
		System.out.println(hashSet2.contains(nodeA));
		System.out.println(hashSet2.contains(nodeB));
		System.out.println("-------2-------");
		
		HashMap<String, Integer> hashMap1 = new HashMap<>();
		String str1 = new String("key");
		String str2 = new String("key");
		
		hashMap1.put(str1, 1);
		System.out.println(hashMap1.containsKey(str1));
		System.out.println(hashMap1.containsKey(str2));
		System.out.println(hashMap1.get(str2));
		System.out.println("----------3-----------");
		
		HashMap<String, Integer> hashMap2 = new HashMap<>();
		hashMap2.put("a", 1);
		hashMap2.put("b", 2);
		hashMap2.put("c", 3);
		hashMap2.put("d", 1);
		
		List<String> removeKeys = new ArrayList<>();
		
		for(Entry<String, Integer> entry: hashMap2.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			if (value.equals(1)) {
				removeKeys.add(key);
			}
		}
		
		for(String key: removeKeys) {
			hashMap2.remove(key);
		}
		
		for(Entry<String, Integer> entry: hashMap2.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("key="+key+",value="+value);
		}
		
	}

}
