import java.util.Iterator;

public class Exercise8D{
	public static void main(String[] args){
		Dictionary d = new SortedArrayDictionary();

		System.out.println("TESTING: Sorted Array Dictionary");

		boolean[] r;
		int totalCorrect = 0;
		int totalCases = 4;

		// Test 1: Empty Dictionary
			r = results_array(4);
			test_S(r,0,d,0);
			test_IE(r,1,d,true);
			test_G_E(r,2,d,"a");
			test_G_E(r,3,d,"b");
			System.out.print("Test 1\t");
			totalCorrect += check(r);

		// Test 2: First Put / Remove
			Entry e1, e2;
			r = results_array(10);
			e1 = d.put("a","apple");
			test_S(r,0,d,1);
			test_IE(r,1,d,false);
			test_G(r,2,d,"a","apple");
			e2 = d.put("a","ant");
			test_S(r,3,d,2);
			Object[] choices1 = {"apple","ant"};
			test_G_M(r,4,d,"a",choices1);
			d.remove(e2);
			test_S(r,5,d,1);
			test_G(r,6,d,"a","apple");
			d.remove(e1);
			test_S(r,7,d,0);
			test_G_E(r,8,d,"a");
			test_IE(r,9,d,true);
			System.out.print("Test 2\t");
			totalCorrect += check(r);

		// Test 3: Put
			Entry e3, e4, e5, e6, e7, e8, e9;
			r = results_array(92);
			e5 = d.put("e","egg");
			test_S(r,0,d,1);
			test_G_E(r,1,d,"a");
			test_G_E(r,2,d,"b");
			test_G_E(r,3,d,"c");
			test_G_E(r,4,d,"d");
			test_G(r,5,d,"e","egg");
			test_G_E(r,6,d,"f");
			test_G_E(r,7,d,"g");
			test_G_E(r,8,d,"h");
			test_G_E(r,9,d,"i");
			e1 = d.put("a","ant");
			test_S(r,10,d,2);
			test_G_E(r,11,d,"i");
			test_G_E(r,12,d,"h");
			test_G_E(r,13,d,"g");
			test_G_E(r,14,d,"f");
			test_G(r,15,d,"e","egg");
			test_G_E(r,16,d,"d");
			test_G_E(r,17,d,"c");
			test_G_E(r,18,d,"b");
			test_G(r,19,d,"a","ant");
			e9 = d.put("i","ink");
			test_S(r,20,d,3);
			test_G(r,21,d,"a","ant");
			test_G_E(r,22,d,"b");
			test_G_E(r,23,d,"c");
			test_G_E(r,24,d,"d");
			test_G(r,25,d,"e","egg");
			test_G_E(r,26,d,"f");
			test_G_E(r,27,d,"g");
			test_G_E(r,28,d,"h");
			test_G(r,29,d,"i","ink");
			e7 = d.put("g","girl");
			test_S(r,30,d,4);
			test_G(r,31,d,"i","ink");
			test_G_E(r,32,d,"h");
			test_G(r,33,d,"g","girl");
			test_G_E(r,34,d,"f");
			test_G(r,35,d,"e","egg");
			test_G_E(r,36,d,"d");
			test_G_E(r,37,d,"c");
			test_G_E(r,38,d,"b");
			test_G(r,39,d,"a","ant");
			e3 = d.put("c","cat");
			test_S(r,40,d,5);
			test_G(r,41,d,"a","ant");
			test_G_E(r,42,d,"b");
			test_G(r,43,d,"c","cat");
			test_G_E(r,44,d,"d");
			test_G(r,45,d,"e","egg");
			test_G_E(r,46,d,"f");
			test_G(r,47,d,"g","girl");
			test_G_E(r,48,d,"h");
			test_G(r,49,d,"i","ink");
			e2 = d.put("b","boy");
			test_S(r,50,d,6);
			test_G(r,51,d,"i","ink");
			test_G_E(r,52,d,"h");
			test_G(r,53,d,"g","girl");
			test_G_E(r,54,d,"f");
			test_G(r,55,d,"e","egg");
			test_G_E(r,56,d,"d");
			test_G(r,57,d,"c","cat");
			test_G(r,58,d,"b","boy");
			test_G(r,59,d,"a","ant");
			e8 = d.put("h","hat");
			test_S(r,60,d,7);
			test_G(r,61,d,"a","ant");
			test_G(r,62,d,"b","boy");
			test_G(r,63,d,"c","cat");
			test_G_E(r,64,d,"d");
			test_G(r,65,d,"e","egg");
			test_G_E(r,66,d,"f");
			test_G(r,67,d,"g","girl");
			test_G(r,68,d,"h","hat");
			test_G(r,69,d,"i","ink");
			e6 = d.put("f","fan");
			test_S(r,70,d,8);
			test_G(r,71,d,"i","ink");
			test_G(r,72,d,"h","hat");
			test_G(r,73,d,"g","girl");
			test_G(r,74,d,"f","fan");
			test_G(r,75,d,"e","egg");
			test_G_E(r,76,d,"d");
			test_G(r,77,d,"c","cat");
			test_G(r,78,d,"b","boy");
			test_G(r,79,d,"a","ant");
			e4 = d.put("d","dog");
			test_S(r,80,d,9);
			test_G_E(r,81,d,"x");
			test_G(r,82,d,"a","ant");
			test_G(r,83,d,"b","boy");
			test_G(r,84,d,"c","cat");
			test_G(r,85,d,"d","dog");
			test_G(r,86,d,"e","egg");
			test_G(r,87,d,"f","fan");
			test_G(r,88,d,"g","girl");
			test_G(r,89,d,"h","hat");
			test_G(r,90,d,"i","ink");
			test_G_E(r,91,d,"z");
			System.out.print("Test 3\t");
			totalCorrect += check(r);

		// Test 4: Remove
			r = results_array(90);
			d.remove(e5);
			test_S(r,0,d,8);
			test_G(r,1,d,"a","ant");
			test_G(r,2,d,"b","boy");
			test_G(r,3,d,"c","cat");
			test_G(r,4,d,"d","dog");
			test_G_E(r,5,d,"e");
			test_G(r,6,d,"f","fan");
			test_G(r,7,d,"g","girl");
			test_G(r,8,d,"h","hat");
			test_G(r,9,d,"i","ink");
			d.remove(e4);
			test_S(r,10,d,7);
			test_G(r,11,d,"a","ant");
			test_G(r,12,d,"b","boy");
			test_G(r,13,d,"c","cat");
			test_G_E(r,14,d,"d");
			test_G_E(r,15,d,"e");
			test_G(r,16,d,"f","fan");
			test_G(r,17,d,"g","girl");
			test_G(r,18,d,"h","hat");
			test_G(r,19,d,"i","ink");
			d.remove(e1);
			test_S(r,20,d,6);
			test_G_E(r,21,d,"a");
			test_G(r,22,d,"b","boy");
			test_G(r,23,d,"c","cat");
			test_G_E(r,24,d,"d");
			test_G_E(r,25,d,"e");
			test_G(r,26,d,"f","fan");
			test_G(r,27,d,"g","girl");
			test_G(r,28,d,"h","hat");
			test_G(r,29,d,"i","ink");
			d.remove(e8);
			test_S(r,30,d,5);
			test_G_E(r,31,d,"a");
			test_G(r,32,d,"b","boy");
			test_G(r,33,d,"c","cat");
			test_G_E(r,34,d,"d");
			test_G_E(r,35,d,"e");
			test_G(r,36,d,"f","fan");
			test_G(r,37,d,"g","girl");
			test_G_E(r,38,d,"h");
			test_G(r,39,d,"i","ink");
			d.remove(e7);
			test_S(r,40,d,4);
			test_G_E(r,41,d,"a");
			test_G(r,42,d,"b","boy");
			test_G(r,43,d,"c","cat");
			test_G_E(r,44,d,"d");
			test_G_E(r,45,d,"e");
			test_G(r,46,d,"f","fan");
			test_G_E(r,47,d,"g");
			test_G_E(r,48,d,"h");
			test_G(r,49,d,"i","ink");
			d.remove(e2);
			test_S(r,50,d,3);
			test_G_E(r,51,d,"a");
			test_G_E(r,52,d,"b");
			test_G(r,53,d,"c","cat");
			test_G_E(r,54,d,"d");
			test_G_E(r,55,d,"e");
			test_G(r,56,d,"f","fan");
			test_G_E(r,57,d,"g");
			test_G_E(r,58,d,"h");
			test_G(r,59,d,"i","ink");
			d.remove(e9);
			test_S(r,60,d,2);
			test_G_E(r,61,d,"a");
			test_G_E(r,62,d,"b");
			test_G(r,63,d,"c","cat");
			test_G_E(r,64,d,"d");
			test_G_E(r,65,d,"e");
			test_G(r,66,d,"f","fan");
			test_G_E(r,67,d,"g");
			test_G_E(r,68,d,"h");
			test_G_E(r,69,d,"i");
			d.remove(e6);
			test_S(r,70,d,1);
			test_G_E(r,71,d,"a");
			test_G_E(r,72,d,"b");
			test_G(r,73,d,"c","cat");
			test_G_E(r,74,d,"d");
			test_G_E(r,75,d,"e");
			test_G_E(r,76,d,"f");
			test_G_E(r,77,d,"g");
			test_G_E(r,78,d,"h");
			test_G_E(r,79,d,"i");
			d.remove(e3);
			test_S(r,80,d,0);
			test_G_E(r,81,d,"a");
			test_G_E(r,82,d,"b");
			test_G_E(r,83,d,"c");
			test_G_E(r,84,d,"d");
			test_G_E(r,85,d,"e");
			test_G_E(r,86,d,"f");
			test_G_E(r,87,d,"g");
			test_G_E(r,88,d,"h");
			test_G_E(r,89,d,"i");
			System.out.print("Test 4\t");
			totalCorrect += check(r);

		System.out.printf("%d / %d correct \n",totalCorrect,totalCases);
		iterate();
	}

