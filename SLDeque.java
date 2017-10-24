/*
 * A class implementing an ADT QUEUE using a doubly linked node
 * @author Sana Talwar
 * @version 1.0
 */
import java.util.*;

public class SLDeque<T> implements DequeInterface<T> {
	private SLNode head;
	private SLNode tail;
	
	public SLDeque()
	{
		head = null;
		tail = null;
	}
	@Override
	public void addToFront(T newEntry) {
		{
			SLNode node = new SLNode(newEntry);
			if(isEmpty())
			{
				node.next = head;
				head = node;
				tail = node;
			}
			else
			{
				tail = node;
				head.next =  node;
				head = node;
			}
		}
	}

	@Override
	public void addToBack(T newEntry) 
	//create new node
	//check if empty = add as first
	//else - point tail to newEntry
	//point tail to node(new w/ newEntry)
	//point tail's pointer to null (full circle)
	
	{
		SLNode node = new SLNode(newEntry);
		if(isEmpty())
		{
			node.next = head;
			head = node;
			tail = node;
		}
		else
		{
			tail.next = node;
			tail = node;
			tail.next = null;
		}
	}

	@Override
	public T removeFront() {
		SLNode temp = head;
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		else if(head.next == null)
			tail = null;
		head = head.next;
		return temp.data;
	}

	@Override
	public T removeBack() {
		SLNode temp = tail;
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		else if(tail.next == null)
		{
			head = null;
		}
		tail = tail.next;
		return temp.data;
	}

	@Override
	public T getFront() {
		return head.data;
	}

	@Override
	public T getBack() 
	{
		return tail.data;
	}

	@Override
	public boolean isEmpty() 
	{
		return (head == null);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	public class SLNode {
		SLNode next;
		T data;
		
		public SLNode(T newEntry)
		{
            this.data  = newEntry;
        }
		
	}
}


