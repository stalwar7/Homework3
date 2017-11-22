
/*
 * A class implementing an ADT QUEUE using a singly linked node
 * @author Sana Talwar
 * @version 1.0
 */
import java.util.*;

public class SLDeque<T> implements DequeInterface<T> {
	private SLNode head;
	private SLNode tail;

	public SLDeque() {
		head = null;
		tail = null;
	}

	@Override
	public void addToFront(T newEntry) {
		SLNode node = new SLNode(newEntry);
		if (isEmpty()) {
			head = node;
			tail = node;
			tail.next = null;
		} else {
			SLNode temp = head;
			head = node;
			node.next = temp;
		}
	}

	@Override
	public void addToBack(T newEntry)
	// create new node
	// check if empty = add as first
	// else - point tail to newEntry
	// point tail to node(new w/ newEntry)
	// point tail's pointer to null (full circle)

	{
		SLNode node = new SLNode(newEntry);

		if (isEmpty()) {
			node.next = head;
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
			tail.next = null;
		}
	}

	@Override
	public T removeFront() {
		SLNode temp = head;
		if (isEmpty()) {
			throw new EmptyStackException();
		} else {
			head = head.next;
			return temp.data;
		}
	}

	@Override
	public T removeBack() {
		SLNode temp = tail;
		if (isEmpty()) {
			throw new EmptyStackException();
		} else {
			tail = tail.next;
			return temp.data;
		}
	}

	@Override
	public T getFront() {
		return head.data;
	}

	@Override
	public T getBack() {
		return tail.data;
	}

	@Override
	public boolean isEmpty() {
		return (head == null);
	}

	@Override
	public void clear() {
		while(head != null)
		{
			SLNode temp = head;
			head = null;
			head = temp.next;
		}

	}

	public class SLNode {
		SLNode next;
		T data;

		public SLNode(T newEntry) {
			this.data = newEntry;
		}

	}
}
