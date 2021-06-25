import java.util.Iterator;

public interface Map{

	public int size();

	public boolean isEmpty();

	public Object get(String key);

	public Object put(String key, Object value);

	public Object remove(String key);
	
	public Iterator<String> keys();

	public Iterator<Object> values();

	public Iterator<Entry> entries();
	
}