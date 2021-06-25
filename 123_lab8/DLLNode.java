public class DLLNode<E>{
	private E element;
	private DLLNode<E> next;
	private DLLNode<E> prev;

	public DLLNode(){
		this(null);
	}

	public DLLNode(E element){
		this.element = element;
		this.next = null;
		this.prev = null;
	}

	public void setElement(E element){
		this.element = element;
	}

	public E getElement(){
		return this.element;
	}

	public void setNext(DLLNode<E> nextNode){
		this.next = nextNode;
	}

	public DLLNode<E> getNext(){
		return this.next;
	}

	public void setPrev(DLLNode<E> prevNode){
		this.prev = prevNode;
	}

	public DLLNode<E> getPrev(){
		return this.prev;
	}
}