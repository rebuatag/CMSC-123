import java.util.Iterator;
import java.util.NoSuchElementException;

public class SortedArrayDictionary implements Dictionary{
	private Entry[] array;
	private int size;
	private static int NOT_FOUND = -1;

	public SortedArrayDictionary(){
		this.array = new Entry[100];
		this.size = 0;
	}

	public int size(){
		return this.size;
	}

	public boolean isEmpty(){
		return this.size == 0;
	}
	private int findIndex(String key,boolean includeInsert){
		// TODO: Implement binary search
		// Use compareTo(key) to compare:
		// midKey.compareTo(key) == 0 	--> midKey == key
		// midKey.compareTo(key) > 0 	--> midKey > key
		// midKey.compareTo(key) < 0 	--> midKey < key
		
		int frontIndex = 0;
		int backIndex = size-1;
		while (frontIndex<=backIndex){
			int midIndex = (frontIndex+backIndex) / 2;
			String midKey = array[midIndex].getKey();
			if (midKey.compareTo(key) == 0){
				return midIndex;
			}
			else if(midKey.compareTo(key) > 0){
				backIndex = midIndex - 1;
			}else{
				frontIndex = midIndex + 1;
			}			
		}
		if(includeInsert){
			return frontIndex;
			// TODO: return the correct insert position, if key is not found
		}
		return NOT_FOUND;
	}

	private int findIndex(Entry entry){
		// TODO: Modify the findIndex method above that uses Binary Search to find Entry, instead of key
		int frontIndex = 0;
		int backIndex = size-1;
		while (frontIndex<=backIndex){
			int midIndex = (frontIndex+backIndex)/2;
			String midKey = array[midIndex].getKey();
			Object midValue = array[midIndex].getValue();
			String key = entry.getKey();
			Object value = entry.getValue();
			if (midKey.compareTo(key) == 0){
				if(midValue.equals(value)){
					return midIndex;
				}
			}
			else if(midKey.compareTo(key) > 0){
				backIndex = midIndex - 1;
			}else{
				frontIndex = midIndex + 1;
			}			
		}
		return NOT_FOUND;	
	}

	public Entry get(String key){
		// TODO: Return any entry that matches key if it is found, else return null
		int index = this.findIndex(key,false); 						// includeInsert = false
		if (index !=-1){
			return array[index];
		}
		return null;
	}

	public Entry put(String key, Object value){
		// TODO: Move items forward, insert new Entry to correct index, return new Entry
		int index = this.findIndex(key,true); 						// includeInsert = true
		Entry newEntry = new Entry(key,value);
		if (size!=0){
			for (int i=size; i>index; i--){
				array[i]=array[i-1];
			}
		}
		array[index] = newEntry;
		size++;
		return newEntry;
	}

	public void remove(Entry entry){
		// TODO: If entry is found, remove entry, move items backward
		int index = this.findIndex(entry);
		if (index != -1){
			for (int i=index;i<size-1;i++){
				array[i] = array[i+1];
			}
			array[size-1] = null;
			size--;
		}
	}
	
	public Iterator<Entry> entries(){
		// TODO: initialize values for startIndex and limit
		// int startIndex = ?;
		// int limit = ?;
		Entry[] array = this.array;
		int startIndex = -1;
		int limit = size-1;

		// Note: Use variables array, startIndex, and limit inside iterator
		return new Iterator<Entry>(){
			// TODO: Add property int index, and initialize its value
			int index = startIndex;
			@Override
			public boolean hasNext(){
				// TODO: return boolean
				return(index!=limit);
			}

			@Override
			public Entry next(){
				if(hasNext()){
					// TODO: return next entry, and move forward
					index++;
					return array[index];
				}else{
					throw new NoSuchElementException("No more entries available.");
				}
			}

			@Override
			public void remove(){
				throw new UnsupportedOperationException("Removal not supported.");
			}
		};
	}

	public Iterator<Entry> getAll(String key){
		// TODO: initialize values for startIndex and limit
		// int startIndex = ?;		// Hint: use this.findIndex
		// int limit = ?;
		Entry[] array = this.array;
		
		int startIndex = this.findIndex(key, false);
		int limit = this.findIndex(key, false);
		int start, last;
		if (startIndex != -1){
			while((array[startIndex].getKey()).compareTo(key)==0){
				startIndex--;
				if (startIndex<0){
					break;
				}
			}
			
			while((array[limit].getKey()).compareTo(key)==0){
				limit++;
				if (limit==size){
					break;
				}
			}
			start= startIndex;
			last = limit-1;
		}else{
			start= 0;
			last = 0;
		}
	
		
		// Note: Use variables array, startIndex, and limit inside iterator
		return new Iterator<Entry>(){
			// TODO: Add property int index, and initialize its value
			int index = start;
			@Override
			public boolean hasNext(){
				// TODO: return boolean
				return(index!=last);
			}

			@Override
			public Entry next(){
				if(hasNext()){
					// TODO: return next entry, and move forward
					index++;
					return array[index];
				}else{
					throw new NoSuchElementException("No more entries available.");
				}
			}

			@Override
			public void remove(){
				throw new UnsupportedOperationException("Removal not supported.");
			}
		};
	}
}