	static void iterate(){
		Dictionary d = new SortedArrayDictionary();
		Iterator<Entry> it;

		d.put("d","dog");
		d.put("c","cat");
		d.put("a","ant");
		d.put("b","boy");
		d.put("g","girl");
		d.put("i","ink");
		d.put("f","fan");
		d.put("e","egg");
		d.put("h","hat");


		d.put("b","ball");
		d.put("a","air");
		d.put("c","cone");
		d.put("a","age");
		d.put("a","art");
		d.put("b","bag");
		d.put("b","boat");
		d.put("c","can");
		d.put("f","fan");

		it = d.getAll("a");
		System.out.println("Get All: a");
		while(it.hasNext()){
			Entry e = it.next();
			System.out.println("\t" + e.getKey() + " : " + e.getValue());	
		}

		it = d.getAll("b");
		System.out.println("Get All: b");
		while(it.hasNext()){
			Entry e = it.next();
			System.out.println("\t" + e.getKey() + " : " + e.getValue());	
		}

		it = d.getAll("c");
		System.out.println("Get All: c");
		while(it.hasNext()){
			Entry e = it.next();
			System.out.println("\t" + e.getKey() + " : " + e.getValue());	
		}

		it = d.getAll("d");
		System.out.println("Get All: d");
		while(it.hasNext()){
			Entry e = it.next();
			System.out.println("\t" + e.getKey() + " : " + e.getValue());	
		}

		it = d.getAll("E");
		System.out.println("Get All: E");
		while(it.hasNext()){
			Entry e = it.next();
			System.out.println("\t" + e.getKey() + " : " + e.getValue());	
		}

		it = d.getAll("f");
		System.out.println("Get All: f");
		while(it.hasNext()){
			Entry e = it.next();
			System.out.println("\t" + e.getKey() + " : " + e.getValue());	
		}
		

		System.out.printf("Entries: %d\n", d.size());
		it = d.entries();
		while(it.hasNext()){
			Entry e = it.next();
			System.out.println("\t" + e.getKey() + " : " + e.getValue());
		}
	}

