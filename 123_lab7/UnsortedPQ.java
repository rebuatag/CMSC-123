public class UnsortedPQ implements PriorityQueue{
	private DLLNode<Entry> headGuard;
	private DLLNode<Entry> tailGuard;
	private int size;

	public UnsortedPQ(){
		// TODO
		// Create headGuard, tailGuard objects
		// Set up links
		// Set initial size value
		this.headGuard = new DLLNode<Entry>(null);
		this.tailGuard = new DLLNode<Entry>(null);
		this.size = 0;


		headGuard.setNext(tailGuard);
		tailGuard.setPrev(headGuard);
	}

	public int size(){
		return this.size;
	}

	public boolean isEmpty(){
		return this.size == 0;
	}

	public void insert(int key, Object value){
		// TODO
		// Create new Entry using key, value
		// Create new DLLNode<Entry>
		// Hint: Since PQ is unsorted, you can choose where to insert node quickly
		Entry item = new Entry(key,value);
		DLLNode<Entry> entry = new DLLNode<Entry>(item);

		if (isEmpty()){
			headGuard.setNext(entry);
			tailGuard.setPrev(entry);
			entry.setNext(tailGuard);
			entry.setPrev(headGuard);	
		}
		else{
			DLLNode<Entry> oldKey = headGuard.getNext();

			entry.setPrev(headGuard);
			headGuard.setNext(entry);
			entry.setNext(oldKey);
			oldKey.setPrev(entry);
			
		}
		this.size++;
	}

	public Entry removeMin() throws EmptyPQException{
		// TODO
		// Exception message: Empty PQ: cannot remove min
		// Use: findMin() to find the minNode
		// Remove min Entry from PQ and return it
		if (isEmpty()){ 
			throw new EmptyPQException("Empty PQ: cannot remove min");
		}
		else{
			DLLNode<Entry> min = findMin();
			DLLNode<Entry> next = min.getNext();
			DLLNode<Entry> prev = min.getPrev();

			min.setPrev(null);
			min.setNext(null);
			next.setPrev(prev);
			prev.setNext(next);
			this.size--;
			return min.getElement();
		}
	}

	public Entry min() throws EmptyPQException{
		// TODO
		// Exception message: Empty PQ: cannot return min
		// Use: findMin() to find the minNode
		// Return min Entry without removing it from PQ
		if (isEmpty()){
			throw new EmptyPQException("Empty PQ: cannot return min");
		}
		else{
			DLLNode<Entry> min = findMin();
			return min.getElement();
		}
	}

	private DLLNode<Entry> findMin() throws EmptyPQException{
		// TODO
		// Exception message: Empty PQ: cannot find min
		// Find the DLLNode<Entry> with minimum key
		// Used by removeMin() and min()
		if(isEmpty()){
			throw new EmptyPQException("Empty PQ: cannot find min");
		}
		else{
			DLLNode<Entry> minKey = headGuard.getNext();
			DLLNode<Entry> nextKey =  minKey.getNext();

			for (int i = 1; i < size() - 1; i++){
				if (minKey.getElement().getKey() > nextKey.getElement().getKey()){
					minKey = nextKey;
				}
				nextKey = nextKey.getNext();
			}
			return minKey;	
		}
	}
}