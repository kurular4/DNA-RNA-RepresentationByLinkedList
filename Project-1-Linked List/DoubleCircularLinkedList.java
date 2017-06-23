import DoublyLinkedList.Node;

public class DoubleCircularLinkedList<E> {
	
	private static class Node<E>
	{
		private E element;
		private Node<E> prev;
		private Node<E> next;
		
		public Node(E e, Node<E> p, Node<E> n)
		{
			element = e;
			prev = p;
			next = n;
		}
		
		public void setElement(E e) // I will need it in transcribing method to convert T to U
		{
			element = e;
		}
		
		public E getElement()
		{
			return element;
		}
		
		public Node<E> getPrev()
		{
			return prev;
		}
		
		public Node<E> getNext()
		{
			return next;
		}
		
		public void setPrev(Node<E> p)
		{
			prev = p;
		}
		
		public void setNext(Node<E> n)
		{
			next = n;
		}
		
	}
	
	private Node<E> head;
	private int size = 0;
	private String type; // It holds what the type of sequence is
	
	public DoubleCircularLinkedList()
	{
		head = new Node<E>(null, head, head);
	}
	
	public int size()
	{
		return size;
	}
	public boolean isEmpty() 
	{
        return size == 0;
    }
	
	public E first()
	{
		if(isEmpty())
			return null;
		return head.element;
	}
	
	public E last()
	{
		if(isEmpty())
			return null;
		return head.getPrev().element;
	}
		
	public void addFirst(E e)
	{
		if(isEmpty())
		{
			head = new Node<>(e,head,head);
			head.setNext(head);
			head.setPrev(head);
		}
		else
		{
			Node<E> a = head.prev;
			Node<E> newest = new Node<>(e, a, head);
			a.setNext(newest);
			head.setPrev(newest);
			head = newest;
		}
		size++;
	}
	
	public void removeFirst()
	{
		if(isEmpty())
			System.out.println("Empty slot, no removal");
		else
		{
		Node<E> predecessor = head.getPrev();
		Node<E> successor = head.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		head = successor;
		}
	}
	public String getType() 
	{
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String toString() // Print method of list
	{
		StringBuilder a = new StringBuilder();
		Node<E> walk = head;
		for(int i = 0; i<size; i++)
		{
			a.append(walk.getElement());
			walk = walk.getNext();
		}
		return a.toString();
	}
	
	
	public E get(int index) // I will need it in transcribing method
	{
		int i = 0;
		Node<E> walk = head;
		while(i < index)
		{
			walk = walk.getNext();
			i++;
		}
		
		return walk.getElement();
	}
	
	private Node<E> get2(int index) // This returns node at given index 
	{
		int i = 0;
		Node<E> walk = head;
		while(i < index)
		{
			walk = walk.getNext();
			i++;
		}
		
		return walk;
	}
	
	public void set(int index, E a) // It is also for transcribing method.
	{
		get2(index).setElement(a);
	}
	
	public DoubleCircularLinkedList<E> reverse() // It is also for transcribing method.
	{//We are here creating a new list that is the reverse form of the list
		DoubleCircularLinkedList<E> newest = new DoubleCircularLinkedList<>();
		Node<E> walk = head;
		while(!(walk == head.getPrev()))
		{
			newest.addFirst(walk.getElement());
			walk = walk.getNext();
		}
		newest.addFirst(walk.getElement());
		
		return newest;
	}

}
