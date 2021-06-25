import java.util.Iterator;

public class Exercise8M{
	public static void main(String[] args){
		Map m = new UnsortedDLLMap();

		System.out.println("TESTING: Unsorted DLL Map");

		boolean[] r;
		int totalCorrect = 0;
		int totalCases = 5;

		// Test 1: Empty Map
			r = results_array(4);
			test_S(r,0,m,0);
			test_IE(r,1,m,true);
			test_G(r,2,m,"a",null);
			test_R(r,3,m,"b",null);
			System.out.print("Test 1\t");
			totalCorrect += check(r);

		// Test 2: First Put / Overwrite / Remove
			r = results_array(13); // 13
			test_P(r,0,m,"a","apple",null); // put: a = apple
			test_S(r,1,m,1);
			test_IE(r,2,m,false);
			test_G(r,3,m,"a","apple");
			test_P(r,4,m,"a","ant","apple"); // overwrite: a = ant
			test_S(r,5,m,1);
			test_IE(r,6,m,false);
			test_G(r,7,m,"a","ant"); 
			test_R(r,8,m,"a","ant"); // remove a
			test_S(r,9,m,0);
			test_IE(r,10,m,true);
			test_G(r,11,m,"a",null);
			test_R(r,12,m,"a",null);
			System.out.print("Test 2\t");
			totalCorrect += check(r);

		// Test 3: Put / Overwrite
			r = results_array(32);
			test_P(r,0,m,"a","apple",null);	// a : apple 
			test_S(r,1,m,1);
			test_G(r,2,m,"a","apple");
			test_P(r,3,m,"b","ball",null);	// b : ball
			test_G(r,4,m,"b","ball");
			test_G(r,5,m,"a","apple");
			test_S(r,6,m,2);
			test_P(r,7,m,"c","cat",null);	// c : cat
			test_S(r,8,m,3);
			test_G(r,9,m,"c","cat");
			test_G(r,10,m,"a","apple");
			test_G(r,11,m,"b","ball");
			test_P(r,12,m,"b","bat","ball"); 	// b : bat
			test_S(r,13,m,3);
			test_G(r,14,m,"b","bat");
			test_G(r,15,m,"c","cat");
			test_G(r,16,m,"a","apple");
			test_P(r,17,m,"d","dog",null);	// d : dog
			test_S(r,18,m,4);
			test_G(r,19,m,"d","dog");
			test_P(r,20,m,"a","ant","apple");	// a : ant
			test_S(r,21,m,4);
			test_G(r,22,m,"a","ant");
			test_P(r,23,m,"b","boy","bat");	// b : boy
			test_S(r,24,m,4);
			test_G(r,25,m,"b","boy");
			test_P(r,26,m,"e","egg",null);	// e : egg
			test_S(r,27,m,5);
			test_G(r,28,m,"e","egg");
			test_P(r,29,m,"e","elf","egg"); 	// e : elf
			test_S(r,30,m,5);
			test_G(r,31,m,"e","elf");
			System.out.print("Test 3\t");
			totalCorrect += check(r);

		// Test 4: Remove
			r = results_array(40);
			test_G(r,0,m,"a","ant");
			test_G(r,1,m,"b","boy");
			test_G(r,2,m,"c","cat");
			test_G(r,3,m,"d","dog");
			test_G(r,4,m,"e","elf");
			test_R(r,5,m,"c","cat");		// remove: c
			test_S(r,6,m,4);
			test_G(r,7,m,"a","ant");
			test_G(r,8,m,"b","boy");
			test_G(r,9,m,"c",null);
			test_G(r,10,m,"d","dog");
			test_G(r,11,m,"e","elf");
			test_R(r,12,m,"a","ant");		// remove: a
			test_S(r,13,m,3);
			test_G(r,14,m,"a",null);
			test_G(r,15,m,"b","boy");
			test_G(r,16,m,"d","dog");
			test_G(r,17,m,"e","elf");
			test_R(r,18,m,"c",null);		// remove: non-existent key
			test_S(r,19,m,3);
			test_R(r,20,m,"d","dog");		// remove: d
			test_S(r,21,m,2);
			test_G(r,22,m,"a",null);
			test_G(r,23,m,"b","boy");
			test_G(r,24,m,"c",null);
			test_G(r,25,m,"d",null);
			test_G(r,26,m,"e","elf");
			test_R(r,27,m,"b","boy");
			test_R(r,28,m,"e","elf");
			test_S(r,29,m,0);
			test_G(r,30,m,"a",null);
			test_G(r,31,m,"b",null);
			test_G(r,32,m,"c",null);
			test_G(r,33,m,"d",null);
			test_G(r,34,m,"e",null);
			test_R(r,35,m,"a",null);
			test_R(r,36,m,"b",null);
			test_R(r,37,m,"c",null);
			test_R(r,38,m,"d",null);
			test_R(r,39,m,"e",null);
			System.out.print("Test 4\t");
			totalCorrect += check(r);

		// Test 5: Mixed Put / Remove
			r = results_array(48);
			test_P(r,0,m,"a","angel",null); 		// put: A
			test_S(r,1,m,1);
			test_G(r,2,m,"a","angel");
			test_G(r,3,m,"b",null);
			test_P(r,4,m,"b","burger",null);		// put: B
			test_G(r,5,m,"a","angel");
			test_G(r,6,m,"b","burger");
			test_S(r,7,m,2);
			test_P(r,8,m,"b","ball","burger"); 		// put: B
			test_S(r,9,m,2);
			test_G(r,10,m,"a","angel");
			test_G(r,11,m,"b","ball");
			test_R(r,12,m,"a","angel"); 			// remove: A
			test_S(r,13,m,1);
			test_G(r,14,m,"a",null);
			test_G(r,15,m,"b","ball");
			test_P(r,16,m,"c","cat",null);			// put : C
			test_S(r,17,m,2);
			test_G(r,18,m,"a",null);
			test_G(r,19,m,"b","ball");
			test_G(r,20,m,"c","cat");
			test_R(r,21,m,"c","cat");				// remove : C
			test_S(r,22,m,1);
			test_G(r,23,m,"a",null);
			test_G(r,24,m,"b","ball");
			test_G(r,25,m,"c",null);
			test_P(r,26,m,"d","dog",null);			// put: D
			test_P(r,27,m,"a","ant",null);			// put: A
			test_S(r,28,m,3);
			test_G(r,29,m,"a","ant");
			test_G(r,30,m,"b","ball");
			test_G(r,31,m,"c",null);
			test_G(r,32,m,"d","dog");
			test_P(r,33,m,"c","cut",null);			// put: C
			test_P(r,34,m,"b","boy","ball");		// put: B
			test_S(r,35,m,4);
			test_G(r,36,m,"a","ant");
			test_G(r,37,m,"b","boy");
			test_G(r,38,m,"c","cut");
			test_G(r,39,m,"d","dog");
			test_R(r,40,m,"e",null);				// remove: E
			test_S(r,41,m,4);
			test_P(r,42,m,"e","egg",null);			// put: E
			test_G(r,43,m,"a","ant");
			test_G(r,44,m,"b","boy");
			test_G(r,45,m,"c","cut");
			test_G(r,46,m,"d","dog");
			test_G(r,47,m,"e","egg");

			System.out.print("Test 5\t");
			totalCorrect += check(r);

		System.out.printf("%d / %d correct \n",totalCorrect,totalCases);
		iterate(m);
	}

	static void iterate(Map m){
		System.out.println("Keys:");
		Iterator<String> it1 = m.keys();
		while(it1.hasNext()){
			System.out.println("\t" + it1.next());
		}
		System.out.println("Values:");
		Iterator<Object> it2 = m.values();
		while(it2.hasNext()){
			System.out.println("\t" + it2.next());
		}
		System.out.println("Entries:");
		Iterator<Entry> it3 = m.entries();
		while(it3.hasNext()){
			Entry e = it3.next();
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

	static void test_S(boolean[] r, int i, Map m, int size){
		r[i] = m.size() == size;
	}	

	static void test_IE(boolean[] r, int i, Map m, boolean isEmpty){
		r[i] = m.isEmpty() == isEmpty;
	}

	static void test_G(boolean[] r, int i, Map m, String key, Object returnValue){
		r[i] = m.get(key) == returnValue;
	}

	static void test_P(boolean[] r, int i, Map m, String key, Object value, Object returnValue){
		r[i] = m.put(key,value) == returnValue;
	}

	static void test_R(boolean[] r, int i, Map m, String key, Object returnValue){
		r[i] = m.remove(key) == returnValue;
	}


}