	static boolean[] results_array(int capacity){
		boolean[] results = new boolean[capacity];
		for(int i = 0; i < capacity; i++){
			results[i] = false;
		}
		return results;
	}

	static int check(boolean[] results){
		int correct = 0;
		for(int i = 0; i < results.length; i++){
			correct += results[i] ? 1 : 0;
		}
		boolean allCorrect = correct == results.length;
		if(allCorrect){
			System.out.println("OK");
		}else{
			System.out.printf("%d / %d\n",correct,results.length);
			for(int i = 0; i < results.length; i++){
				if(results[i] == false){
					System.out.printf("\t %d = WRONG\n",i);
				}
			}
		}
		return allCorrect ? 1 : 0;
	}

	static void test_S(boolean[] r, int i, Dictionary d, int size){
		r[i] = d.size() == size;
	}

	static void test_IE(boolean[] r, int i, Dictionary d, boolean isEmpty){
		r[i] = d.isEmpty() == isEmpty;
	}

	static void test_G_E(boolean[] r, int i, Dictionary d, String key){
		Entry e = d.get(key);
		r[i] = e == null;
	}

	static void test_G(boolean[] r, int i, Dictionary d, String key, Object value){
		Entry e = d.get(key);
		if(e == null){
			r[i] = false;
		}else{
			r[i] = e.getKey().equals(key) && e.getValue().equals(value);
		}
	}

	static void test_G_M(boolean[] r, int i, Dictionary d, String key, Object[] valueChoices){
		Entry e = d.get(key);
		if(e == null){
			r[i] = valueChoices.length == 0;
		}else{
			if(!(e.getKey().equals(key))){
				r[i] = false;
				return;
			}
			Object value = e.getValue();
			for(int x = 0; x < valueChoices.length; x++){
				if(value.equals(valueChoices[x])){
					r[i] = true;
					return;
				}
			}
			r[i] = false;
		}
	}

}