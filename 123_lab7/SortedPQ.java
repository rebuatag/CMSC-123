public class SortedPQ implements PriorityQueue{
	private DLLNode<Entry> headGuard;
	private DLLNode<Entry> tailGuard;
	private int size;

	public SortedPQ(){
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
		// Find the correct position to insert node into (maintain sortedness)
		// Insert new DLLNode into correct position
		
	}

	public Entry removeMin() throws EmptyPQException{
		// TODO
		// Exception message: Empty PQ: cannot remove min
		// Remove min Entry from PQ and return it
		// Hint: Since PQ is sorted, it is easy to find the min
	}

	public Entry min() throws EmptyPQException{
		// TODO
		// Exception message: Empty PQ: cannot return min
		// Return min Entry without removing it from PQ
		// Hint: Since PQ is sorted, it is easy to find the min
	}

}