package chapter3;

import java.util.*;

import static lib.TextElements.*;

public class ReviewQuestions {

	public static void main(String[] args) {
		
		{
			Comparator<String> c = (s1, s2)->s2.toLowerCase().compareTo(s1.toLowerCase());
			String[] values = {"123", "Abb", "aab" };
			Arrays.sort(values,c);
			
			for (String s : values) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
		
		separe();
		
		{
			List list = new ArrayList();
			list.add("aa");
			list.add("bb");
			list.add(7);
			
			try {
				
				for (int i = 0; i < list.size(); i++) {
					System.out.print((String) list.get(i));
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			System.out.println();
		}
		
		separe();
		
		{
			TreeSet<String> tree = new TreeSet<>();
			tree.add("one");
			tree.add("One");
			tree.add("ONE");
			System.out.println(tree.ceiling("On"));
			
		}
		
		separe();
		
		{
			Map<Integer, Integer> map = new HashMap<>(10);
			
			for(int i = 1; i <= 10; i++) {
				map.put(i, i*i);
			}
			
			System.out.println(map.get(4));
		}
		
		separe();
		
		{
			Comparator<String> c = (s1, s2)->s2.compareTo(s1);
			TreeSet<String> t1 = new TreeSet<>();
			TreeSet<String> t2 = new TreeSet<>(c);		//Implements a Comparator
			
			t1.add("a");
			t1.add("b");
			
			t2.add("a");
			t2.add("b");
			
			System.out.println(t1+ " " + t2);
		}
		
		separe();
		
		{
			Queue<Integer> q = new LinkedList<>();
			q.add(10);
			q.add(12);
			q.remove(1);
			System.out.println(q);
		}
	}

}
