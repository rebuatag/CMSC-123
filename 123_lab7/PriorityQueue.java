public interface PriorityQueue{
	public int size();

	public boolean isEmpty();

	public void insert(int key, Object value);

	public Entry removeMin() throws EmptyPQException;

	public Entry min() throws EmptyPQException;
}