public class Entry{
	private int key;
	private Object value;

	public Entry(){
		this(0,null);
	}

	public Entry(int key, Object value){
		this.key = key;
		this.value = value;
	}

	public int getKey(){
		return this.key;
	}

	public Object getValue(){
		return this.value;
	}
}