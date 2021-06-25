public class Entry implements Comparable<Entry>{
	private String key;
	private Object value;

	public Entry(){
		this("",null);
	}

	public Entry(String key, Object value){
		this.key = key;
		this.value = value;
	}

	public String getKey(){
		return this.key;
	}

	public Object getValue(){
		return this.value;
	}

	@Override
	public int compareTo(Entry other){
		return this.key.compareTo(other.getKey());
	}
}