import java.util.Iterator;

public interface Dictionary{

	public int size();

	public boolean isEmpty();

	public Entry get(String key);

	public Entry put(String key, Object value);

	public void remove(Entry entry);
	
	public Iterator<Entry> entries();

	public Iterator<Entry> getAll(String key);
	
}