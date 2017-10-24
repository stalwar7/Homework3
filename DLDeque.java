/*
 * A class implementing an ADT QUEUE using a doubly linked node
 * @author Sana Talwar
 * @version 1.0
 */

import java.util.*;

public class DLDeque<T> implements DequeInterface<T>{
	
	private DLNode next;					//pointer to beginning of line
	private DLNode previous;					//pointer to the end of line 
	
	public DLDeque()
	{
		next = null;
		previous = null;
	}
	
	public DLDeque(DLNode front)
	{
		next = front;
	}
	@Override
	public void addToFront(T newEntry) {
		//create a new Node
		//set it to the front
		//fix all pointers
		DLNode newNode = new DLNode(newEntry, null, next);
		if(isEmpty()) 
		{
			next = newNode;
			previous = newNode;
		}
		else 
        { 
        	newNode.head = next;
        	next.tail = newNode;
        	next = newNode;
        }
		
	}

	
	public void addToBack(T newEntry) {
		// create new node
		//set it to the back
		//fix all pointers
		
		DLNode newNode = new DLNode(newEntry, previous, null);
		if(isEmpty())
		{
			next = newNode;
			previous = newNode;
		}
		else
		{
			previous.head = newNode;
			newNode.tail = previous;
			previous = newNode;
		}
	}

	@Override
	public T removeFront() {
		//check if data is there ; if nothing throw Exception
		//hold data in temp variable
		//delete data in DLNode	(for security) //data = null
		//move head to other node which is next (check)
		//only if there is another DLNode move its previous to null
		T tempData = next.data;
		if(!isEmpty())
		{
			throw new EmptyStackException();
		}
		else
		{
			
			next = next.head;
			next.data = null;
		}
		
		return tempData;
	}

	@Override
	public T removeBack() {
		//check if data is there ; if nothing throw Exception
		//hold data in temp variable
		//delete data in DLNode	(for security) //data = null
		//move tail to previous 
		//only if there is another DLNode that tail is pointing move its next to null
		T tempData = previous.data;
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		else
		{
			DLNode back = previous.tail;
			previous = back;
			previous.head = null;
			
		}
		return tempData;
	}
	@Override
	public T getFront() {
		if(!isEmpty())
		{
		    return next.data;
		}
		else
			throw new EmptyStackException();
	}

	@Override
	public T getBack() {
		//DLNode newNode();
		//return newNode.tail;
		if(!isEmpty())
		{
		    return previous.data;
		}
		else
			throw new EmptyStackException();
	}

	@Override
	public boolean isEmpty() {
		return (next == null);
	}

	@Override
	public void clear() {
		if (isEmpty())
		{
			throw new EmptyStackException();
		}
		else
		{
			DLNode node = new DLNode(null, next, previous);
			while (!( previous.tail == null))
			{
				node.head = previous.tail;
				node.data = null;
				
			}
		}
		
		
	}
	
	public class DLNode{
		DLNode head;
		DLNode tail;
		T data;
		
		public DLNode(T newEntry, DLNode next, DLNode prev) {
            this.data  = newEntry;
            this.head = next;
            this.tail = prev;
        }
	}

}
