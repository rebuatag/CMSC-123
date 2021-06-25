public class Exercise7{
	public static void main(String[] args){
		String choice = "unsorted";
		if(args.length > 0){
			choice = args[0].trim().toLowerCase();
		}

		if(!(choice.equals("sorted") || choice.equals("unsorted"))){
			System.out.println("Usage: java Exercise7 (sorted/unsorted)");
			System.exit(0);
		}

		PriorityQueue pq = null;
		if(choice.equals("sorted")){
			pq = new SortedPQ();
		}else if(choice.equals("unsorted")){
			pq = new UnsortedPQ();
		}

		System.out.printf("%s Priority Queue\n\n",choice.toUpperCase());

		boolean[] r;
		int totalCorrect = 0;
		int totalCases = 5;

		// Test 1: Empty PQ
		r = results_array(4);
		test_S(r,0,pq,0);
		test_IE(r,1,pq,true);
		test_RM_E(r,2,pq);
		test_M_E(r,3,pq);
		System.out.print("Test 1\t");
		totalCorrect += check(r);

		// Test 2: First Insert / Remove
		r = results_array(8);
		pq.insert(1,"a");
		test_S(r,0,pq,1);
		test_IE(r,1,pq,false);
		test_M(r,2,pq,1,"a");
		test_RM(r,3,pq,1,"a");
		test_S(r,4,pq,0);
		test_IE(r,5,pq,true);
		test_M_E(r,6,pq);
		test_RM_E(r,7,pq);
		System.out.print("Test 2\t");
		totalCorrect += check(r);

		// Test 3: Insert
		r = results_array(6);
		pq.insert(2,"silver");
		test_M(r,0,pq,2,"silver");
		test_S(r,1,pq,1);
		pq.insert(3,"bronze");
		test_S(r,2,pq,2);
		test_M(r,3,pq,2,"silver");
		pq.insert(1,"gold");
		test_M(r,4,pq,1,"gold");
		test_S(r,5,pq,3);
		System.out.print("Test 3\t");
		totalCorrect += check(r);

		// Test 4: Remove
		r = results_array(8);
		test_RM(r,0,pq,1,"gold");
		test_S(r,1,pq,2);
		test_M(r,2,pq,2,"silver");
		test_RM(r,3,pq,2,"silver");
		test_M(r,4,pq,3,"bronze");
		test_S(r,5,pq,1);
		test_RM(r,6,pq,3,"bronze");
		test_S(r,7,pq,0);
		System.out.print("Test 4\t");
		totalCorrect += check(r);

		// Test 5: Mixed Insert / Remove
		r = results_array(20);
		pq.insert(5,"e");		// e
		pq.insert(8,"h");		// e, h
		test_S(r,0,pq,2);
		test_M(r,1,pq,5,"e");
		pq.insert(6,"f"); 		// e, f, h
		test_S(r,2,pq,3);
		test_RM(r,3,pq,5,"e");	// f, h
		test_M(r,4,pq,6,"f");
		test_S(r,5,pq,2);
		pq.insert(7,"g");		// f, g, h
		test_M(r,6,pq,6,"f");
		test_S(r,7,pq,3);
		pq.insert(4,"d");		// d, f, g, h
		test_S(r,8,pq,4);
		test_M(r,9,pq,4,"d");
		pq.insert(10,"j");		// d, f, g, h, j
		test_S(r,10,pq,5);
		test_RM(r,11,pq,4,"d");	// f, g, h, j
		test_S(r,12,pq,4);
		pq.insert(3,"c");		// c, f, g, h, j
		test_S(r,13,pq,5);
		test_RM(r,14,pq,3,"c");	// f, g, h, j
		test_S(r,15,pq,4);
		pq.insert(9,"i");		// f, g, h, i, j
		test_RM(r,16,pq,6,"f");	// g, h, i, j
		test_RM(r,17,pq,7,"g");	// h, i, j
		test_M(r,18,pq,8,"h");
		test_S(r,19,pq,3);
		System.out.print("Test 5\t");
		totalCorrect += check(r);

		System.out.printf("%d / %d correct\n",totalCorrect,totalCases);


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

	static void test_S(boolean[] r, int i, PriorityQueue pq, int size){
		r[i] = pq.size() == size;
	}

	static void test_IE(boolean[] r, int i, PriorityQueue pq, boolean isEmpty){
		r[i] = pq.isEmpty() == isEmpty;
	}

	static void test_RM(boolean[] r, int i, PriorityQueue pq, int key, Object value){
		try{
			Entry e = pq.removeMin();
			r[i] = e.getKey() == key && e.getValue().equals(value);
		}catch(Exception e){
			r[i] = false;
		}
	}

	static void test_RM_E(boolean[] r, int i, PriorityQueue pq){
		try{
			pq.removeMin();
		}catch(EmptyPQException e){
			r[i] = e.message.equals("Empty PQ: cannot remove min");
		}catch(Exception e){
			r[i] = false;
		}
	}

	static void test_M(boolean[] r, int i, PriorityQueue pq, int key, Object value){
		try{
			Entry e = pq.min();
			r[i] = e.getKey() == key && e.getValue().equals(value);
		}catch(Exception e){
			r[i] = false;
		}
	}

	static void test_M_E(boolean[] r, int i, PriorityQueue pq){
		try{
			pq.min();
		}catch(EmptyPQException e){
			r[i] = e.message.equals("Empty PQ: cannot return min");
		}catch(Exception e){
			r[i] = false;
		}
	}

}