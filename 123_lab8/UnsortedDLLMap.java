import java.util.Iterator;
import java.util.NoSuchElementException;

public class UnsortedDLLMap implements Map{

	private DLLNode<Entry> headGuard;
	private DLLNode<Entry> tailGuard;
	private int size;

	public UnsortedDLLMap(){
		// TODO
		headGuard = new DLLNode <Entry>();
		tailGuard = new DLLNode <Entry>();
		headGuard.setNext(tailGuard);
		tailGuard.setPrev(headGuard);
		size = 0; 
	}

	public int size(){
		return this.size;
	}

	public boolean isEmpty(){
		return this.size == 0;
	}

	private DLLNode<Entry> findNode(String key){
		// TODO: Implement Linear Search
		// Return a DLLNode<Entry> object
		// Use the equals() method to compare keys
		DLLNode <Entry> node = headGuard.getNext();
		if (isEmpty()){
			return null;
		}
		while(!((node.getElement().getKey()).equals(key))){
			node = node.getNext();
			if (node.equals(tailGuard)){
				node = node.getPrev();
				break;
			}
		}
		if ((node.getElement().getKey()).equals(key)){
			return node;
		}else{
			return null;
		}
	}

	public Object get(String key){
		// TODO: Return value if key is found, else return null
		DLLNode<Entry> node = this.findNode(key);
		if (node != null){
			return node.getElement().getValue();
		}else{
			return null;
		}

	}

	public Object put(String key, Object value){
		// TODO: If key does not exist, add new entry to DLL, return null
		// TODO: If key exists, overwrite existing entry, return old value
		DLLNode<Entry> node = this.findNode(key);
		Entry newEntry = new Entry(key,value);
		if (node != null){ 								//if the key exists, return the value of the entry
			Entry oldEntry = node.getElement();
			node.setElement(newEntry);					//overwrite
			return oldEntry.getValue();					
		}else{
			DLLNode <Entry> newNode = new DLLNode<Entry>(newEntry);
			newNode.setNext(headGuard.getNext());		// insert first after the headguard
			(headGuard.getNext()).setPrev(newNode);
			headGuard.setNext(newNode);
			newNode.setPrev(headGuard);
			size++;
			return null;
		}
	}

	public Object remove(String key){
		// TODO: If key does not exist, return null
		// TODO: If key exists, remove entry, return value
		DLLNode<Entry> node = this.findNode(key);
		if (node != null){
			node.getPrev().setNext(node.getNext());
			node.getNext().setPrev(node.getPrev());
			node.setPrev(null);
			node.setNext(null);
			size--;
			return node.getElement().getValue();
		}else{
			return null;
		}
	}

	public Iterator<String> keys(){
		DLLNode<Entry> headGuard = this.headGuard;
		DLLNode<Entry> tailGuard = this.tailGuard;

		// Note: Use variables headGuard and tailGuard inside iterator
		return new Iterator<String>(){
			// TODO: Add property: DLLNode<Entry> node, and initialize its value
			DLLNode<Entry> node = headGuard;

			@Override
			public boolean hasNext(){
				// TODO: return boolean
				return (!(node.getNext().equals(tailGuard))); 		 
			}

			@Override
			public String next(){
				if(hasNext()){
					// TODO: return next key, and move forward
					node = node.getNext();
					return(node.getElement().getKey());
				}else{
					throw new NoSuchElementException("No more keys available.");
				}
			}

			@Override
			public void remove(){
				throw new UnsupportedOperationException("Removal not supported.");
			}
		};
	}

	public Iterator<Object> values(){
		DLLNode<Entry> headGuard = this.headGuard;
		DLLNode<Entry> tailGuard = this.tailGuard;
		
		// Note: Use variables headGuard and tailGuard inside iterator
		return new Iterator<Object>(){
			// TODO: Add property: DLLNode<Entry> node, and initialize its value
			DLLNode<Entry> node = headGuard;
			@Override
			public boolean hasNext(){
				// TODO: return boolean
				return (!(node.getNext().equals(tailGuard)));
			}

			@Override
			public Object next(){
				if(hasNext()){
					node = node.getNext();
					return(node.getElement().getValue());
					// TODO: return next value, and move forward
				}else{
					throw new NoSuchElementException("No more values available.");
				}
			}

			@Override
			public void remove(){
				throw new UnsupportedOperationException("Removal not supported.");
			}
		};
	}

	public Iterator<Entry> entries(){
		DLLNode<Entry> headGuard = this.headGuard;
		DLLNode<Entry> tailGuard = this.tailGuard;

		// Note: Use variables headGuard and tailGuard inside iterator
		return new Iterator<Entry>(){
			// TODO: Add property: DLLNode<Entry> node, and initialize its value
			DLLNode<Entry> node = headGuard;
			@Override
			public boolean hasNext(){
				// TODO: return boolean
				return (!(node.getNext().equals(tailGuard)));
			}

			@Override
			public Entry next(){
				if(hasNext()){
					// TODO: return next entry, and move forward
					node = node.getNext();
					return(node.getElement());
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
